package com.hy.service;

import com.hy.pojo.ActivityPlatformContentDirectionGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActivityDirectionGroupService {
    PageResult<ActivityPlatformContentDirectionGroup> findActivityDirectionGroup(PageResultQuery query);

    void findActivityDirectionGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException;
}
