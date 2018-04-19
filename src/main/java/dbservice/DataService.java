package dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public abstract class DataService {
    
    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private TransactionTemplate transactionTemplate;
    
    protected JdbcTemplate getJdbcTemplate(){
        return jdbcTemplate;
    }
    
    protected NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
    	return namedParameterJdbcTemplate;
    } 
    
    @Autowired
    private void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Autowired
    private void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
    	this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    
    protected TransactionTemplate getTransactionTemplate(){
        return transactionTemplate;
    }
    
    @Autowired
    private void setTransactonTemplate(TransactionTemplate transactionTemplate){
        this.transactionTemplate = transactionTemplate;
    }
    
}
