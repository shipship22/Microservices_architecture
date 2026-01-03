package com.hy.service;

import com.hy.pojo.ActivityAlogAndDiff;
import com.hy.pojo.ActivityAnalysis;
import com.hy.pojo.ConversionIncome;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface ActivityService {
    List<ActivityAnalysis> findActivity();

    List<ActivityAnalysis> findNewAnListYJH();

    ActivityAnalysis findAllAnYJH(String cid);

    void anDownloadYJH(HttpServletResponse response) throws IOException;

    ConversionIncome getConversionIncomeYJH(String cid,String status);

    void conversionIncomeDownloadYJH(HttpServletResponse response, String cid,String status) throws IOException;


    Map<String, List<String>> findTypeAndCnames();

    ActivityAlogAndDiff comparisonOfCoreIndicators(String cidA, String cidB);

    void comparisonOfCoreIndicatorsDl(HttpServletResponse response, String cidA, String cidB) throws IOException;

    List<ActivityAnalysis> findActivityCpm();
}
