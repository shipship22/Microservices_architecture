package com.hy.exceltemp;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ActivityAlogAndDiffExcel {
    @ExcelProperty("活动名称")
    private String campaignName;

    @ExcelProperty("活动ID")
    private String campaignId;

    @ExcelProperty("开始日期")
    @ColumnWidth(value = 20)
    private Date startDate;

    @ExcelProperty("结束日期")
    @ColumnWidth(value = 20)
    private Date endDate;

    @ExcelProperty("花费")
    private BigDecimal cost;

    @ExcelProperty("监控率")
    private BigDecimal monitorRate;

    @ExcelProperty("曝光次数")
    private Long exposureCount;

    @ExcelProperty("曝光用户数")
    private Long exposureUserCount;

    @ExcelProperty("点击次数")
    private Long clickCount;

    @ExcelProperty("点击用户数")
    private Long clickUserCount;

    @ExcelProperty("月活会员数")
    private Long monthlyActiveMemberCount;

    @ExcelProperty("月活会员GMV")
    private BigDecimal monthlyActiveMemberGmv;

    @ExcelProperty("新会员获取数")
    private Long newMemberAcquisitionCount;

    @ExcelProperty("新会员GMV")
    private BigDecimal newMemberAcquisitionGmv;

    @ExcelProperty("周期月活用户数")
    private Long periodicMonthlyActiveUserCount;

    @ExcelProperty("周期月活用户GMV")
    private BigDecimal periodicMonthlyActiveUserGmv;

    @ExcelProperty("周期新会员数")
    private Long periodicNewMemberCount;

    @ExcelProperty("周期新会员GMV")
    private BigDecimal periodicNewMemberGmv;

    @ExcelProperty("次月月活会员数")
    private Long nextMonthActiveMemberCount;

    @ExcelProperty("次月月活会员GMV")
    private BigDecimal nextMonthActiveMemberGmv;

    @ExcelProperty("次月新会员数")
    private Long nextMonthNewMemberCount;

    @ExcelProperty("次月新会员GMV")
    private BigDecimal nextMonthNewMemberGmv;

    @ExcelProperty("活动类型")
    private String activityType;

    // 差异字段
    @ExcelProperty("花费差异")
    private BigDecimal costDiff;

    @ExcelProperty("监控率差异")
    private BigDecimal monitorRateDiff;

    @ExcelProperty("曝光次数差异")
    private Long exposureCountDiff;

    @ExcelProperty("曝光用户数差异")
    private Long exposureUserCountDiff;

    @ExcelProperty("点击次数差异")
    private Long clickCountDiff;

    @ExcelProperty("点击用户数差异")
    private Long clickUserCountDiff;

    @ExcelProperty("月活会员数差异")
    private Long monthlyActiveMemberCountDiff;

    @ExcelProperty("月活会员GMV差异")
    private BigDecimal monthlyActiveMemberGmvDiff;

    @ExcelProperty("新会员获取数差异")
    private Long newMemberAcquisitionCountDiff;

    @ExcelProperty("新会员GMV差异")
    private BigDecimal newMemberAcquisitionGmvDiff;

    @ExcelProperty("周期月活用户数差异")
    private Long periodicMonthlyActiveUserCountDiff;

    @ExcelProperty("周期月活用户GMV差异")
    private BigDecimal periodicMonthlyActiveUserGmvDiff;

    @ExcelProperty("周期新会员数差异")
    private Long periodicNewMemberCountDiff;

    @ExcelProperty("周期新会员GMV差异")
    private BigDecimal periodicNewMemberGmvDiff;

    @ExcelProperty("次月月活会员数差异")
    private Long nextMonthActiveMemberCountDiff;

    @ExcelProperty("次月月活会员GMV差异")
    private BigDecimal nextMonthActiveMemberGmvDiff;

    @ExcelProperty("次月新会员数差异")
    private Long nextMonthNewMemberCountDiff;

    @ExcelProperty("次月新会员GMV差异")
    private BigDecimal nextMonthNewMemberGmvDiff;

    // 计算指标差异
    @ExcelProperty("CPM差异")
    private BigDecimal cpmDiff;

    @ExcelProperty("月活ROI差异")
    private BigDecimal roiDiff;

    @ExcelProperty("月活CAC差异")
    private BigDecimal cacDiff;

    @ExcelProperty("月活会员贡献率差异")
    private BigDecimal mamcRateDiff;

    @ExcelProperty("月活GMV贡献率差异")
    private BigDecimal mamcGmvRateDiff;

    @ExcelProperty("拉新ROI差异")
    private BigDecimal rnmRoiDiff;

    @ExcelProperty("拉新CAC差异")
    private BigDecimal rnmCacDiff;

    @ExcelProperty("拉新会员贡献率差异")
    private BigDecimal nmcRateDiff;

    @ExcelProperty("拉新GMV贡献率差异")
    private BigDecimal nmcGmvRateDiff;

    @ExcelProperty("活动期人均月活GMV差异")
    private BigDecimal pcmaGmvDiff;

    @ExcelProperty("次月人均月活GMV差异")
    private BigDecimal mpcmaGmvDiff;

    @ExcelProperty("活动期人均拉新GMV差异")
    private BigDecimal pcnGmvDiff;

    @ExcelProperty("次月人均拉新GMV差异")
    private BigDecimal panGmvDiff;

    @ExcelProperty("月活次月留存率差异")
    private BigDecimal masmRateDiff;

    @ExcelProperty("拉新次月留存率差异")
    private BigDecimal mrrRateDiff;
}
