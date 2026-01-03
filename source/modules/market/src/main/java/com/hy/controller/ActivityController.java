package com.hy.controller;

import com.hy.mapper.ActivityKolGroupMapper;
import com.hy.pojo.*;
import com.hy.result.ContentResult;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import com.hy.result.Result;
import com.hy.service.*;
import org.bouncycastle.jcajce.provider.config.PKCS12StoreParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RefreshScope
@RequestMapping("/market")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityMediaSlotAnalysisService activityMediaSlotAnalysisService;

    @Autowired
    private ActivityGroupService activityGroupService;

    @Autowired
    private ActivityPlatformGroupService activityPlatformGroupService;

    @Autowired
    private ActivityPlatformContentGroupService activityPlatformContentGroupService;

    @Autowired
    private ActivityDirectionGroupService activityDirectionGroupService;

    @Autowired
    private ActivityPlatformInfluencergradeGroupService activityPlatformInfluencergradeGroupService;

    @Autowired
    private ActivityInfluencertypeGroupService activityInfluencertypeGroupService;

    @Autowired
    private ActivityKolGroupService activitykolGroupService;

    @Autowired
    private ActivityKolGroupService activityKolGroupService;

    @Value("${upload}")
    private String upload;

    @GetMapping("/findActivity")
    public Result findActivity() {
        List<ActivityAnalysis> activityAnalyses = activityService.findActivity();
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, activityAnalyses);
    }

    //查询最新活动列表
    @GetMapping("/findNewAnListYJH")
    public Result findNewAnListYJH() {
        List<ActivityAnalysis> list = activityService.findNewAnListYJH();
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, list);
    }

    //查询当前活动下的整体活动概览
    @GetMapping("/findAllAnYJH")
    public Result findAllANYJH(String cid) {
        ActivityAnalysis activityAnalysis = activityService.findAllAnYJH(cid);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, activityAnalysis);
    }

    @GetMapping("/anDownloadYJH")
    public void anDownloadYJH(HttpServletResponse response) throws IOException {
        //访问service组装数据
        activityService.anDownloadYJH(response);
    }

    //转化收益分析-获取当前活动下的数据->5个
    @GetMapping("/getConversionIncomeYJH")
    public Result getConversionIncomeYJH(String cid, String status) {
        //预定status=1为曝光次数，status为曝光人数
        ConversionIncome list = activityService.getConversionIncomeYJH(cid, status);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, list);
    }

    //转化效益分析下载接口
    @GetMapping("/conversionIncomeDownloadYJH")
    public void conversionIncomeDownloadYJH(HttpServletResponse response, String cid, String status) throws IOException {
        activityService.conversionIncomeDownloadYJH(response, cid, status);
    }

    //媒介归因排名-查询触点类型
    @GetMapping("/findContactPointYJH")
    public Result findContactPointYJH() {
        List<String> list = activityMediaSlotAnalysisService.findContactPointYJH();
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, list);
    }

    //查询当前活动下全部的媒介归因排名
    @GetMapping("/findMediaSlotYJH")
    public Result findMeidSlotYJH(String cid, String point, String orderfiled, String orderTe, Integer pageNum, Integer pageSize, String media) {
        PageResult<MediaSlot> list = activityMediaSlotAnalysisService.findMediaSlotYJH(cid, point, orderfiled, orderTe, pageNum, pageSize, media);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, list);
    }

    //查询媒介归因排名-下载
    @GetMapping("/findMediaSlotDownloadYJH")
    public void findMediaSlotDownloadYJH(HttpServletResponse response, String cid, String point, String orderfiled, String orderTe, Integer pageNum, Integer pageSize, String media) throws IOException {
        activityMediaSlotAnalysisService.findMediaSlotDownloadYJH(response, cid, point, orderfiled, orderTe, pageNum, pageSize, media);
    }

    //查询所有媒介平台名称
    @GetMapping("/findAllMediaYJH")
    public Result findAllMediaYJH() {
        List<String> list = activityMediaSlotAnalysisService.findAllMediaYJH();
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, list);
    }

    //触点类型归因排名-下载
    @GetMapping("/findAllMediaDownloadYJH")
    public void findAllMediaDownloadYJH(HttpServletResponse response, String cid, String point, String orderfiled, String orderTe, Integer pageNum, Integer pageSize, String media) throws IOException {
        activityMediaSlotAnalysisService.findAllMediaDownloadYJH(response, cid, point, orderfiled, orderTe, pageNum, pageSize, media);
    }

    //kol投放

    //分活动
    @GetMapping("/findActivityGroupYJH")
    public Result findActivityGroupYJH(String cname) {
        List<ActivityGroup> alog = activityGroupService.findActivityGroupYJH(cname);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, alog);
    }

    //分活动下载
    @GetMapping("/findActivityGroupDownloadYJH")
    public void findActivityGroupDl(HttpServletResponse response, String cname) throws IOException {
        activityGroupService.findActivityGroupDl(response,cname);
    }

    //分活动分媒介
    @PostMapping("/findActivityPlatformGroupYJH")
    public Result findActivityPlatformGroupYJH(@RequestBody PageResultQuery query){
        PageResult<ActivityPlatformGroup> activityPlatformGroups = activityPlatformGroupService.findActivityPlatformGroupYJH(query);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, activityPlatformGroups);
    }
    //分活动分媒介下载
    @PostMapping("/findActivityPlatformGroupDownloadYJH")
    public void findActivityPlatformGroupDl(HttpServletResponse response,@RequestBody PageResultQuery query) throws IOException {
        activityPlatformGroupService.findActivityPlatformGroupDl(response,query);
    }

    //分内容形式
    @PostMapping("/findActivityPlatformContentGroupYJH")
    public Result findActivityPlatformContentGroup(@RequestBody PageResultQuery query){
        PageResult<ActivityPlatformContentGroup> page = activityPlatformContentGroupService.findActivityPlatformContentGroup(query);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, page);
    }
    //分内容形式下载
    @PostMapping("/findActivityPlatformContentGroupDownloadYJH")
    public void findActivityPlatformContentGroupDl( HttpServletResponse response,@RequestBody PageResultQuery query) throws IOException {
        activityPlatformContentGroupService.findActivityPlatformContentGroupDl(response,query);
    }

    //分内容方向查询
    @PostMapping("/findActivityDirectionGroupYJH")
    public Result findActivityDirectionGroup(@RequestBody PageResultQuery query){
        PageResult<ActivityPlatformContentDirectionGroup> list = activityDirectionGroupService.findActivityDirectionGroup(query);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, list);
    }
    //分内容方向下载
    @PostMapping("/findActivityDirectionGroupDownloadYJH")
    public void findActivityDirectionGroupDl(HttpServletResponse response,PageResultQuery query) throws IOException {
        activityDirectionGroupService.findActivityDirectionGroupDl(response,query);
    }

    //达人等级
    @PostMapping("/findInfluencergradeGroupYJH")
    public Result findInfluencergradeGroup(@RequestBody PageResultQuery query){
        PageResult<ActivityPlatformInfluencergradeGroup> page = activityPlatformInfluencergradeGroupService.findInfluencergradeGroup(query);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, page);
    }

    //分达人等级下载
    @PostMapping("/findInfluencergradeGroupDlYJH")
    public void findInfluencergradeGroupDl(HttpServletResponse response, @RequestBody PageResultQuery query) throws IOException {
        activityPlatformInfluencergradeGroupService.findInfluencergradeGroupDl(response,query);
    }

    //分达人类型
    @PostMapping("/findActivityInfluencertypeGroupYJH")
    public Result findActivityInfluencertypeGroup(@RequestBody PageResultQuery query){
        PageResult<ActivityPlatformInfluencertypeGroup> page = activityInfluencertypeGroupService.findActivityInfluencertypeGroup(query);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MASSAGE,page);
    }

    //分达人类型下载
    @PostMapping("/findInfluencertypeGroupDlYJH")
    public void findInfluencertypeGroupDl(HttpServletResponse response, @RequestBody PageResultQuery query) throws IOException {
        activityInfluencertypeGroupService.findInfluencertypeGroupDl(response,query);
    }

    //分活动分帖子
    @PostMapping("/findActivityKolGroupYJH")
    public Result findActivityKolGroup(@RequestBody PageResultQuery query){
        PageResult<ActivityKolGroup> page = activityKolGroupService.findActivityKolGroup(query);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, page);
    }

    //分活动分帖子下载
    @PostMapping("/findActivityKolGroupDlYJH")
    public void findActivityKolGroupDl(HttpServletResponse response, @RequestBody PageResultQuery query) throws IOException {
        activityKolGroupService.findActivityKolGroupDl(response, query);
    }

    //KOL统一下载接口
    @PostMapping("/kolDlYJH")
    public void kolDl(@RequestBody PageResultQuery query,HttpServletResponse response) throws IOException {
        activityKolGroupService.kolDl(query,response);
    }




    //1.2.2.	多活动归因分析对比
    @GetMapping("/findTypeAndCnamesYJH")
    public Result findTypeAndCnames(){
        Map<String,List<String>> map = activityService.findTypeAndCnames();
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, map);
    }

    //多活动归因-获取两个活动的所有指标数据的集合-核心指标对比
    @GetMapping("/comparisonOfCoreIndicatorsYJH")
    public Result comparisonOfCoreIndicators(String cidA,String cidB){
        ActivityAlogAndDiff as = activityService.comparisonOfCoreIndicators(cidA,cidB);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, as);
    }
    //多活动归因-获取两个活动的所有指标数据的集合-核心指标对比——下载
    @GetMapping("/comparisonOfCoreIndicatorsDlYJH")
    public void comparisonOfCoreIndicatorsDl(HttpServletResponse response, String cidA,String cidB) throws IOException {
        activityService.comparisonOfCoreIndicatorsDl(response,cidA,cidB);
    }

    //多活动归因-分媒介平台投放对比
    @GetMapping("/platformDeliverComparsionYJH")
    public Result platformDeliverComparsion(String cidA,String cidB,String filed){
        Map<String,Map<String,List<PlatBean>>> map = activityMediaSlotAnalysisService.platformDeliverComparsion(cidA,cidB,filed);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, map);
    }
    //多活动归因-分媒介平台投放对比——下载
    @GetMapping("/platformDeliverComparsionDlYJH")
    public void platformDeliverComparsionDl(HttpServletResponse response, String cidA,String cidB,String filed) throws IOException {
        activityMediaSlotAnalysisService.platformDeliverComparsionDl(response,cidA,cidB,filed);
    }

    //多活动归因-分媒介平台分布
    @GetMapping("/distributionOfSubMediaPlatformsYJH")
    public Result distributionOfSubMediaPlatforms(String cidA,String cidB,String filed){
        Map<String, Map<String, List<PlatBean>>> map = activityMediaSlotAnalysisService.distributionOfSubMediaPlatforms(cidA,cidB,filed);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, map);
    }

    //多活动归因-分媒介平台分布下载
    @GetMapping("/distributionOfSubMediaPlatformsDlYJH")
    public void distributionOfSubMediaPlatformsDl(HttpServletResponse response, String cidA,String cidB,String filed) throws Exception {
        activityMediaSlotAnalysisService.distributionOfSubMediaPlatformsDl(response,cidA,cidB,filed);
    }

    //多活动归因-分媒介分触点类型构成
    @GetMapping("/contactTypeCompositionYJH")
    public Result contactTypeComposition(String cidA,String cidB,String filed){
        Map<String,Map<String ,List<PlatBean>>> map = activityMediaSlotAnalysisService.contactTypeComposition(cidA,cidB,filed);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, map);
    }
    //多活动归因-分媒介分触点类型构成-下载
    @GetMapping("contactTypeCompositionDlYJH")
    public void contactTypeCompositionDl(HttpServletResponse response, String cidA,String cidB,String filed) throws IOException {
        activityMediaSlotAnalysisService.contactTypeCompositionDl(response,cidA,cidB,filed);
    }

    //多活动归因-分媒介触点类型分布
    @GetMapping("/contactPointDistributionYJH")
    public Result contactPointDistribution(String cidA,String cidB,String filed,String media){
        Map<String, List<PlatBean>> map = activityMediaSlotAnalysisService.contactPointDistribution(cidA,cidB,filed,media);
        return new Result(ContentResult.SUCCESS_CODE, ContentResult.SUCCESS_MASSAGE, map);
    }
    //多活动归因-分媒介触点类型分布下载
    @GetMapping("/contactPointDistributionDlYJH")
    public void contactPointDistributionDl(HttpServletResponse response, String cidA,String cidB,String filed,String media) throws IOException {
        activityMediaSlotAnalysisService.contactPointDistributionDl(response,cidA,cidB,filed,media);
    }

    @GetMapping("/upload")
    public void upload(){
        System.out.println(upload);
    }


}