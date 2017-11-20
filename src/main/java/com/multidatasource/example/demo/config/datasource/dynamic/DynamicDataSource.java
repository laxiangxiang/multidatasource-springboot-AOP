package com.multidatasource.example.demo.config.datasource.dynamic;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * 数据源路由类
 *
 * 动态数据源能进行自动切换的核心就是spring底层提供了AbstractRoutingDataSource类进行数据源的路由的，
 * 我们主要继承这个类，实现里面的方法即可实现我们想要的，这里主要是实现方法：determineCurrentLookupKey（），
 * 而此方法只需要返回一个数据库的名称即可，所以我们核心的是有一个类来管理数据源的线程池，这个类才是动态数据源的核心处理类。
 * 还有另外就是我们使用aop技术在执行事务方法前进行数据源的切换
 */
public class DynamicDataSource extends AbstractRoutingDataSource{

    /*
    * 代码中的determineCurrentLookupKey方法取得一个字符串，
    * 该字符串将与配置文件中的相应字符串进行匹配以定位数据源，配置文件，即applicationContext.xml文件中需要要如下代码：(non-Javadoc)
    * @see org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource#determineCurrentLookupKey()
    */
    @Override
    protected Object determineCurrentLookupKey() {
        /*
        * DynamicDataSourceContextHolder代码中使用setDataSourceType
        * 设置当前的数据源，在路由类中使用getDataSourceType进行获取，
        *  交给AbstractRoutingDataSource进行注入使用。
        */
//        return null;
        return DynamicDataSourceContextHolder.getDataSourceType();
    }
}
