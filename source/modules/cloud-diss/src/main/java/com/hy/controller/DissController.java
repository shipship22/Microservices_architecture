package com.hy.controller;

import com.hy.pojo.TbDistributor;
import com.hy.service.DissService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/diss")
public class DissController {

    @Autowired
    private DissService dissService;

    @GetMapping("/findDissByUidYJH")
    public List<TbDistributor>  findDissByUid(@RequestParam Integer uid){
        if(uid==1){
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }else if(uid==2){
            throw new RuntimeException("异常出现,熔断服务");
        }
        return dissService.findDissByUid(uid);
    }
}
