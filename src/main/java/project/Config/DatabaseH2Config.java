package project.Config;

import org.h2.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;


import javax.sql.DataSource;
import java.sql.SQLException;

@Configuration
@PropertySource("classpath:/db.properties")
public class DatabaseH2Config {
    @Value("${url}")
    private String  url;
    @Value("${user}")
    private String  user;
    @Value("${password}")
    private String password;

    ResourceDatabasePopulator populator = new ResourceDatabasePopulator();

    @Bean
    public DataSource getDataSource() {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setDriver(new Driver());
        simpleDriverDataSource.setUrl(url);
        simpleDriverDataSource.setUsername(user);
        simpleDriverDataSource.setPassword(password);

//        populator.addScript(new ClassPathResource("schema.sql"));
//        populator.addScript(new ClassPathResource("populatingUserTable.sql"));
//        populator.addScript(new ClassPathResource("populatingTaskTable.sql"));
//        populator.execute(simpleDriverDataSource);

        return simpleDriverDataSource;
    }

    @Bean
    public JdbcTemplate getJdbcTemplate() {
        return new JdbcTemplate(getDataSource());
    }




}
