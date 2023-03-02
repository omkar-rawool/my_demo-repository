package com.mappingdemo.mapping.config;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class RetryingCassandraClusterFactoryBean extends CassandraClusterFactoryBean {

    private static final Logger LOG =
            LoggerFactory.getLogger(RetryingCassandraClusterFactoryBean.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        connect();
    }

    private void connect() throws Exception {
        try {
            super.afterPropertiesSet();
        } catch (TransportException | IllegalArgumentException | NoHostAvailableException e) {
            LOG.warn(e.getMessage());
            LOG.warn("Retrying connection in 10 seconds");
            sleep();
            connect();
        }
    }

    private void sleep() {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException ignored) {
        }
    }
}