package com.ntf4a.dream.ntf4a.db.pojo;

import com.ntf4a.dream.ntf4a.db.util.TableColName;
import com.ntf4a.dream.ntf4a.db.util.TableName;

/**
 * 用户信息
 * Created by dream on 2018/2/25.
 */
@TableName("t_user_info")
public class UserInfo {

    //密码信息的唯一标识
    @TableColName("user_id")
    Integer userId;

    //用户名
    @TableColName("username")
    String username;

    //登录密码
    @TableColName("password")
    String password;

    @Override
    public String toString() {
        return "UserInfo{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
