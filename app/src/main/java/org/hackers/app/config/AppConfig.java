package org.hackers.app.config;

import org.h2.jdbcx.JdbcDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate3.annotation.AnnotationSessionFactoryBean;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.hackers.app")
public class AppConfig {

	@Bean
	public DataSource getDataSource(){
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL("localhost/~/hackathon-admin");
		return dataSource;
	}

	@Bean
	@Autowired
	public SessionFactory getSessionFactory(DataSource dataSource){
		AnnotationSessionFactoryBean sessionFactoryBean = new AnnotationSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource);
		sessionFactoryBean.setPackagesToScan(new String[]{"org.hacker.domain"});
		return sessionFactoryBean.getObject();
	}

	@Bean
	@Autowired
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory){
		return new HibernateTransactionManager(sessionFactory);
	}
}
