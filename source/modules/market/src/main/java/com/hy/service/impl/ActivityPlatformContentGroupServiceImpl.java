package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.ActivityPlatformContentGroupExcel;
import com.hy.mapper.ActivityPlatformContentGroupMapper;
import com.hy.mapper.ActivityPlatformGroupMapper;
import com.hy.pojo.ActivityPlatformContentGroup;
import com.hy.pojo.MediaSlot;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.ActivityPlatformContentGroupService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityPlatformContentGroupServiceImpl implements ActivityPlatformContentGroupService {
    @Autowired
    public ActivityPlatformContentGroupMapper activityPlatformContentGroupMapper;

    @Override
    public PageResult<ActivityPlatformContentGroup> findActivityPlatformContentGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityPlatformContentGroup> list = activityPlatformContentGroupMapper.findActivityPlatformContentGroup(query);
        PageInfo<ActivityPlatformContentGroup> info = new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void findActivityPlatformContentGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException {
        PageResult<ActivityPlatformContentGroup> contentGroups = findActivityPlatformContentGroup(query);
        List<ActivityPlatformContentGroup> list3 = contentGroups.getList();

        List<ActivityPlatformContentGroupExcel> excelList3 = list3.stream()
                .map(x -> {
                    ActivityPlatformContentGroupExcel ex = new ActivityPlatformContentGroupExcel();
                    BeanUtils.copyProperties(x, ex);
                    return ex;
                })
                .collect(Collectors.toList());

        String fileName3 = System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy horizontalCellStyleStrategy3 = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName3);

        EasyExcel.write(response.getOutputStream(), ActivityPlatformContentGroupExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy3)
                .sheet("分活动分媒介分内容形式")
                .doWrite(excelList3);
    }
}
