package com.ntf4a.dream.ntf4a.db.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.ntf4a.dream.ntf4a.db.SqlHelper;
import com.ntf4a.dream.ntf4a.db.util.CursorToPojoUtil;
import com.ntf4a.dream.ntf4a.db.util.TableName;
import com.ntf4a.dream.ntf4a.db.util.TableColName;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * BaseDao
 * Created by dream on 2018/2/25.
 */

public class BaseDao<T> {

    private Class<T> clazz;

    BaseDao() {
        // 使用反射技术得到T的真实类型
        ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass(); // 获取当前new的对象的 泛型的父类 类型
        this.clazz = (Class<T>) pt.getActualTypeArguments()[0]; // 获取第一个类型参数的真实类型
        System.out.println("clazz ---> " + clazz);

    }

    List<T> query(String sql, String[] args) throws Exception {
        SQLiteDatabase db = SqlHelper.getReadDb();
        Cursor cursor = db.rawQuery(sql, args);
        return CursorToPojoUtil.getPojo(cursor,clazz);

    }

    boolean exec(String sql, Object[] args){
        SQLiteDatabase db = SqlHelper.getWriteDb();
        try {
            db.execSQL(sql,args);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    /**
     * 获取删除的sql语句
     * @param t 实体类型
     * @param whereString 条件(表字段)
     * @param listParams  sql语句参数(输出)
     * @return sql语句
     * @throws Exception 异常
     */
    String getDeleteAndWhereSql(T t, String[] whereString, List<Object> listParams) throws Exception {
        HashMap<String, Object> hashMapWhere = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        List<String> list = Arrays.asList(whereString);
        Object value;
        for (Field f : fields) {
            f.setAccessible(true);
            TableColName annotation = f.getAnnotation(TableColName.class);
            String fieldName;
            if (annotation != null) {
                fieldName = annotation.value();
            }else{
                fieldName = f.getName();
            }
            value = f.get(t);
            if(value==null){
                continue;
            }
            if (list.contains(fieldName)) {
                //TODO 应该是可以添加 除了等号之外的条件  目前仅仅支持等号
                hashMapWhere.put(fieldName, value);
            }
        }
        //获取表名称
        String tableName = clazz.getAnnotation(TableName.class).value();
        StringBuilder sql = new StringBuilder();
        sql.append("delete from ");
        sql.append(tableName);
        sql.append(" where ");

        //循环条件字段
        for (Map.Entry<String ,Object> entry:hashMapWhere.entrySet()) {
            sql.append(entry.getKey());
            sql.append(" = ? and ");
            listParams.add(entry.getKey());
        }
        sql.delete(sql.lastIndexOf(" and "),sql.length());
        return sql.toString();
    }

    /**
     * 获取修改的sql语句
     * @param t 实体类型
     * @param whereString 条件(表字段)
     * @param listParams  sql语句参数(输出)
     * @return sql语句
     * @throws Exception 异常
     */
    String getUpdateAndWhereSql(T t, String[] whereString, List<Object> listParams) throws Exception {
        HashMap<String, Object> hashMapUpdate = new HashMap<>();
        HashMap<String, Object> hashMapWhere = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        List<String> list = Arrays.asList(whereString);
        Object value;
        for (Field f : fields) {
            f.setAccessible(true);
            TableColName annotation = f.getAnnotation(TableColName.class);
            String fieldName;
            if (annotation != null) {
                fieldName = annotation.value();
            }else{
                fieldName = f.getName();
            }
            value = f.get(t);
            if(value==null){
                continue;
            }
            if (list.contains(fieldName)) {
                //TODO 应该是可以添加 除了等号之外的条件  目前仅仅支持等号
                hashMapWhere.put(fieldName, value);
            } else {
                //通过反射把字段不为null的均设置为更新字段
                hashMapUpdate.put(fieldName, value);
            }
        }
        //获取表名称
        String tableName = clazz.getAnnotation(TableName.class).value();
        StringBuilder sql = new StringBuilder();
        sql.append("update ");
        sql.append(tableName);
        sql.append(" set ");
        //循环需要更新的字段
        for (Map.Entry<String ,Object> entry: hashMapUpdate.entrySet()) {
            sql.append(entry.getKey());
            sql.append(" = ? , ");
            listParams.add(entry.getKey());
        }
        if(list.size()<1){
            throw new Exception("没有字段需要修改");
        }
        sql.deleteCharAt(sql.lastIndexOf(","));
        sql.append(" where ");

        //循环条件字段
        for (Map.Entry<String ,Object> entry:hashMapWhere.entrySet()) {
            sql.append(entry.getKey());
            sql.append(" = ? and ");
            listParams.add(entry.getKey());
        }
        sql.delete(sql.lastIndexOf(" and "),sql.length());
        return sql.toString();

    }


    String getInsertSql(T t,List<Object> listParams) throws Exception {
        HashMap<String, Object> hashMapUpdate = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        Object value;
        for (Field f : fields) {
            f.setAccessible(true);
            TableColName annotation = f.getAnnotation(TableColName.class);
            String fieldName;
            if (annotation != null) {
                fieldName = annotation.value();
            }else{
                fieldName = f.getName();
            }
            value = f.get(t);
            if(value==null){
                continue;
            }
            hashMapUpdate.put(fieldName, value);
        }
        //获取表名称
        String tableName = clazz.getAnnotation(TableName.class).value();
        StringBuilder sql = new StringBuilder();
        sql.append("insert into  ");
        sql.append(tableName);
        sql.append(" ( ");
        //循环需要更新的字段
        for (Map.Entry<String ,Object> entry: hashMapUpdate.entrySet()) {
            sql.append(entry.getKey());
            sql.append(" , ");
            listParams.add(entry.getKey());
        }
        if(listParams.size()<1){
            throw new Exception("没有字段需要新增");
        }
        sql.deleteCharAt(sql.lastIndexOf(","));
        sql.append(" ) values (  ");
        for (int i = 0 ;i<listParams.size();i++){
            sql.append(" ?,");
        }
        sql.deleteCharAt(sql.lastIndexOf(","));
        sql.append(" ) ");
        return sql.toString();
    }
}





















