package com.ntf4a.dream.ntf4a.db.pojo;

import com.ntf4a.dream.ntf4a.db.util.TableName;
import com.ntf4a.dream.ntf4a.db.util.TableColName;

import java.util.Date;

/**
 * 密码信息
 * Created by dream on 2018/2/25.
 */

@TableName("t_password_info")
public class PasswordInfo {

    //密码信息的唯一标识
    @TableColName("pwd_id")
    Integer pwdId;


    //描述信息
    @TableColName("pwd_description")
    String pwdDescription;

    //用户名
    @TableColName("pwd_name")
    String pwdName;


    //密码信息
    @TableColName("pwd_info")
    String pwdInfo;


    //备注信息
    @TableColName("pwd_memo")
    String pwdMemo;


    //创建日期
    @TableColName("pwd_create_date")
    Date pwdCreateDate;


    //修改日期
    @TableColName("pwd_update_date")
    Date pwdUpdateDate;

    @Override
    public String toString() {
        return "PasswordInfo{" +
                "pwdId=" + pwdId +
                ", pwdDescription='" + pwdDescription + '\'' +
                ", pwdName='" + pwdName + '\'' +
                ", pwdInfo='" + pwdInfo + '\'' +
                ", pwdMemo='" + pwdMemo + '\'' +
                ", pwdCreateDate=" + pwdCreateDate +
                ", pwdUpdateDate=" + pwdUpdateDate +
                '}';
    }

    public Integer getPwdId() {
        return pwdId;
    }

    public void setPwdId(Integer pwdId) {
        this.pwdId = pwdId;
    }

    public String getPwdDescription() {
        return pwdDescription;
    }

    public void setPwdDescription(String pwdDescription) {
        this.pwdDescription = pwdDescription;
    }

    public String getPwdName() {
        return pwdName;
    }

    public void setPwdName(String pwdName) {
        this.pwdName = pwdName;
    }

    public String getPwdInfo() {
        return pwdInfo;
    }

    public void setPwdInfo(String pwdInfo) {
        this.pwdInfo = pwdInfo;
    }

    public String getPwdMemo() {
        return pwdMemo;
    }

    public void setPwdMemo(String pwdMemo) {
        this.pwdMemo = pwdMemo;
    }

    public Date getPwdCreateDate() {
        return pwdCreateDate;
    }

    public void setPwdCreateDate(Date pwdCreateDate) {
        this.pwdCreateDate = pwdCreateDate;
    }

    public Date getPwdUpdateDate() {
        return pwdUpdateDate;
    }

    public void setPwdUpdateDate(Date pwdUpdateDate) {
        this.pwdUpdateDate = pwdUpdateDate;
    }
}























