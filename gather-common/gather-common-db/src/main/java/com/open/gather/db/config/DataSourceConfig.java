package com.open.gather.db.config;


import javax.sql.DataSource;

import com.open.gather.db.config.util.DataSourceKey;
import com.open.gather.db.config.util.DynamicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.baomidou.mybatisplus.core.MybatisConfiguration;
import com.baomidou.mybatisplus.extension.spring.MybatisSqlSessionFactoryBean;





/**
 * @ClassName DataSourceConfig
 * @描述 数据源配置  sqlSessionFactory整合
 * @创建人 tong
 * @Date 2019/8/1 23:31
 **/
@Configuration
//@ConditionalOnProperty(name = {"spring.datasource.dynamic.enable"}, matchIfMissing = false, havingValue = "true")
public class DataSourceConfig {


//	创建数据源
//	所有引入db-core的模块都需要一个核心库，可以是user-center，也可以是oauth-center,file-center ,sms-center
	@Bean
	@ConfigurationProperties("spring.datasource.druid.core")
	public DataSource dataSourceCore(){
	    return DruidDataSourceBuilder.create().build();
	}
//	所有的核心库共享一个日志中心模块，改模块不采用mysql中的innodb引擎，采用归档引擎
	@Bean
	@ConfigurationProperties("spring.datasource.druid.log")
	public DataSource dataSourceLog(){
	    return DruidDataSourceBuilder.create().build();
	}
	
	

    @Bean // 只需要纳入动态数据源到spring容器
    @Primary
    public DataSource dataSource() {
        DynamicDataSource dataSource = new DynamicDataSource();
        DataSource coreDataSource = this.dataSourceCore();
        DataSource logDataSource = this.dataSourceLog();
        dataSource.addDataSource(DataSourceKey.core, coreDataSource);
        dataSource.addDataSource(DataSourceKey.log, logDataSource);
        dataSource.setDefaultTargetDataSource(coreDataSource);
        return dataSource;
    }

    
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactory(@Qualifier("dataSource") DataSource dataSource)
            throws Exception {
    	MybatisSqlSessionFactoryBean sqlSessionFactory = new MybatisSqlSessionFactoryBean();
		sqlSessionFactory.setDataSource(dataSource);
		sqlSessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath*:com/open/**/dao/*.xml"));

		MybatisConfiguration configuration = new MybatisConfiguration();
		// configuration.setDefaultScriptingLanguage(MybatisXMLLanguageDriver.class);
		configuration.setLogImpl(org.apache.ibatis.logging.stdout.StdOutImpl.class);
		configuration.setMapUnderscoreToCamelCase(true);
		configuration.setCacheEnabled(false);
		sqlSessionFactory.setConfiguration(configuration);
		// sqlSessionFactory.setPlugins(new Interceptor[]{
		// //PerformanceInterceptor(),OptimisticLockerInterceptor()
		// paginationInterceptor() //添加分页功能
		// });
		// sqlSessionFactory.setGlobalConfig(globalConfiguration());
		return sqlSessionFactory.getObject();
    }

    
    @Bean // 将数据源纳入spring事物管理
    public DataSourceTransactionManager transactionManager(@Qualifier("dataSource")  DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }
   
}
