package com.hy.controller;

import com.hy.api.DissApi;
import com.hy.pojo.TbDistributor;
import com.hy.pojo.TbUser;
import com.hy.result.ContentResult;
import com.hy.result.Result;
import com.hy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private DissApi dissApi;

    @Autowired
    private UserService userService;

    @GetMapping("/selectDissByUidYJH")
    public Result selectDissByUid(Integer uid){
        TbUser user = userService.getUserByUid(uid);

        List<TbDistributor> dissByUid = dissApi.findDissByUid(uid);

        user.setDis(dissByUid);
        return new Result(ContentResult.SUCCESS_CODE,ContentResult.SUCCESS_MASSAGE,user);
    }

    @GetMapping("/query")
    public String query(){
        System.out.println("查询成功");
        String order = userService.order();
        System.out.println(order);
        return "查询成功";
    }

    @GetMapping("/pay")
    public String pay(){
        System.out.println("支付成功");
        return "支付成功";
    }

    @GetMapping("/order")
    public String order(){
        System.out.println("订单成功");
        String order = userService.order();
        System.out.println(order);
        return "订单成功";
    }


}
