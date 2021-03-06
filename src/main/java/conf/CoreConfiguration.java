package conf;

import com.zaxxer.hikari.HikariDataSource;

import dijkstra.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:db.properties")
@ComponentScan({"dbservice", "service"})
@EnableTransactionManagement
public class CoreConfiguration {

    @Autowired
    private Environment env;
//    private DataSource ds;

    @Bean(destroyMethod="close")
    public DataSource dataSource() {
        HikariDataSource ds = new HikariDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setJdbcUrl(env.getProperty("database.url"));
        ds.setUsername(env.getProperty("database.user"));
        ds.setPassword(env.getProperty("database.password"));
        ds.setMaximumPoolSize(Integer.parseInt(env.getProperty("database.poolsize")));
        ds.setConnectionTimeout(Long.parseLong(env.getProperty("database.maxWait"))); // in ms
        ds.setAutoCommit(false);
        return ds;
    }
  
    @Bean
    public JdbcTemplate jdbcTemplate(@Autowired DataSource ds){
        JdbcTemplate jdbcTemplate = new JdbcTemplate(ds);
        return jdbcTemplate;
    }
  
    @Bean
    public NamedParameterJdbcTemplate namedParameterJdbcTemplate(@Autowired DataSource ds) {
    	NamedParameterJdbcTemplate npJdbcTemplate = new NamedParameterJdbcTemplate(ds);
    	return npJdbcTemplate;
    }
    
    
    @Bean
    public  PlatformTransactionManager transactionManager(@Autowired DataSource ds){
        DataSourceTransactionManager dsTransactionManager = new DataSourceTransactionManager(ds);
        return dsTransactionManager;
    } 
    
    @Bean
    @Autowired
    public TransactionTemplate transactionTemplate(PlatformTransactionManager transactionManager){
        TransactionTemplate tt = new TransactionTemplate(transactionManager);
        return tt;
    } 
    
    @Bean
    public Test test() {
    	return new Test();
    }
}
