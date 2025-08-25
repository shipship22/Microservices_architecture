package com.hy.exceltemp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.hy.pojo.Alog;
import com.hy.pojo.AlogDiff;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

// Excel模版
@Data
public class ActivityAnalysisExcel {

    @ExcelProperty("活动名称")
    private String campaignName;

    @ExcelProperty("活动ID")
    private String campaignId;

    @ExcelProperty("开始日期")
    private Date startDate;

    @ExcelProperty("结束日期")
    private Date endDate;

    @ExcelProperty("花费")
    private BigDecimal cost;

    @ExcelProperty("监测率")
    private BigDecimal monitorRate;

    @ExcelProperty("曝光量")
    private Long exposureCount;

    @ExcelProperty("曝光用户数")
    private Long exposureUserCount;

    @ExcelProperty("点击量")
    private Long clickCount;

    @ExcelProperty("点击用户数")
    private Long clickUserCount;

    @ExcelProperty("月活跃会员数")
    private Long monthlyActiveMemberCount;

    @ExcelProperty("月活跃会员GMV")
    private BigDecimal monthlyActiveMemberGmv;

    @ExcelProperty("新会员获取数")
    private Long newMemberAcquisitionCount;

    @ExcelProperty("新会员获取GMV")
    private BigDecimal newMemberAcquisitionGmv;

    @ExcelProperty("周期性月活跃用户数")
    private Long periodicMonthlyActiveUserCount;

    @ExcelProperty("周期性月活跃用户GMV")
    private BigDecimal periodicMonthlyActiveUserGmv;

    @ExcelProperty("周期性新会员数")
    private Long periodicNewMemberCount;

    @ExcelProperty("周期性新会员GMV")
    private BigDecimal periodicNewMemberGmv;

    @ExcelProperty("下月活跃会员数")
    private Long nextMonthActiveMemberCount;

    @ExcelProperty("下月活跃会员GMV")
    private BigDecimal nextMonthActiveMemberGmv;

    @ExcelProperty("下月新会员数")
    private Long nextMonthNewMemberCount;

    @ExcelProperty("下月新会员GMV")
    private BigDecimal nextMonthNewMemberGmv;

    @ExcelProperty("活动类型")
    private String activityType;


}