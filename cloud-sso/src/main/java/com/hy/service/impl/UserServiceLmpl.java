package com.hy.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.hy.mapper.TbUserMapper;
import com.hy.pojo.TbUser;
import com.hy.pojo.TbUserExample;
import com.hy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceLmpl implements UserService {

    @Autowired
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getUserByUsernameAndPassword(String username, String password) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria ex = tbUserExample.createCriteria();
        ex.andUsernameEqualTo(username).andPasswordEqualTo(password);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);
        return tbUsers != null && tbUsers.size() > 0 ? tbUsers.get(0) : null;
    }

    @Override
    public TbUser getUserByUsername(String username) {
        TbUserExample tbUserExample = new TbUserExample();
        TbUserExample.Criteria ex = tbUserExample.createCriteria();
        ex.andUsernameEqualTo(username);
        List<TbUser> tbUsers = tbUserMapper.selectByExample(tbUserExample);

        if (tbUsers != null && tbUsers.size() > 0) {
            return tbUsers.get(0);
        }

        return null;
    }

    @Override
    public TbUser getUserByUid(Integer uid) {
        return tbUserMapper.selectByPrimaryKey(uid);
    }

    @Override
    @SentinelResource("goods")
    public String order() {
        return "商品查询成功";
    }
}
