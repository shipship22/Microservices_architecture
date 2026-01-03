package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.PlatformDeliverExcel;
import com.hy.exceltemp.PlatformDeliverPointExcel;
import com.hy.mapper.ActivityMediaSlotAnalysisMapper;
import com.hy.pojo.MediaSlot;
import com.hy.pojo.MediaSoltWithoutContactPoint;
import com.hy.pojo.PlatBean;
import com.hy.result.PageResult;
import com.hy.service.ActivityMediaSlotAnalysisService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ActivityMediaSlotAnalysisServiceImpl implements ActivityMediaSlotAnalysisService {
    @Autowired
    private ActivityMediaSlotAnalysisMapper activityMediaSlotAnalysisMapper;

    @Override
    public List<String> findContactPointYJH() {
        return activityMediaSlotAnalysisMapper.findContactPointYJH();
    }

    @Override
    public PageResult<MediaSlot> findMediaSlotYJH(String cid, String point, String orderfiled, String orderTe, Integer pageNum, Integer pageSize, String media) {
        PageHelper.startPage(pageNum, pageSize);
        List<MediaSlot> mediaSlot = activityMediaSlotAnalysisMapper.findMediaSlotYJH(cid, point, orderfiled, orderTe, pageNum, pageSize, media);
        PageInfo<MediaSlot> info = new PageInfo<>(mediaSlot);
        return new PageResult<MediaSlot>(info.getPageNum(), info.getPageSize(), info.getList(), info.getTotal());
    }

    @Override
    public List<String> findAllMediaYJH() {
        return activityMediaSlotAnalysisMapper.findAllMediaYJH();
    }

    @Override
    public void findMediaSlotDownloadYJH(HttpServletResponse response, String cid, String point, String orderfiled, String orderTe, Integer pageNum, Integer pageSize, String media) throws IOException {
        PageResult<MediaSlot> con = findMediaSlotYJH(cid, point, orderfiled, orderTe, pageNum, pageSize, media);
        String fileName = System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);
        EasyExcel.write(response.getOutputStream(), MediaSoltWithoutContactPoint.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("查询媒介归因排名")
                .doWrite(con.getList());
    }

    @Override
    public void findAllMediaDownloadYJH(HttpServletResponse response, String cid, String point, String orderfiled, String orderTe, Integer pageNum, Integer pageSize, String media) throws IOException {
        PageResult<MediaSlot> con = findMediaSlotYJH(cid, point, orderfiled, orderTe, pageNum, pageSize, media);
        String fileName = System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);
        EasyExcel.write(response.getOutputStream(), MediaSlot.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("查询媒介归因排名")
                .doWrite(con.getList());
    }

    @Override
    public Map<String, Map<String, List<PlatBean>>> platformDeliverComparsion(String cidA, String cidB, String filed) {
        List<PlatBean> platBeans = activityMediaSlotAnalysisMapper.platformDeliverComparsion(cidA, cidA, filed);
        Map<Object, List<PlatBean>> collect = platBeans.stream().collect(Collectors.groupingBy((x) -> x.getCid()));

        HashMap<String, Map<String, List<PlatBean>>> map = new HashMap<>();
        collect.forEach((k, v) -> {
            Map<String, List<PlatBean>> collect1 = v.stream().collect(Collectors.groupingBy((y) -> y.getMedia()));
            map.put((String) k, collect1);
        });
        return map;
    }

    @Override
    public void platformDeliverComparsionDl(HttpServletResponse response, String cidA, String cidB, String filed) throws IOException {
        List<PlatBean> platBeans = activityMediaSlotAnalysisMapper.platformDeliverComparsion(cidA, cidA, filed);
        List<PlatformDeliverExcel> collect = platBeans.stream().map((x) -> {
            PlatformDeliverExcel p = new PlatformDeliverExcel();
            BeanUtils.copyProperties(x, p);
            return p;
        }).collect(Collectors.toList());
        String fileName = URLEncoder.encode("平台投放对比" + System.currentTimeMillis(), "utf-8");
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);
        EasyExcel.write(response.getOutputStream(), PlatformDeliverExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("媒介平台构成对比")
                .doWrite(collect);
    }

    @Override
    public Map<String, Map<String, List<PlatBean>>> distributionOfSubMediaPlatforms(String cidA, String cidB, String filed) {
        List<PlatBean> platBeans = activityMediaSlotAnalysisMapper.distributionOfSubMediaPlatforms(cidA, cidB, filed);
        Map<String, List<PlatBean>> collect = platBeans.stream().collect(Collectors.groupingBy((x) -> x.getMedia()));
        Map<String, Map<String, List<PlatBean>>> mm = new HashMap<>();

        collect.forEach((k, v) -> {
            Map<String, List<PlatBean>> map = v.stream().collect(Collectors.groupingBy((x) -> x.getCname()));
            mm.put(k, map);
        });
        return mm;
    }

    @Override
    public void distributionOfSubMediaPlatformsDl(HttpServletResponse response, String cidA, String cidB, String filed) throws Exception {
        List<PlatBean> platBeans = activityMediaSlotAnalysisMapper.distributionOfSubMediaPlatforms(cidA, cidB, filed);
        List<PlatformDeliverExcel> collect = platBeans.stream().map((x) -> {
            PlatformDeliverExcel pe = new PlatformDeliverExcel();
            BeanUtils.copyProperties(x, pe);
            return pe;
        }).collect(Collectors.toList());
        String filename = URLEncoder.encode("分媒介平台分布" + System.currentTimeMillis(), "utf-8");
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, filename);
        EasyExcel.write(response.getOutputStream(), PlatformDeliverExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("分媒介平台分布")
                .doWrite(collect);
    }

    @Override
    public Map<String, Map<String, List<PlatBean>>> contactTypeComposition(String cidA, String cidB, String filed) {
        List<PlatBean> list = activityMediaSlotAnalysisMapper.contactTypeComposition(cidA, cidB, filed);
        Map<String, List<PlatBean>> map = list.stream().collect(Collectors.groupingBy((x) -> x.getMedia()));

        HashMap<String, Map<String, List<PlatBean>>> mm = new HashMap<>();

        map.forEach((k, v) -> {
            Map<String, List<PlatBean>> collect = v.stream().collect(Collectors.groupingBy((y) -> y.getCname()));
            mm.put(k, collect);
        });

        return mm;
    }

    @Override
    public void contactTypeCompositionDl(HttpServletResponse response, String cidA, String cidB, String filed) throws IOException {
        List<PlatBean> list = activityMediaSlotAnalysisMapper.contactTypeComposition(cidA, cidB, filed);
        List<PlatformDeliverPointExcel> pointlist = list.stream().map((x) -> {
            PlatformDeliverPointExcel ex = new PlatformDeliverPointExcel();
            BeanUtils.copyProperties(x, ex);
            return ex;
        }).collect(Collectors.toList());
        String filename = URLEncoder.encode("分媒介分触点类型构成" + System.currentTimeMillis(), "utf-8");
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, filename);
        EasyExcel.write(response.getOutputStream(), PlatformDeliverPointExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("分媒介分触点类型构成")
                .doWrite(pointlist);
    }

    @Override
    public Map<String, List<PlatBean>> contactPointDistribution(String cidA, String cidB, String filed, String media) {
        List<PlatBean> list = activityMediaSlotAnalysisMapper.contactPointDistribution(cidA, cidA, filed, media);

        Map<String, List<PlatBean>> map = list.stream().collect(Collectors.groupingBy((x) -> x.getMedia()));

        HashMap<String, List<PlatBean>> mm = new HashMap<>();

        map.forEach((k, v) -> {

            Map<String, List<PlatBean>> m = v.stream().collect(Collectors.groupingBy((x) -> x.getPoint()));

            m.forEach((k1, v1) -> {
                mm.put(k + "-" + k1, v1);
            });
        });

        return mm;
    }

    @Override
    public void contactPointDistributionDl(HttpServletResponse response, String cidA, String cidB, String filed,String media) throws IOException {
        List<PlatBean> platBeans = activityMediaSlotAnalysisMapper.contactPointDistribution(cidA, cidB, filed, media);
        List<PlatformDeliverPointExcel> collect = platBeans.stream().map((x) -> {
            PlatformDeliverPointExcel pe = new PlatformDeliverPointExcel();
            BeanUtils.copyProperties(x, pe);
            return pe;
        }).collect(Collectors.toList());
        String filename = URLEncoder.encode("分媒介分触点类型分布" + System.currentTimeMillis(), "utf-8");
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, filename);
        EasyExcel.write(response.getOutputStream(), PlatformDeliverPointExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("分媒介分触点类型分布")
                .doWrite(collect);
    }

}