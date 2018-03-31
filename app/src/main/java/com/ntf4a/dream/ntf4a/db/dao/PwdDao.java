package com.ntf4a.dream.ntf4a.db.dao;

import com.ntf4a.dream.ntf4a.db.pojo.PasswordInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * passwordDao
 * Created by dream on 2018/2/25.
 */

public class PwdDao extends BaseDao<PasswordInfo> {

    public List<PasswordInfo> listAll() throws Exception {
        String sql = "select * from t_password_info";
        return query(sql, null);
    }

    public boolean updateById(PasswordInfo passwordInfo) throws Exception {
        String[] whereString = {"pwd_id"};
        List<Object> list = new ArrayList<>();
        String sql = getUpdateAndWhereSql(passwordInfo, whereString,list);
        System.out.println(sql);
        return exec(sql,list.toArray());
    }

    public boolean deleteById(PasswordInfo passwordInfo) throws Exception {
        String[] whereString = {"pwd_id"};
        List<Object> list = new ArrayList<>();
        String sql = getDeleteAndWhereSql(passwordInfo, whereString,list);
        System.out.println(sql);
        return exec(sql,list.toArray());
    }

    public boolean insert(PasswordInfo passwordInfo) throws Exception {
        List<Object> list = new ArrayList<>();
        String sql = getInsertSql(passwordInfo, list);
        System.out.println(sql);
        return exec(sql,list.toArray());
    }




}



















