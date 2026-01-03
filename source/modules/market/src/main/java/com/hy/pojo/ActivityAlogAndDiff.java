package com.hy.pojo;

import lombok.Data;

@Data
public class ActivityAlogAndDiff {

    private ActivityAnalysis activityAnalysisA;
    private ActivityAnalysis activityAnalysisB;
    private AlogDiff alogDiff;
}
