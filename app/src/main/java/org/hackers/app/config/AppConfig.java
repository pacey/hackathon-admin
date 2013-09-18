package org.hackers.app.config;

import org.h2.Driver;
import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import javax.transaction.TransactionManager;
import java.io.IOException;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.hackers.app")
public class AppConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource(){
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL("jdbc:h2:hackathon-admin");
		return dataSource;
	}

	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource){
		try {
			LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
			sessionFactoryBean.setDataSource(dataSource);
			sessionFactoryBean.setPackagesToScan("org.hackers.domain");
			Properties hibernateProperties = new Properties();
			hibernateProperties.setProperty("hibernate.connection.driver_class", Driver.class.getName());
			hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
			hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
			sessionFactoryBean.setHibernateProperties(hibernateProperties);
			sessionFactoryBean.afterPropertiesSet();
			return sessionFactoryBean.getObject();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Autowired
	@Bean(name = "transactionManager")
	public PlatformTransactionManager getTransactionManager(SessionFactory sessionFactory){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);
		transactionManager.afterPropertiesSet();
		return transactionManager;
	}

}
