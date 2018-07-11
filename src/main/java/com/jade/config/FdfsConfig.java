package com.jade.config;

import org.apache.tomcat.jdbc.pool.ConnectionPool;
import org.csource.fastdfs.StorageClient1;
import org.springframework.beans.factory.annotation.Value;

/**
 *
 */
public class FdfsConfig {

    @Value("${fdfs.tracker-list}")
    private String[] fdfsServer;

    @Value("fdfs.so-timeout")
    private Integer so_timeout;

    @Value("fdfs.connect-timeout")
    private Integer connect_timeout;

    @Value("fdfs.resHost")
    private String resHost;

    private StorageClient1 storageClient1;

    private ConnectionPool connectionPool;


}
