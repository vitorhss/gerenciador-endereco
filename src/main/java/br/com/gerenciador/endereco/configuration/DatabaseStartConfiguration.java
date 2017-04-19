package br.com.gerenciador.endereco.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

@Configuration
public class DatabaseStartConfiguration {
	
	@Bean
	public DataSource dataSource (){
		EmbeddedDatabaseBuilder databaseBuilder = new EmbeddedDatabaseBuilder();
		EmbeddedDatabase db = databaseBuilder.setType(EmbeddedDatabaseType.HSQL)
				.build();
		return db;
	}

}
