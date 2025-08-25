package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.mapper.ActivityPlatformContentGroupMapper;
import com.hy.mapper.ActivityPlatformGroupMapper;
import com.hy.pojo.ActivityPlatformGroup;
import com.hy.pojo.ConversionIncome;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.ActivityPlatformGroupService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ActivityPlatformGroupServiceImpl implements ActivityPlatformGroupService {
    @Autowired
    private ActivityPlatformGroupMapper activityPlatformGroupMapper;

    @Override
    public PageResult<ActivityPlatformGroup> findActivityPlatformGroupYJH(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityPlatformGroup> ac = activityPlatformGroupMapper.findActivityPlatformGroupYJH(query);
        PageInfo<ActivityPlatformGroup> info = new PageInfo<>(ac);
        return new PageResult<ActivityPlatformGroup>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void findActivityPlatformGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException {
        List<ActivityPlatformGroup> con = findActivityPlatformGroupYJH(query).getList();
        String fileName = System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =  ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);
        EasyExcel.write(response.getOutputStream(),ActivityPlatformGroup.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("分活动分媒介查询下载")
                .doWrite(con);
    }

}
