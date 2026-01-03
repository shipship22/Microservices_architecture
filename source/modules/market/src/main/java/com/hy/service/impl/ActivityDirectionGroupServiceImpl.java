package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.ActivityDirectionGroupExcel;
import com.hy.mapper.ActivityPlatformContentDirectionGroupMapper;
import com.hy.pojo.ActivityGroup;
import com.hy.pojo.ActivityPlatformContentDirectionGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.result.Result;
import com.hy.service.ActivityDirectionGroupService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityDirectionGroupServiceImpl implements ActivityDirectionGroupService {

    @Autowired
    private ActivityPlatformContentDirectionGroupMapper activityPlatformContentDirectionGroupMapper;

    @Override
    public PageResult<ActivityPlatformContentDirectionGroup> findActivityDirectionGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityPlatformContentDirectionGroup> list = activityPlatformContentDirectionGroupMapper.findActivityDirectionGroup(query);
        PageInfo<ActivityPlatformContentDirectionGroup> info = new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(),info.getPageSize(),info.getList(),info.getTotal());
    }

    @Override
    public void findActivityDirectionGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException {
        PageResult<ActivityPlatformContentDirectionGroup> page = findActivityDirectionGroup(query);
        //获取 PageResult 中的数据集合
        List<ActivityPlatformContentDirectionGroup> list = page.getList();

        //拷贝数据List<ActivityPlatformContentDirectionGroup>
        List<ActivityDirectionGroupExcel> collect = list.stream().map((x)-> {
            ActivityDirectionGroupExcel ex = new ActivityDirectionGroupExcel();
            extracted(x, ex);
            return ex;
        }).collect(Collectors.toList());

        //分页逻辑
        String fileName = System.currentTimeMillis() + "";

        //获取样式信息
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);

        //发送下载请求
        EasyExcel.write(response.getOutputStream(), ActivityDirectionGroupExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("分内容方向查询")
                .doWrite(collect);
    }

    private static void extracted(ActivityPlatformContentDirectionGroup x, ActivityDirectionGroupExcel ex) {
        BeanUtils.copyProperties(x, ex);
        ex.setCpm(x.getCpm());
        ex.setRoi(x.getRoi());
        ex.setCac(x.getCac());
        ex.setMamcRate(x.getMamcRate());
        ex.setMamcGmvRate(x.getMamcGmvRate());
        ex.setRnmRoi(x.getRnmRoi());
        ex.setRnmCac(x.getRnmCac());
        ex.setNmcRate(x.getNmcRate());
        ex.setNmcGmvRate(x.getNmcGmvRate());
        ex.setPcmaGmv(x.getPcmaGmv());
        ex.setMpcmaGmv(x.getMpcmaGmv());
        ex.setPcnGmv(x.getPcnGmv());
        ex.setPanGmv(x.getPanGmv());
        ex.setMasmRate(x.getMasmRate());
        ex.setMrrRate(x.getMrrRate());
    }
}
