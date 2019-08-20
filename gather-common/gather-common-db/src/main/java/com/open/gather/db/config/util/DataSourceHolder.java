package com.open.gather.db.config.util;


/**
 * @ClassName DataSourceKey
 * @描述 用于数据源切换
 * @创建人 tong
 * @Date 2019/8/1 23:31
 **/
public class DataSourceHolder {

    private static final ThreadLocal<DataSourceKey> dataSourceKey = new ThreadLocal<>();

    public static DataSourceKey getDataSourceKey() {
        return dataSourceKey.get();
    }

    public static void setDataSourceKey(DataSourceKey type) {
        dataSourceKey.set(type);
    }

    public static void clearDataSourceKey() {
        dataSourceKey.remove();
    }


}