package com.hy.service;

import com.hy.pojo.ActivityPlatformInfluencergradeGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActivityPlatformInfluencergradeGroupService {
    PageResult<ActivityPlatformInfluencergradeGroup> findInfluencergradeGroup(PageResultQuery query);

    void findInfluencergradeGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException;
}
