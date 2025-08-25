package com.hy.api;

import com.hy.back.DissFallback;
import com.hy.pojo.TbDistributor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "cloud-diss-service",fallbackFactory = DissFallback.class)
public interface DissApi {
        @GetMapping("/diss/findDissByUidYJH")
        public List<TbDistributor> findDissByUid (@RequestParam Integer uid);
}


