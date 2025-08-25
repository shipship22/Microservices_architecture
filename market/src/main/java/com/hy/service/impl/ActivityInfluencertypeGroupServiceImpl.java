package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.ActivityPlatformInfluencertypeGroupExcel;
import com.hy.mapper.ActivityPlatformInfluencertypeGroupMapper;
import com.hy.pojo.ActivityPlatformInfluencertypeGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.ActivityInfluencertypeGroupService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityInfluencertypeGroupServiceImpl implements ActivityInfluencertypeGroupService {

    @Autowired
    private ActivityPlatformInfluencertypeGroupMapper activityPlatformInfluencertypeGroupMapper;

    @Override
    public PageResult<ActivityPlatformInfluencertypeGroup> findActivityInfluencertypeGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityPlatformInfluencertypeGroup> list = activityPlatformInfluencertypeGroupMapper.findActivityInfluencertypeGroup(query);
        PageInfo<ActivityPlatformInfluencertypeGroup> info = new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void findInfluencertypeGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException {
        PageResult<ActivityPlatformInfluencertypeGroup> influencertypeGroup = findActivityInfluencertypeGroup(query);
        List<ActivityPlatformInfluencertypeGroup> list = influencertypeGroup.getList();

        // 将转换后的结果赋值给一个变量
        List<ActivityPlatformInfluencertypeGroupExcel> excelList = list.stream()
                .map(x -> {
                    ActivityPlatformInfluencertypeGroupExcel ex = new ActivityPlatformInfluencertypeGroupExcel();
                    BeanUtils.copyProperties(x, ex);
                    return ex;
                })
                .collect(Collectors.toList());

        String fileName = System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);

        EasyExcel.write(response.getOutputStream(), ActivityPlatformInfluencertypeGroupExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("达人类型")
                .doWrite(excelList);
    }
}