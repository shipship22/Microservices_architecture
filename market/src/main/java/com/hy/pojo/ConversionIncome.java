package com.hy.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ConversionIncome {
    @ExcelProperty("总花费")
    private BigDecimal cost;

    @ExcelProperty("曝光次数")
    private Long exposureCount;

    @ExcelProperty("曝光人数")
    private Long exposureUserCount;

    @ExcelProperty("月活跃会员数")
    private Long monthlyActiveMemberCount;

    @ExcelProperty("拉新会员数")
    private Long newMemberAcquisitionCount;

    @ExcelProperty("曝光月活转化率")
    private BigDecimal emacRate;

    @ExcelProperty("曝光拉新转化率")
    private BigDecimal etnccRate;

    // 均值
    @ExcelProperty("曝光月活均值")
    private BigDecimal emacRateAvg;

    @ExcelProperty("报告拉新均值")
    private BigDecimal etnccRateAvg;

    // 差值
    @ExcelProperty("曝光月活差值")
    private BigDecimal emacRateDiff;

    @ExcelProperty("曝光拉新差值")
    private BigDecimal etnccRateDiff;
}
