package com.open.gather.db.config.util;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName DynamicDataSource
 * @描述 多数据源动态切换
 * @创建人 tong
 * @Date 2019/8/1 23:31
 **/
public class DynamicDataSource extends AbstractRoutingDataSource {

    private Map<Object, Object> datasources;



    public DynamicDataSource() {
        datasources = new HashMap<>();

        super.setTargetDataSources(datasources);

    }

    public <T extends DataSource> void addDataSource(DataSourceKey key, T data) {
        datasources.put(key, data);
    }

    protected Object determineCurrentLookupKey() {
        return DataSourceHolder.getDataSourceKey();
    }

}