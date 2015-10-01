package com.monsmartphone.webapp.persistence.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.instrument.classloading.InstrumentationLoadTimeWeaver;
import org.springframework.orm.hibernate4.HibernateExceptionTranslator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableJpaRepositories(basePackages = "com.monsmartphone.webapp.persistence.repository")
@EnableTransactionManagement
public class PersistenceConfig {

	@Bean
	public JpaVendorAdapter jpaVendorAdapter(final Environment environment) {
		final HibernateJpaVendorAdapter rv = new HibernateJpaVendorAdapter();

		rv.setDatabase(Database.MYSQL);
		rv.setDatabasePlatform(org.hibernate.dialect.MySQL5Dialect.class.getName());
		rv.setGenerateDdl(true);
		rv.setShowSql(true);

		return rv;
	}

	@Bean
	public PlatformTransactionManager transactionManager(final EntityManagerFactory entityManagerFactory) {
		final JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory);
		return transactionManager;
	}

	@Bean
	public FactoryBean<EntityManagerFactory> entityManagerFactory(final Environment environment, final DataSource dataSource, final JpaVendorAdapter jpaVendorAdapter) {
		final Map<String, String> properties = new HashMap<>();
		properties.put("hibernate.generate_statistics", "false");
		properties.put("hibernate.hbm2ddl.auto", "validate");

		final LocalContainerEntityManagerFactoryBean rv = new LocalContainerEntityManagerFactoryBean();
		rv.setPersistenceUnitName("entities_resourceLocale");
		rv.setPackagesToScan("com.monsmartphone.webapp.persistence.entity");
		rv.setJpaDialect(new HibernateJpaDialect());
		rv.setJpaVendorAdapter(jpaVendorAdapter);
		rv.setDataSource(dataSource);
		rv.setLoadTimeWeaver(new InstrumentationLoadTimeWeaver());
		rv.setJpaPropertyMap(properties);
		return rv;
	}

	@Bean
	public HibernateExceptionTranslator hibernateExceptionTranslator() {
		return new HibernateExceptionTranslator();
	}
}