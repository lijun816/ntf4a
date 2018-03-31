package com.ntf4a.dream.ntf4a;

import com.ntf4a.dream.ntf4a.db.dao.PwdDao;
import com.ntf4a.dream.ntf4a.db.pojo.PasswordInfo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        PwdDao pwdDao = new PwdDao();
        PasswordInfo passwordInfo = new PasswordInfo();
        passwordInfo.setPwdId(1);
        passwordInfo.setPwdMemo("a");
        System.out.println(pwdDao.insert(passwordInfo));

    }
}