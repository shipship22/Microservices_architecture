package com.hy.service;

import com.hy.pojo.ActivityKolGroup;
import com.hy.result.PageResult;
import com.hy.result.PageResultQuery;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface ActivityKolGroupService {
    PageResult<ActivityKolGroup> findActivityKolGroup(PageResultQuery query);

    void findActivityKolGroupDl(HttpServletResponse response, PageResultQuery query) throws IOException;

    void kolDl(PageResultQuery query, HttpServletResponse response) throws IOException;
}
