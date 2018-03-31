package com.ntf4a.dream.ntf4a.biz;

import android.util.Log;

import com.ntf4a.dream.ntf4a.db.dao.PwdDao;
import com.ntf4a.dream.ntf4a.db.pojo.PasswordInfo;

import java.util.List;

/**
 * 密码的服务
 * Created by dream on 2018/2/25.
 */

public class PasswordBiz {

    private static final String TAG = "PasswordBiz";

    private PwdDao pwdDao = new PwdDao();

    //获取所有的密码信息
    public List<PasswordInfo> listAll(){
        try {
            return pwdDao.listAll();
        } catch (Exception e) {
            Log.d(TAG, "insertPwd: "+e.getMessage());
        }
        return null;
    }

    public boolean updatePwd(PasswordInfo passwordInfo){
        try {
            return pwdDao.updateById(passwordInfo);
        } catch (Exception e) {
            Log.d(TAG, "insertPwd: "+e.getMessage());
        }
        return false;
    }

    public boolean insertPwd(PasswordInfo passwordInfo){
        try {
            return pwdDao.insert(passwordInfo);
        } catch (Exception e) {
            Log.d(TAG, "insertPwd: "+e.getMessage());
            return false;
        }
    }

    public boolean deletePwd(PasswordInfo passwordInfo){
        try {
            return pwdDao.deleteById(passwordInfo);
        } catch (Exception e) {
            Log.d(TAG, "insertPwd: "+e.getMessage());
            return false;
        }
    }
}

























