package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.ActivityPlatformInfluencergradeGroupExcel;
import com.hy.mapper.ActivityPlatformInfluencergradeGroupMapper;
import com.hy.pojo.ActivityPlatformGroup;
import com.hy.pojo.ActivityPlatformInfluencergradeGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.ActivityPlatformInfluencergradeGroupService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityPlatformInfluencergradeGroupImpl implements ActivityPlatformInfluencergradeGroupService {
    @Autowired
    private ActivityPlatformInfluencergradeGroupMapper activityPlatformInfluencergradeGroupMapper;

    @Override
    public PageResult<ActivityPlatformInfluencergradeGroup> findInfluencergradeGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityPlatformInfluencergradeGroup> list = activityPlatformInfluencergradeGroupMapper.findInfluencergradeGroup(query);
        PageInfo<ActivityPlatformInfluencergradeGroup> info = new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void findInfluencergradeGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException {
        PageResult<ActivityPlatformInfluencergradeGroup> influencergradeGroup = findInfluencergradeGroup(query);
        List<ActivityPlatformInfluencergradeGroup> list = influencergradeGroup.getList();

        // 将转换后的结果赋值给一个变量
        List<ActivityPlatformInfluencergradeGroupExcel> excelList = list.stream()
                .map(x -> {
                    ActivityPlatformInfluencergradeGroupExcel ex = new ActivityPlatformInfluencergradeGroupExcel();
                    BeanUtils.copyProperties(x, ex);
                    return ex;
                })
                .collect(Collectors.toList());

        String fileName = System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);

        EasyExcel.write(response.getOutputStream(), ActivityPlatformInfluencergradeGroupExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("达人等级")
                .doWrite(excelList);  // 使用定义好的excelList变量
    }
}
