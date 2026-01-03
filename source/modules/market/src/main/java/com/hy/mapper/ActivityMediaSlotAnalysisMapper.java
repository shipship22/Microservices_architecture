package com.hy.mapper;

import com.hy.pojo.ActivityMediaSlotAnalysis;
import com.hy.pojo.ActivityMediaSlotAnalysisExample;
import java.util.List;

import com.hy.pojo.MediaSlot;
import com.hy.pojo.PlatBean;
import org.apache.ibatis.annotations.Param;

public interface ActivityMediaSlotAnalysisMapper {
    int countByExample(ActivityMediaSlotAnalysisExample example);

    int deleteByExample(ActivityMediaSlotAnalysisExample example);

    int insert(ActivityMediaSlotAnalysis record);

    int insertSelective(ActivityMediaSlotAnalysis record);

    List<ActivityMediaSlotAnalysis> selectByExample(ActivityMediaSlotAnalysisExample example);

    int updateByExampleSelective(@Param("record") ActivityMediaSlotAnalysis record, @Param("example") ActivityMediaSlotAnalysisExample example);

    int updateByExample(@Param("record") ActivityMediaSlotAnalysis record, @Param("example") ActivityMediaSlotAnalysisExample example);


    List<String> findContactPointYJH();

    List<MediaSlot> findMediaSlotYJH(@Param("cid") String cid, @Param("point")String point, @Param("orderfiled")String orderfiled, @Param("orderTe") String orderTe, Integer pageNum, Integer pageSize,@Param("media") String media);

    List<String> findAllMediaYJH();

    List<PlatBean> platformDeliverComparsion(@Param("cidA") String cidA,@Param("cidB") String cidB,@Param("filed") String filed);

    List<PlatBean> distributionOfSubMediaPlatforms(@Param("cidA") String cidA,@Param("cidB") String cidB,@Param("filed") String filed);

    List<PlatBean> contactTypeComposition(@Param("cidA") String cidA, @Param("cidB") String cidB,  @Param("filed") String filed);

    List<PlatBean> contactPointDistribution(@Param("cidA") String cidA, @Param("cidB") String cidA1, @Param("filed") String filed, @Param("media") String media);

}