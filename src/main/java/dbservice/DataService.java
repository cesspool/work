package dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public abstract class DataService {
    
    private JdbcTemplate jdbcTemplate;
    private TransactionTemplate transactionTemplate;
    
    protected JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }
    
    @Autowired
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    protected TransactionTemplate getTransactionTemplate(){
        return transactionTemplate;
    }
    
    @Autowired
    private void setTransactonTemplate(TransactionTemplate transactionTemplate){
        this.transactionTemplate = transactionTemplate;
    }
    
}
