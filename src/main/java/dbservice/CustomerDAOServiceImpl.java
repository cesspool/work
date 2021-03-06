package dbservice;

import beans.Customer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.util.Optional;


@Service
public class CustomerDAOServiceImpl extends DataService implements CustomerDAOService {
    private static final Logger logger = LoggerFactory.getLogger(CustomerDAOServiceImpl.class);

    private final static String SQL_INSERT = "INSERT INTO logistics.customer " +
        " (firstName, lastName, patronymic, address, telephone, email, hashcode, admin, manager) " +
        " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

    private final static String SQL_UPDATE = "UPDATE logistics.customer " +
        " SET firstName=?, lastName=?, patronymic=?, address=?, telephone=?, email=?, hashcode=?" +
        " WHERE id=?";

    private final static String SQL_UPDATE_PASSWORD = "UPDATE logistics.customer SET hashcode=? WHERE id=?";

    private final static String SQL_SEL_BY_ID = "SELECT firstName, lastName, patronymic, address, telephone, email, hashcode, admin, manager " +
        " FROM logistics.customer WHERE id=?";

    private final static String SQL_SEL_BY_EMAIL = "SELECT id, firstName, lastName, patronymic, address, telephone, hashcode, admin, manager " +
        " FROM logistics.customer WHERE email=?";

    private final static String SQL_CHANGE_STATUS = "update logistics.order set ready = true where name = ?";
    
    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> getByID(Long ID) {
        Customer res = getJdbcTemplate().query(SQL_SEL_BY_ID, new Object[] {ID}, (rs) -> {
            if (!rs.next()) {
                return null;
            }
            Customer c = new Customer();
            c.setId(ID);
            int idx = 1;
            c.setFirstName(rs.getString(idx++));
            c.setLastName(rs.getString(idx++));
            c.setPatronymic(rs.getString(idx++));
            c.setAddress(rs.getString(idx++));
            c.setTelephone(rs.getString(idx++));
            c.setEmail(rs.getString(idx++));
            c.setMd5(rs.getString(idx++));
            c.setAdmin(rs.getBoolean(idx++));
            c.setManager(rs.getBoolean(idx++));
            return c;
        });
        return Optional.ofNullable(res);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> getByEmail(String email) {
        Customer res = getJdbcTemplate().query(SQL_SEL_BY_EMAIL, new Object[] {email}, (rs) -> {
            if (!rs.next()) {
                return null;
            }
            Customer c = new Customer();
            c.setEmail(email);
            int idx = 1;
            c.setId(rs.getLong(idx++));
            c.setFirstName(rs.getString(idx++));
            c.setLastName(rs.getString(idx++));
            c.setPatronymic(rs.getString(idx++));
            c.setAddress(rs.getString(idx++));
            c.setTelephone(rs.getString(idx++));
            c.setMd5(rs.getString(idx++));
            c.setAdmin(rs.getBoolean(idx++));
            c.setManager(rs.getBoolean(idx++));
            return c;
        });
        return Optional.ofNullable(res);
    }

    @Override
    @Transactional
    public void insertCustomer(final Customer customer) {
        try {
            KeyHolder keyHolder = new GeneratedKeyHolder();
            getJdbcTemplate().update((con) -> {
                PreparedStatement pst = con.prepareStatement(SQL_INSERT, new String[] {"id"}); // Statement.RETURN_GENERATED_KEYS
                int idx = 1;
                pst.setString(idx++, customer.getFirstName());
                pst.setString(idx++, customer.getLastName());
                pst.setString(idx++, customer.getPatronymic());
                pst.setString(idx++, customer.getAddress());
                pst.setString(idx++, customer.getTelephone());
                pst.setString(idx++, customer.getEmail());
                pst.setString(idx++, customer.getMd5());
                //pst.setBytes(idx++, customer.getMd5().getBytes());
                pst.setBoolean(idx++, customer.isAdmin());
                pst.setBoolean(idx++, customer.isManager());
                return pst;
            }, keyHolder);
            Long ID = keyHolder.getKey().longValue();
            customer.setId(ID);
        } catch (DataAccessException dEx) {
            Throwable ex = dEx.getCause();
            ex.toString();
        }
    }


    @Override
    @Transactional
    public void updateCustomer(Customer customer) {
        getJdbcTemplate().update(SQL_UPDATE, (ps) -> {
            int idx = 1;
            ps.setString(idx++, customer.getFirstName());
            ps.setString(idx++, customer.getLastName());
            ps.setString(idx++, customer.getPatronymic());
            ps.setString(idx++, customer.getAddress());
            ps.setString(idx++, customer.getTelephone());
            ps.setString(idx++, customer.getEmail());
            ps.setString(idx++, customer.getMd5());
            /// ps.setBoolean(idx++, customer.isAdmin());
            /// ps.setBoolean(idx++, customer.isManager());
            ps.setLong(idx++, customer.getId());
        });
    }

    @Override
    public void deleteCustomer(Customer customer) {}

    @Override
    @Transactional
    public void updatePassword(Customer customer,
                               String password) {
        getJdbcTemplate().update(SQL_UPDATE_PASSWORD, password, customer.getId());
    }
}
