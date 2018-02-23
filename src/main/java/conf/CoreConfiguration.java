package conf;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan({"dbservice"})
public class CoreConfiguration {

    @Autowired
    private Environment env;

    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl(env.getProperty("database.url"));
        ds.setUsername(env.getProperty("database.user"));
        ds.setPassword(env.getProperty("database.password"));
        ds.setMaximumPoolSize(Integer.parseInt(env.getProperty("database.poolsize")));
        ds.setConnectionTimeout(Long.parseLong(env.getProperty("database.maxWait"))); // in ms
        //ds.setAutoCommit(isAutoCommit);
        return ds;
    }
}
