package com.hy.service;

import com.hy.pojo.MediaSlot;
import com.hy.pojo.PlatBean;
import com.hy.result.PageResult;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public interface ActivityMediaSlotAnalysisService {
    List<String> findContactPointYJH();

    PageResult<MediaSlot> findMediaSlotYJH(String cid, String point, String orderfiled, String orderTe, Integer pageNum, Integer pageSize,String media);

    List<String> findAllMediaYJH();

    void findMediaSlotDownloadYJH(HttpServletResponse response, String cid, String point, String orderfiled, String orderTe, Integer pageNum, Integer pageSize, String media) throws IOException;

    void findAllMediaDownloadYJH(HttpServletResponse response, String cid, String point, String orderfiled, String orderTe, Integer pageNum, Integer pageSize, String media) throws IOException;

    Map<String, Map<String, List<PlatBean>>> platformDeliverComparsion(String cidA, String cidB, String filed);

    void platformDeliverComparsionDl(HttpServletResponse response, String cidA, String cidB, String filed) throws IOException;

    Map<String, Map<String, List<PlatBean>>> distributionOfSubMediaPlatforms(String cidA, String cidB, String filed);

    void distributionOfSubMediaPlatformsDl(HttpServletResponse response, String cidA, String cidB, String filed) throws UnsupportedEncodingException, Exception;

    Map<String, Map<String, List<PlatBean>>> contactTypeComposition(String cidA, String cidB, String filed);

    void contactTypeCompositionDl(HttpServletResponse response, String cidA, String cidB, String filed) throws IOException;

    Map<String, List<PlatBean>> contactPointDistribution(String cidA, String cidB, String filed, String media);

    void contactPointDistributionDl(HttpServletResponse response, String cidA, String cidB, String filed,String media) throws IOException;
}
