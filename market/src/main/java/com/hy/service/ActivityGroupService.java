package com.hy.service;

import com.hy.pojo.ActivityGroup;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public interface ActivityGroupService {
    List<ActivityGroup> findActivityGroupYJH(String cname);

    void findActivityGroupDl(HttpServletResponse response, String cname) throws IOException;
}
