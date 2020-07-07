package com.profinch.finflowz.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


import javax.sql.DataSource;

@Configuration
@PropertySource(
		value = "file:${PROPERTY_PATH}",
		factory = YamlPropertyLoaderFactory.class)
@Getter
@Setter
public class CustomerConfig {
	@Value("${finflowz.batch.chunksize}")
	public Integer chunkSize;

	@Value("${finflowz.datasource.url}")
	public String dataSourceUrl;

	@Value("${finflowz.datasource.username}")
	public String dataSourceUsername;



	@Value("${finflowz.datasource.password}")
	public String dataSourcePassword;



	@Value("${finflowz.datasource.driver}")
	public String dataSourceDriver;




	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(dataSourceDriver);
		dataSource.setUrl(dataSourceUrl);
		dataSource.setUsername(dataSourceUsername);
		dataSource.setPassword(dataSourcePassword);
		return dataSource;
	}
}