package com.hy.pojo;

import lombok.Data;

import java.math.BigDecimal;
//历史均值
@Data
public class AlogAvg {
    private BigDecimal cpmAvg;//CPM=花费/曝光次数*1000
    private BigDecimal roiAvg;//月活会员ROI=月活会员GMV/花费
    private BigDecimal cacAvg;//月活会员CAC=花费/月活会员数
    private BigDecimal mamcRateAvg;//月活会员贡献率=月活会员数/周期月活人数
    private BigDecimal mamcGmvRateAvg;//月活会员GMV贡献率=月活会员GMV/周期月活GMV
    private BigDecimal rnmRoiAvg;//拉新会员ROI=拉新会员GMV/花费
    private BigDecimal rnmCacAvg;//拉新会员CAC=花费/拉新会员数
    private BigDecimal nmcRateAvg;//拉新会员贡献率=拉新会员数/周期月活人数
    private BigDecimal nmcGmvRateAvg;//拉新会员GMV贡献率=拉新会员GMV/周期月活GMV
    private BigDecimal pcmaGmvAvg;//活动期人均月活GMV=月活会员GMV/月活会员数
    private BigDecimal mpcmaGmvAvg;//次月人均月活GMV=次月月活会员GMV/次月月活会员数
    private BigDecimal pcnGmvAvg;//活动期人均拉新GMV=拉新会员GMV/拉新会员数
    private BigDecimal panGmvAvg;//次月人均拉新GMV=次月拉新会员GMV/次月拉新会员数
    private BigDecimal masmRateAvg;//月活次月留存率=次月月活会员数/月活会员数
    private BigDecimal mrrRateAvg;//拉新次月留存率=次月拉新会员数/拉新会员数

}
