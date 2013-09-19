package org.hackers.app.config;

import org.h2.Driver;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "org.hackers.app")
@Profile("test")
public class TestAppConfig extends AppConfig {

	@Bean(name = "dataSource")
	public DataSource getDataSource() {
		JdbcDataSource dataSource = new JdbcDataSource();
		dataSource.setURL("jdbc:h2:mem:hackathon-admin;DB_CLOSE_DELAY=-1");
		return dataSource;
	}


	@Bean(name = "hibernateProperties")
	public Properties getHibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.connection.driver_class", Driver.class.getName());
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "create");
		hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		return hibernateProperties;
	}

}
