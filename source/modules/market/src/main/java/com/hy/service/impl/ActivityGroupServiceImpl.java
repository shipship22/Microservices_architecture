package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.hy.exceltemp.ActivityGroupExcel;
import com.hy.mapper.ActivityGroupMapper;
import com.hy.pojo.ActivityGroup;
import com.hy.pojo.MediaSlot;
import com.hy.result.PageResult;
import com.hy.service.ActivityGroupService;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityGroupServiceImpl implements ActivityGroupService {
    @Autowired
    private ActivityGroupMapper activityGroupMapper;

    @Override
    public List<ActivityGroup> findActivityGroupYJH(String cname) {
        return activityGroupMapper.findActivityGroupYJH(cname);
    }

    @Override
    public void findActivityGroupDl(HttpServletResponse response, String cname) throws IOException {
        List<ActivityGroup> list1 = findActivityGroupYJH(cname);


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
    }
}
