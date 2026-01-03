package com.hy.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import com.alibaba.nacos.shaded.io.grpc.netty.shaded.io.netty.handler.codec.http.HttpHeaders;
import com.hy.exceltemp.ActivityAlogAndDiffExcel;
import com.hy.exceltemp.ActivityAnalysisExcel;
import com.hy.mapper.ActivityAnalysisMapper;
import com.hy.pojo.*;
import com.hy.service.ActivityService;
import com.hy.service.AlogService;
import com.hy.utils.Alogutil;
import com.hy.utils.ExcelUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URLEncoder;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityAnalysisMapper activityAnalysisMapper;

    @Autowired
    private AlogService alogService;

    @Override
    public List<ActivityAnalysis> findActivity() {
        return activityAnalysisMapper.selectByExample(null);
    }

    @Override
    public List<ActivityAnalysis> findNewAnListYJH() {
        return activityAnalysisMapper.findNewAnListYJH();
    }

    @Override
    public ActivityAnalysis findAllAnYJH(String cid) {
        //查询当前活动的基本指标
        ActivityAnalysis ac = activityAnalysisMapper.selectAnByCid(cid);
        //查询当前活动的算法指标
        Alog alog = alogService.getAlog(cid);
        //查询当前同类型活动的指标历史均值
        AlogAvg alogAvg = alogService.getAlogAvg(cid);

//        AlogDiff diff = new AlogDiff();
//        diff.setCpmDiff(alog.getCpm().subtract(alogAvg.getCpmAvg()));
//        diff.setCacDiff(alog.getCac().subtract(alogAvg.getCacAvg()));
//        diff.setRoiDiff(alog.getRoi().subtract(alogAvg.getRoiAvg()));
//        diff.setMamcGmvRateDiff(alog.getMamcGmvRate().subtract(alogAvg.getMamcGmvRateAvg()));
//        diff.setMamcRateDiff(alog.getMamcRate().subtract(alogAvg.getMamcRateAvg()));
//        diff.setMasmRateDiff(alog.getMasmRate().subtract(alogAvg.getMasmRateAvg()));
//        diff.setMpcmaGmvDiff(alog.getMpcmaGmv().subtract(alogAvg.getMpcmaGmvAvg()));
//        diff.setMrrRateDiff(alog.getMrrRate().subtract(alogAvg.getMrrRateAvg()));
//        diff.setNmcGmvRateDiff(alog.getNmcGmvRate().subtract(alogAvg.getNmcGmvRateAvg()));
//        diff.setNmcRateDiff(alog.getNmcRate().subtract(alogAvg.getNmcRateAvg()));


        AlogDiff diff = Alogutil.getAlogDiff(alog, alogAvg);


        ac.setAlog(alog);
        ac.setAlogDiff(diff);
        return ac;
    }



    @Override
    public void anDownloadYJH(HttpServletResponse response) throws IOException {
        //获取数据
        List<ActivityAnalysis> ac = activityAnalysisMapper.selectByExample(null);
        //设置文件名
        String fileName = System.currentTimeMillis() + "";
        //调用工具类完成样式的调用
        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);
        //拷贝数据 把 ActivityAnalysis数据拷贝到ActivityAnalysisExcel
        List<ActivityAnalysisExcel> collect = ac.stream().map((aa)->{
            ActivityAnalysisExcel ae = new ActivityAnalysisExcel();
            BeanUtils.copyProperties(aa,ae);
            return ae;
        }).collect(Collectors.toList());

        //填充样式让其生效并输出ac的内容
        EasyExcel.write(response.getOutputStream(), ActivityAnalysisExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("归因概览")
                .doWrite(collect);
    }

    @Override
    public ConversionIncome getConversionIncomeYJH(String cid,String status) {
        List<ConversionIncome> c = activityAnalysisMapper.getConversionIncomeYJH(cid);
        ConversionIncome con = null;
        //获取list中cid的数据
        if(c!=null&&c.size()>0){
            con = c.get(0);
        }
        BigDecimal emacRate = new BigDecimal("0");
        BigDecimal etnccRate = new BigDecimal("0");
        //设置计算指标
        //当漏斗第二层为曝光次数时，曝光月活转化率=月活会员数/曝光次数、曝光拉新转化率=拉新会员数/曝光次数；
        //当漏斗第二层为曝光人数时，曝光月活转化率=月活会员数/曝光人数、曝光拉新转化率=拉新会员数/曝光人数；
        if ("1".equals(status)) {
            emacRate = new BigDecimal(con.getMonthlyActiveMemberCount()).divide(new BigDecimal(con.getExposureCount()),2, RoundingMode.HALF_UP);
            etnccRate = new BigDecimal(con.getNewMemberAcquisitionCount()).divide(new BigDecimal(con.getExposureCount()),2,RoundingMode.HALF_UP);
            con.setEmacRate(emacRate);
            con.setEtnccRate(etnccRate);
            //获取均值
            ConversionIncome cs = activityAnalysisMapper.findConversionIncomeAvg();
            con.setEmacRateAvg(cs.getEmacRateAvg());
            con.setEtnccRateAvg(cs.getEtnccRateAvg());
            //差值
            con.setEmacRateDiff(emacRate.subtract(con.getEmacRateAvg()));
            con.setEtnccRateDiff(etnccRate.subtract(con.getEtnccRateAvg()));
        }
        else if ("2".equals(status)) {
            emacRate = new BigDecimal(con.getMonthlyActiveMemberCount()).divide(new BigDecimal(con.getExposureUserCount()),2,RoundingMode.HALF_UP);
            etnccRate = new BigDecimal(con.getNewMemberAcquisitionCount()).divide(new BigDecimal(con.getExposureUserCount()),2,RoundingMode.HALF_UP);
            con.setEmacRate(emacRate);
            con.setEtnccRate(etnccRate);
            //获取均值
            ConversionIncome cs = activityAnalysisMapper.findConversionIncomeAvgUser();
            con.setEmacRateAvg(cs.getEmacRateAvg());
            con.setEtnccRateAvg(cs.getEtnccRateAvg());
            //差值
            con.setEmacRateDiff(emacRate.subtract(con.getEmacRateAvg()));
            con.setEtnccRateDiff(etnccRate.subtract(con.getEtnccRateAvg()));
        }
        return con;
    }

    @Override
    public void conversionIncomeDownloadYJH(HttpServletResponse response,String cid, String status) throws IOException {
        ConversionIncome con =  getConversionIncomeYJH(cid,status);
        ArrayList<ConversionIncome> arr = new ArrayList<>();
        arr.add(con);
        String fileName = System.currentTimeMillis() + "";
        HorizontalCellStyleStrategy horizontalCellStyleStrategy =  ExcelUtil.getHorizontalCellStyleStrategy(response,fileName);
        EasyExcel.write(response.getOutputStream(),ConversionIncome.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("转换效益分析")
                .doWrite(arr);
    }

    @Override
    public Map<String, List<String>> findTypeAndCnames() {
        List<ActivityAnalysis> aa = activityAnalysisMapper.selectByExample(null);

        Map<String,List<ActivityAnalysis>> collect = aa.stream().collect(Collectors.groupingBy((x)->x.getActivityType()));

        HashMap<String,List<String>> map = new HashMap<>();

        collect.forEach((k,v)->{
            List<String> l1 = v.stream().map((x)->{
                return x.getCampaignName();
            }).collect(Collectors.toList());
            map.put(k,l1);
        });

        return map;
    }

    @Override
    public ActivityAlogAndDiff comparisonOfCoreIndicators(String cidA, String cidB) {
        ActivityAnalysis a1 = activityAnalysisMapper.selectAnByCid(cidA);
        ActivityAnalysis a2 = activityAnalysisMapper.selectAnByCid(cidB);

        Alog aa1 = activityAnalysisMapper.getAlog(cidA);
        Alog aa2 = activityAnalysisMapper.getAlog(cidB);

        a1.setAlog(aa1);
        a2.setAlog(aa2);

        AlogDiff diff = Alogutil.getAlogDiffTwo(aa1,aa2);

        diff.setCostDiff(a1.getCost().subtract(a2.getCost()));
        diff.setMonitorRateDiff(a1.getMonitorRate().subtract(a2.getMonitorRate()));
        diff.setExposureCountDiff(a1.getExposureCount() - a2.getExposureCount());
        diff.setExposureUserCountDiff(a1.getExposureUserCount() - a2.getExposureUserCount());
        diff.setClickCountDiff(a1.getClickCount() - a2.getClickCount());
        diff.setClickUserCountDiff(a1.getClickUserCount() - a2.getClickUserCount());
        diff.setMonthlyActiveMemberCountDiff(a1.getMonthlyActiveMemberCount() - a2.getMonthlyActiveMemberCount());
        diff.setMonthlyActiveMemberGmvDiff(a1.getMonthlyActiveMemberGmv().subtract(a2.getMonthlyActiveMemberGmv()));
        diff.setNewMemberAcquisitionCountDiff(a1.getNewMemberAcquisitionCount() - a2.getNewMemberAcquisitionCount());
        diff.setNewMemberAcquisitionGmvDiff(a1.getNewMemberAcquisitionGmv().subtract(a2.getNewMemberAcquisitionGmv()));
        diff.setPeriodicMonthlyActiveUserCountDiff(a1.getPeriodicMonthlyActiveUserCount() - a2.getPeriodicMonthlyActiveUserCount());
        diff.setPeriodicMonthlyActiveUserGmvDiff(a1.getPeriodicMonthlyActiveUserGmv().subtract(a2.getPeriodicMonthlyActiveUserGmv()));
        diff.setPeriodicNewMemberCountDiff(a1.getPeriodicNewMemberCount() - a2.getPeriodicNewMemberCount());
        diff.setPeriodicNewMemberGmvDiff(a1.getPeriodicNewMemberGmv().subtract(a2.getPeriodicNewMemberGmv()));
        diff.setNextMonthActiveMemberCountDiff(a1.getNextMonthActiveMemberCount() - a2.getNextMonthActiveMemberCount());
        diff.setNextMonthActiveMemberGmvDiff(a1.getNextMonthActiveMemberGmv().subtract(a2.getNextMonthActiveMemberGmv()));
        diff.setNextMonthNewMemberCountDiff(a1.getNextMonthNewMemberCount() - a2.getNextMonthNewMemberCount());
        diff.setNextMonthNewMemberGmvDiff(a1.getNextMonthNewMemberGmv().subtract(a2.getNextMonthNewMemberGmv()));
//        // 计算衍生指标差值
//        diff.setCpmDiff(a1.getCpm().subtract(a2.getCpm()));
//        diff.setRoiDiff(a1.getRoi().subtract(a2.getRoi()));
//        diff.setCacDiff(a1.getCac().subtract(a2.getCac()));
//        diff.setMamcRateDiff(a1.getMamcRate().subtract(a2.getMamcRate()));
//        diff.setMamcGmvRateDiff(a1.getMamcGmvRate().subtract(a2.getMamcGmvRate()));
//        diff.setRnmRoiDiff(a1.getRnmRoi().subtract(a2.getRnmRoi()));
//        diff.setRnmCacDiff(a1.getRnmCac().subtract(a2.getRnmCac()));
//        diff.setNmcRateDiff(a1.getNmcRate().subtract(a2.getNmcRate()));
//        diff.setNmcGmvRateDiff(a1.getNmcGmvRate().subtract(a2.getNmcGmvRate()));
//        diff.setPcmaGmvDiff(a1.getPcmaGmv().subtract(a2.getPcmaGmv()));
//        diff.setMpcmaGmvDiff(a1.getMpcmaGmv().subtract(a2.getMpcmaGmv()));
//        diff.setPcnGmvDiff(a1.getPcnGmv().subtract(a2.getPcnGmv()));
//        diff.setPanGmvDiff(a1.getPanGmv().subtract(a2.getPanGmv()));
//        diff.setMasmRateDiff(a1.getMasmRate().subtract(a2.getMasmRate()));
//        diff.setMrrRateDiff(a1.getMrrRate().subtract(a2.getMrrRate()));

        ActivityAlogAndDiff ds = new ActivityAlogAndDiff();
        ds.setActivityAnalysisA(a1);
        ds.setActivityAnalysisB(a2);
        ds.setAlogDiff(diff);

        return ds;


    }

    @Override
    public void comparisonOfCoreIndicatorsDl(HttpServletResponse response, String cidA, String cidB) throws IOException {
        ActivityAlogAndDiff ad = comparisonOfCoreIndicators(cidA, cidB);
        ActivityAnalysis a = ad.getActivityAnalysisA();
        ActivityAnalysis b = ad.getActivityAnalysisB();
        AlogDiff alogDiff = ad.getAlogDiff();


        ActivityAlogAndDiffExcel exa = new ActivityAlogAndDiffExcel();
        BeanUtils.copyProperties(a,exa);
        BeanUtils.copyProperties(alogDiff,exa);

        ActivityAlogAndDiffExcel exb = new ActivityAlogAndDiffExcel();
        BeanUtils.copyProperties(b,exb);
        BeanUtils.copyProperties(alogDiff,exb);

        ArrayList<ActivityAlogAndDiffExcel> adList = new ArrayList<>();
        adList.add(exa);
        adList.add(exb);

        String filename = URLEncoder.encode("核心指标下载"+System.currentTimeMillis(),"utf-8");

        HorizontalCellStyleStrategy horizontalCellStyleStrategy = ExcelUtil.getHorizontalCellStyleStrategy(response, filename);

        EasyExcel.write(response.getOutputStream(),ActivityAlogAndDiffExcel.class)
                .registerWriteHandler(horizontalCellStyleStrategy)
                .sheet("核心指标")
                .doWrite(adList);


    }

    @Override
    public List<ActivityAnalysis> findActivityCpm() {
        return activityAnalysisMapper.findActivityCpm();
    }


}
