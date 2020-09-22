package com.projectmanager.util;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@ImportResource({"classpath:hibernate5Configuration.xml"})
public class HibernateConfig {

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("com.projectmanager.entity");
        sessionFactory.setHibernateProperties(hibernateProperties());

        return sessionFactory;
    }

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        //PROD
        dataSource.setUrl("jdbc:mysql://pecoprojectsdb.cgtw3wrdwjtx.us-east-2.rds.amazonaws.com:3306/pecoProjects?useSSL=false");
        dataSource.setUsername("pecoProjectAdmin");
        dataSource.setPassword("pecoProjects9933");

        //UAT
        /*dataSource.setUrl("jdbc:mysql://hamdule.cmbzdfvjyats.us-east-2.rds.amazonaws.com:3306/inventoryMgmt");
        dataSource.setUsername("mhamdule");
        dataSource.setPassword("mhamdule9933");*/

        //LOCAL
        /*dataSource.setUrl("jdbc:mysql://localhost:3306/inventoryMgmt");
        dataSource.setUsername("admin");
        dataSource.setPassword("admin123");*/

        return dataSource;
    }

    public PlatformTransactionManager hibernateTransactionManager(){
        HibernateTransactionManager transactionManager
        = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }

    private final Properties hibernateProperties() {
        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(
          "hibernate.hbm2ddl.auto", "update");
        hibernateProperties.setProperty(
          "hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
        hibernateProperties.setProperty("hibernate.connection.autocommit","true");
        hibernateProperties.setProperty("hibernate.show_sql","true");

        return hibernateProperties;
    }
}