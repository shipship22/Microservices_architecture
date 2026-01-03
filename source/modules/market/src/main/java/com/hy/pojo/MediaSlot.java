package com.hy.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class MediaSlot {
    @ExcelProperty("活动名称")
    private String campaignName;

    @ExcelProperty("媒体平台")
    private String media;

    @ExcelProperty("触点类型")
    private String contactPoint;

    @ExcelProperty("活动ID")
    private String campaignId;

    @ExcelProperty("开始日期")
    private Date startDate;

    @ExcelProperty("结束日期")
    private Date endDate;

    @ExcelProperty("总花费")
    private BigDecimal cost;

    @ExcelProperty("曝光次数")
    private Long exposureCount;

    @ExcelProperty("曝光人数")
    private Long exposureUserCount;

    @ExcelProperty("点击次数")
    private Long clickCount;

    @ExcelProperty("点击人数")
    private Long clickUserCount;

    @ExcelProperty("月活跃会员数")
    private Long monthlyActiveMemberCount;

    @ExcelProperty("月活会员GMV")
    private BigDecimal monthlyActiveMemberGmv;

    @ExcelProperty("拉新会员数")
    private Long newMemberAcquisitionCount;

    @ExcelProperty("拉新会员GMV")
    private BigDecimal newMemberAcquisitionGmv;

    @ExcelProperty("次月活跃会员数")
    private Long nextMonthActiveMemberCount;

    @ExcelProperty("次月活跃会员GMV")
    private BigDecimal nextMonthActiveMemberGmv;

    @ExcelProperty("次月新会员数")
    private Long nextMonthNewMemberCount;

    @ExcelProperty("次月新会员GMV")
    private BigDecimal nextMonthNewMemberGmv;

    // 核心指标
    @ExcelProperty("千次曝光成本(CPM)")
    private BigDecimal cpm;

    @ExcelProperty("月活会员ROI")
    private BigDecimal roi;

    @ExcelProperty("月活会员获客成本(CAC)")
    private BigDecimal cac;

    @ExcelProperty("月活会员贡献率")
    private BigDecimal mamcRate;

    @ExcelProperty("月活会员GMV贡献率")
    private BigDecimal mamcGmvRate;

    @ExcelProperty("拉新会员ROI")
    private BigDecimal rnmRoi;

    @ExcelProperty("拉新会员获客成本(CAC)")
    private BigDecimal rnmCac;

    @ExcelProperty("拉新会员贡献率")
    private BigDecimal nmcRate;

    @ExcelProperty("拉新会员GMV贡献率")
    private BigDecimal nmcGmvRate;

    @ExcelProperty("活动期人均月活GMV")
    private BigDecimal pcmaGmv;

    @ExcelProperty("次月人均月活GMV")
    private BigDecimal mpcmaGmv;

    @ExcelProperty("活动期人均拉新GMV")
    private BigDecimal pcnGmv;

    @ExcelProperty("次月人均拉新GMV")
    private BigDecimal panGmv;

    @ExcelProperty("月活次月留存率")
    private BigDecimal masmRate;

    @ExcelProperty("拉新次月留存率")
    private BigDecimal mrrRate;

    // 均值指标
    @ExcelProperty("平均千次曝光成本")
    private BigDecimal cpmAvg;

    @ExcelProperty("平均月活会员ROI")
    private BigDecimal roiAvg;

    @ExcelProperty("平均月活会员获客成本")
    private BigDecimal cacAvg;

    @ExcelProperty("平均月活会员贡献率")
    private BigDecimal mamcRateAvg;

    @ExcelProperty("平均月活会员GMV贡献率")
    private BigDecimal mamcGmvRateAvg;

    @ExcelProperty("平均拉新会员ROI")
    private BigDecimal rnmRoiAvg;

    @ExcelProperty("平均拉新会员获客成本")
    private BigDecimal rnmCacAvg;

    @ExcelProperty("平均拉新会员贡献率")
    private BigDecimal nmcRateAvg;

    @ExcelProperty("平均拉新会员GMV贡献率")
    private BigDecimal nmcGmvRateAvg;

    @ExcelProperty("平均活动期人均月活GMV")
    private BigDecimal pcmaGmvAvg;

    @ExcelProperty("平均次月人均月活GMV")
    private BigDecimal mpcmaGmvAvg;

    @ExcelProperty("平均活动期人均拉新GMV")
    private BigDecimal pcnGmvAvg;

    @ExcelProperty("平均次月人均拉新GMV")
    private BigDecimal panGmvAvg;

    @ExcelProperty("平均月活次月留存率")
    private BigDecimal masmRateAvg;

    @ExcelProperty("平均拉新次月留存率")
    private BigDecimal mrrRateAvg;

    // 差值指标
    @ExcelProperty("千次曝光成本差值")
    private BigDecimal cpmDiff;

    @ExcelProperty("月活会员ROI差值")
    private BigDecimal roiDiff;

    @ExcelProperty("月活会员获客成本差值")
    private BigDecimal cacDiff;

    @ExcelProperty("月活会员贡献率差值")
    private BigDecimal mamcRateDiff;

    @ExcelProperty("月活会员GMV贡献率差值")
    private BigDecimal mamcGmvRateDiff;

    @ExcelProperty("拉新会员ROI差值")
    private BigDecimal rnmRoiDiff;

    @ExcelProperty("拉新会员获客成本差值")
    private BigDecimal rnmCacDiff;

    @ExcelProperty("拉新会员贡献率差值")
    private BigDecimal nmcRateDiff;

    @ExcelProperty("拉新会员GMV贡献率差值")
    private BigDecimal nmcGmvRateDiff;

    @ExcelProperty("活动期人均月活GMV差值")
    private BigDecimal pcmaGmvDiff;

    @ExcelProperty("次月人均月活GMV差值")
    private BigDecimal mpcmaGmvDiff;

    @ExcelProperty("活动期人均拉新GMV差值")
    private BigDecimal pcnGmvDiff;

    @ExcelProperty("次月人均拉新GMV差值")
    private BigDecimal panGmvDiff;

    @ExcelProperty("月活次月留存率差值")
    private BigDecimal masmRateDiff;

    @ExcelProperty("拉新次月留存率差值")
    private BigDecimal mrrRateDiff;

    // 占比字段
    @ExcelProperty("花费占比")
    private BigDecimal costAcc;

    @ExcelProperty("曝光次数占比")
    private BigDecimal exposureCountAcc;

    @ExcelProperty("曝光人数占比")
    private BigDecimal exposureUserCountAcc;

    @ExcelProperty("点击次数占比")
    private BigDecimal clickCountAcc;

    @ExcelProperty("点击人数占比")
    private BigDecimal clickUserCountAcc;

    @ExcelProperty("月活会员数占比")
    private BigDecimal mamcAcc;

    @ExcelProperty("月活会员GMV占比")
    private BigDecimal mamgAcc;

    @ExcelProperty("拉新会员数占比")
    private BigDecimal nmacAcc;

    @ExcelProperty("拉新会员GMV占比")
    private BigDecimal nmagAcc;

    @ExcelProperty("次月活跃会员数占比")
    private BigDecimal nmnmcaAcc;

    @ExcelProperty("次月活跃会员GMV占比")
    private BigDecimal nmamgAcc;

    @ExcelProperty("次月新会员数占比")
    private BigDecimal nmnmcAcc;

    @ExcelProperty("次月新会员GMV占比")
    private BigDecimal nmnmgAcc;
}
