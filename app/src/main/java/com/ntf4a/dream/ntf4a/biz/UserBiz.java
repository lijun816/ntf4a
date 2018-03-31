package com.ntf4a.dream.ntf4a.biz;

import com.ntf4a.dream.ntf4a.db.dao.UserDao;
import com.ntf4a.dream.ntf4a.db.pojo.UserInfo;

import java.util.List;

/**
 * 用户的服务层
 * Created by dream on 2018/2/25.
 */

public class UserBiz {

    private static final String TAG = "UserBiz";

    UserDao userDao = new UserDao();

    //验证用户是否能够登录
    public UserInfo checkLogin(String username, String pwd){
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(pwd);
        try {
            List<UserInfo> userInfos = userDao.findByUsernameAndPwd(userInfo);
            userInfo = null;
            if(userInfos!=null&&userInfos.size()>0){
                userInfo = userInfos.get(0);
            }
        } catch (Exception e) {
            userInfo = null;
        }
        return userInfo;
    }



}



















