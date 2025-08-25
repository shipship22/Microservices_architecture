package com.hy.service;

import com.hy.pojo.ActivityPlatformGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ActivityPlatformGroupService {
    PageResult<ActivityPlatformGroup> findActivityPlatformGroupYJH(PageResultQuery query);

    void findActivityPlatformGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException;
}
