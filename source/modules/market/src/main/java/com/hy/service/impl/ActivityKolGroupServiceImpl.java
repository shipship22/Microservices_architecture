package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hy.exceltemp.*;
import com.hy.mapper.ActivityKolGroupMapper;
import com.hy.pojo.*;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.service.*;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityKolGroupServiceImpl implements ActivityKolGroupService {

    @Autowired
    private ActivityKolGroupMapper activityKolGroupMapper;

    @Autowired
    private ActivityGroupService activityGroupService;

    @Autowired
    private ActivityPlatformGroupService activityPlatformGroupService;

    @Autowired
    private ActivityPlatformContentGroupService activityPlatformContentGroupService;

    @Autowired
    private ActivityDirectionGroupService activityDirectionGroupService;

    @Autowired
    private ActivityPlatformInfluencergradeGroupService activityPlatformInfluencergradeGroupService;

    @Autowired
    private ActivityInfluencertypeGroupService activityInfluencertypeGroupService;

    @Override
    public PageResult<ActivityKolGroup> findActivityKolGroup(PageResultQuery query) {
        PageHelper.startPage(query.getPageNum(), query.getPageSize());
        List<ActivityKolGroup> list = activityKolGroupMapper.findActivityKolGroup(query);
        PageInfo<ActivityKolGroup> info = new PageInfo<>(list);
        return new PageResult<>(info.getPageNum(), info.getPageNum(), info.getList(), info.getTotal());
    }

    @Override
    public void findActivityKolGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException {
        PageResult<ActivityKolGroup> page = findActivityKolGroup(query);
        List<ActivityKolGroup> list = page.getList();

        // 将转换后的结果赋值给一个变量
        List<ActivityKolGroupExcel> collect = list.stream()
                .map(x -> {
                    ActivityKolGroupExcel ex = new ActivityKolGroupExcel();
                    BeanUtils.copyProperties(x, ex);
                    return ex;
                })
                .collect(Collectors.toList());

        String fileName = System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName);

        EasyExcel.write(response.getOutputStream(), ActivityKolGroupExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("KOL名称")
                .doWrite(collect);
    }

    @Override
    public void kolDl(PageResultQuery query, HttpServletResponse response) throws IOException {
        switch (query.getStatus()) {
            case 1:
                List<ActivityGroup> list1 = activityGroupService.findActivityGroupYJH(query.getCname());


                List<ActivityGroupExcel> excelList1 = list1.stream()
                        .map(x -> {
                            ActivityGroupExcel ex = new ActivityGroupExcel();
                            BeanUtils.copyProperties(x, ex);
                            return ex;
                        })
                        .collect(Collectors.toList());

                String fileName1 = System.currentTimeMillis() + "";
                HorizontalCellStyleStrategy horizontalCellStyleStrategy1 = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName1);

                EasyExcel.write(response.getOutputStream(), ActivityGroupExcel.class)
                        .registerWriteHandler(horizontalCellStyleStrategy1)
                        .sheet("分活动")
                        .doWrite(excelList1);
                return;
            case 2:
                PageResult<ActivityPlatformGroup> platformGroups = activityPlatformGroupService.findActivityPlatformGroupYJH(query);
                List<ActivityPlatformGroup> list2 = platformGroups.getList();

                List<ActivityPlatformGroupExcel> excelList2 = list2.stream()
                        .map(x -> {
                            ActivityPlatformGroupExcel ex = new ActivityPlatformGroupExcel();
                            BeanUtils.copyProperties(x, ex);
                            return ex;
                        })
                        .collect(Collectors.toList());

                String fileName2 = System.currentTimeMillis() + "";
                HorizontalCellStyleStrategy horizontalCellStyleStrategy2 = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName2);

                EasyExcel.write(response.getOutputStream(), ActivityPlatformGroupExcel.class)
                        .registerWriteHandler(horizontalCellStyleStrategy2)
                        .sheet("分活动分媒介")
                        .doWrite(excelList2);
                return;
            case 3:
                PageResult<ActivityPlatformContentGroup> contentGroups = activityPlatformContentGroupService.findActivityPlatformContentGroup(query);
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
                return;
            case 4:
                PageResult<ActivityPlatformContentDirectionGroup> directionGroups = activityDirectionGroupService.findActivityDirectionGroup(query);
                List<ActivityPlatformContentDirectionGroup> list4 = directionGroups.getList();

                List<ActivityDirectionGroupExcel> excelList4 = list4.stream()
                        .map(x -> {
                            ActivityDirectionGroupExcel ex = new ActivityDirectionGroupExcel();
                            BeanUtils.copyProperties(x, ex);
                            return ex;
                        })
                        .collect(Collectors.toList());

                String fileName4 = System.currentTimeMillis() + "";
                HorizontalCellStyleStrategy horizontalCellStyleStrategy4 = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName4);

                EasyExcel.write(response.getOutputStream(), ActivityDirectionGroupExcel.class)
                        .registerWriteHandler(horizontalCellStyleStrategy4)
                        .sheet("分活动分媒介分内容方向")
                        .doWrite(excelList4);
                return;
            case 5:
                PageResult<ActivityPlatformInfluencergradeGroup> influencergradeGroup = activityPlatformInfluencergradeGroupService.findInfluencergradeGroup(query);
                List<ActivityPlatformInfluencergradeGroup> list5 = influencergradeGroup.getList();

                List<ActivityPlatformInfluencergradeGroupExcel> excelList5 = list5.stream()
                        .map(x -> {
                            ActivityPlatformInfluencergradeGroupExcel ex = new ActivityPlatformInfluencergradeGroupExcel();
                            BeanUtils.copyProperties(x, ex);
                            return ex;
                        })
                        .collect(Collectors.toList());

                String fileName5 = System.currentTimeMillis() + "";
                HorizontalCellStyleStrategy horizontalCellStyleStrategy5 = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName5);

                EasyExcel.write(response.getOutputStream(), ActivityPlatformInfluencergradeGroupExcel.class)
                        .registerWriteHandler(horizontalCellStyleStrategy5)
                        .sheet("分活动分媒介分达人等级")
                        .doWrite(excelList5);
                return;
            case 6:
                PageResult<ActivityPlatformInfluencertypeGroup> influencertypeGroup = activityInfluencertypeGroupService.findActivityInfluencertypeGroup(query);
                List<ActivityPlatformInfluencertypeGroup> list6 = influencertypeGroup.getList();

                List<ActivityPlatformInfluencertypeGroupExcel> excelList6 = list6.stream()
                        .map(x -> {
                            ActivityPlatformInfluencertypeGroupExcel ex = new ActivityPlatformInfluencertypeGroupExcel();
                            BeanUtils.copyProperties(x, ex);
                            return ex;
                        })
                        .collect(Collectors.toList());

                String fileName6 = System.currentTimeMillis() + "";
                HorizontalCellStyleStrategy horizontalCellStyleStrategy6 = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName6);

                EasyExcel.write(response.getOutputStream(), ActivityPlatformInfluencertypeGroupExcel.class)
                        .registerWriteHandler(horizontalCellStyleStrategy6)
                        .sheet("分活动分媒介分达人类型")
                        .doWrite(excelList6);
                return;
            case 7:
                PageResult<ActivityKolGroup> page7 = findActivityKolGroup(query);
                List<ActivityKolGroup> list7 = page7.getList();

                List<ActivityKolGroupExcel> excelList7 = list7.stream()
                        .map(x -> {
                            ActivityKolGroupExcel ex = new ActivityKolGroupExcel();
                            BeanUtils.copyProperties(x, ex);
                            return ex;
                        })
                        .collect(Collectors.toList());

                String fileName7 = System.currentTimeMillis() + "";
                HorizontalCellStyleStrategy horizontalCellStyleStrategy7 = ExcelUtil.getHorizontalCellStyleStrategy(response, fileName7);

                EasyExcel.write(response.getOutputStream(), ActivityKolGroupExcel.class)
                        .registerWriteHandler(horizontalCellStyleStrategy7)
                        .sheet("分活动分帖子")
                        .doWrite(excelList7);
        }
    }
}
