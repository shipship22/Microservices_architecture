package com.hy.service;

import com.hy.pojo.ActivityPlatformInfluencertypeGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;
import org.apache.ibatis.annotations.Param;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActivityInfluencertypeGroupService {
    PageResult<ActivityPlatformInfluencertypeGroup> findActivityInfluencertypeGroup(PageResultQuery query);

    void findInfluencertypeGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException;

}
