package dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public abstract class DataService {
    
    private JdbcTemplate jdbcTemplate;

    protected JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }
    
    @Autowired
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
}
