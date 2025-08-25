package com.hy.exceltemp;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class PlatformDeliverExcel {
    @ExcelProperty("活动ID")
    private String cid;
    @ExcelProperty("活动名称")
    private String cname;
    @ExcelProperty("媒体渠道")
    private String media;
    @ExcelProperty("指标")
    private String filed;

}
