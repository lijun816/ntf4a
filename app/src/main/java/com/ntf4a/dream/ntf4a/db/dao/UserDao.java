package com.ntf4a.dream.ntf4a.db.dao;

import com.ntf4a.dream.ntf4a.db.pojo.PasswordInfo;
import com.ntf4a.dream.ntf4a.db.pojo.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户dao
 * Created by dream on 2018/2/25.
 */

public class UserDao extends BaseDao<UserInfo> {

    public List<UserInfo> listAll() throws Exception {
        String sql = "select * from t_user_info";
        return query(sql, null);
    }

    public List<UserInfo> findByUsernameAndPwd(UserInfo userInfo) throws Exception {
        String sql = "select * from t_user_info where username = ? and password = ?";
        return query(sql, new String[]{userInfo.getUsername(),userInfo.getPassword()});
    }

    public boolean updateById(UserInfo passwordInfo) throws Exception {
        String[] whereString = {"user_id"};
        List<Object> list = new ArrayList<>();
        String sql = getUpdateAndWhereSql(passwordInfo, whereString,list);
        System.out.println(sql);
        return exec(sql,list.toArray());
    }

    public boolean deleteById(UserInfo passwordInfo) throws Exception {
        String[] whereString = {"user_id"};
        List<Object> list = new ArrayList<>();
        String sql = getDeleteAndWhereSql(passwordInfo, whereString,list);
        System.out.println(sql);
        return exec(sql,list.toArray());
    }

    public boolean insert(UserInfo passwordInfo) throws Exception {
        List<Object> list = new ArrayList<>();
        String sql = getInsertSql(passwordInfo, list);
        System.out.println(sql);
        return exec(sql,list.toArray());
    }
}
