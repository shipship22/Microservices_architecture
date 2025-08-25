package com.hy.service;

import com.hy.pojo.ActivityAnalysis;
import com.hy.pojo.Alog;
import com.hy.pojo.AlogAvg;

public interface AlogService {
    //获取需要计算的指标
    public Alog getAlog(String cid);

    //计算同类型活动下的历史均值
    public AlogAvg getAlogAvg(String cid);
}
