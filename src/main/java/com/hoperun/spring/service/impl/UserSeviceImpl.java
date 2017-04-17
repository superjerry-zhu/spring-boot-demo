package com.hoperun.spring.service.impl;

import com.hoperun.spring.domain.User;
import com.hoperun.spring.service.UserService;
import com.hoperun.spring.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/4/17.
 */
@Service
public class UserSeviceImpl implements UserService{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        String sql = "select * from user";
        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
        for (Map<String, Object> map : list) {
            String name = StringUtil.toString(map.get("NAME"));
            String code = StringUtil.toString(map.get("CODE"));
            String passwrod = StringUtil.toString(map.get("PASSWORD"));
            User user = new User();
            user.setName(name);
            user.setCode(code);
            user.setPassword(passwrod);
            userList.add(user);
        }
        return userList;
    }
}
