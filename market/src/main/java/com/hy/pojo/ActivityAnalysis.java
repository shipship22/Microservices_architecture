package com.hy.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class ActivityAnalysis {
    private String campaignName;

    private String campaignId;

    private Date startDate;

    private Date endDate;

    private BigDecimal cost;

    private BigDecimal monitorRate;

    private Long exposureCount;

    private Long exposureUserCount;

    private Long clickCount;

    private Long clickUserCount;

    private Long monthlyActiveMemberCount;

    private BigDecimal monthlyActiveMemberGmv;

    private Long newMemberAcquisitionCount;

    private BigDecimal newMemberAcquisitionGmv;

    private Long periodicMonthlyActiveUserCount;

    private BigDecimal periodicMonthlyActiveUserGmv;

    private Long periodicNewMemberCount;

    private BigDecimal periodicNewMemberGmv;

    private Long nextMonthActiveMemberCount;

    private BigDecimal nextMonthActiveMemberGmv;

    private Long nextMonthNewMemberCount;

    private BigDecimal nextMonthNewMemberGmv;

    private String activityType;

    //存放算法指标
    private Alog alog;

    //存放的指标差值
    private AlogDiff alogDiff;

    private BigDecimal cpm;

    public BigDecimal getCpm() {
        return cpm;
    }

    public void setCpm(BigDecimal cpm) {
        this.cpm = cpm;
    }

    public AlogDiff getAlogDiff() {
        return alogDiff;
    }

    public void setAlogDiff(AlogDiff alogDiff) {
        this.alogDiff = alogDiff;
    }

    public Alog getAlog() {
        return alog;
    }

    public void setAlog(Alog alog) {
        this.alog = alog;
    }

    public String getCampaignName() {
        return campaignName;
    }

    public void setCampaignName(String campaignName) {
        this.campaignName = campaignName == null ? null : campaignName.trim();
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId == null ? null : campaignId.trim();
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getMonitorRate() {
        return monitorRate;
    }

    public void setMonitorRate(BigDecimal monitorRate) {
        this.monitorRate = monitorRate;
    }

    public Long getExposureCount() {
        return exposureCount;
    }

    public void setExposureCount(Long exposureCount) {
        this.exposureCount = exposureCount;
    }

    public Long getExposureUserCount() {
        return exposureUserCount;
    }

    public void setExposureUserCount(Long exposureUserCount) {
        this.exposureUserCount = exposureUserCount;
    }

    public Long getClickCount() {
        return clickCount;
    }

    public void setClickCount(Long clickCount) {
        this.clickCount = clickCount;
    }

    public Long getClickUserCount() {
        return clickUserCount;
    }

    public void setClickUserCount(Long clickUserCount) {
        this.clickUserCount = clickUserCount;
    }

    public Long getMonthlyActiveMemberCount() {
        return monthlyActiveMemberCount;
    }

    public void setMonthlyActiveMemberCount(Long monthlyActiveMemberCount) {
        this.monthlyActiveMemberCount = monthlyActiveMemberCount;
    }

    public BigDecimal getMonthlyActiveMemberGmv() {
        return monthlyActiveMemberGmv;
    }

    public void setMonthlyActiveMemberGmv(BigDecimal monthlyActiveMemberGmv) {
        this.monthlyActiveMemberGmv = monthlyActiveMemberGmv;
    }

    public Long getNewMemberAcquisitionCount() {
        return newMemberAcquisitionCount;
    }

    public void setNewMemberAcquisitionCount(Long newMemberAcquisitionCount) {
        this.newMemberAcquisitionCount = newMemberAcquisitionCount;
    }

    public BigDecimal getNewMemberAcquisitionGmv() {
        return newMemberAcquisitionGmv;
    }

    public void setNewMemberAcquisitionGmv(BigDecimal newMemberAcquisitionGmv) {
        this.newMemberAcquisitionGmv = newMemberAcquisitionGmv;
    }

    public Long getPeriodicMonthlyActiveUserCount() {
        return periodicMonthlyActiveUserCount;
    }

    public void setPeriodicMonthlyActiveUserCount(Long periodicMonthlyActiveUserCount) {
        this.periodicMonthlyActiveUserCount = periodicMonthlyActiveUserCount;
    }

    public BigDecimal getPeriodicMonthlyActiveUserGmv() {
        return periodicMonthlyActiveUserGmv;
    }

    public void setPeriodicMonthlyActiveUserGmv(BigDecimal periodicMonthlyActiveUserGmv) {
        this.periodicMonthlyActiveUserGmv = periodicMonthlyActiveUserGmv;
    }

    public Long getPeriodicNewMemberCount() {
        return periodicNewMemberCount;
    }

    public void setPeriodicNewMemberCount(Long periodicNewMemberCount) {
        this.periodicNewMemberCount = periodicNewMemberCount;
    }

    public BigDecimal getPeriodicNewMemberGmv() {
        return periodicNewMemberGmv;
    }

    public void setPeriodicNewMemberGmv(BigDecimal periodicNewMemberGmv) {
        this.periodicNewMemberGmv = periodicNewMemberGmv;
    }

    public Long getNextMonthActiveMemberCount() {
        return nextMonthActiveMemberCount;
    }

    public void setNextMonthActiveMemberCount(Long nextMonthActiveMemberCount) {
        this.nextMonthActiveMemberCount = nextMonthActiveMemberCount;
    }

    public BigDecimal getNextMonthActiveMemberGmv() {
        return nextMonthActiveMemberGmv;
    }

    public void setNextMonthActiveMemberGmv(BigDecimal nextMonthActiveMemberGmv) {
        this.nextMonthActiveMemberGmv = nextMonthActiveMemberGmv;
    }

    public Long getNextMonthNewMemberCount() {
        return nextMonthNewMemberCount;
    }

    public void setNextMonthNewMemberCount(Long nextMonthNewMemberCount) {
        this.nextMonthNewMemberCount = nextMonthNewMemberCount;
    }

    public BigDecimal getNextMonthNewMemberGmv() {
        return nextMonthNewMemberGmv;
    }

    public void setNextMonthNewMemberGmv(BigDecimal nextMonthNewMemberGmv) {
        this.nextMonthNewMemberGmv = nextMonthNewMemberGmv;
    }

    public String getActivityType() {
        return activityType;
    }

    public void setActivityType(String activityType) {
        this.activityType = activityType == null ? null : activityType.trim();
    }
}