package dbservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;

@Service
public abstract class DataService {
    
    protected DataSource ds;
    
    @Autowired
    protected void setDataSource(DataSource ds){
        this.ds = ds;
    }
    
}
