package project.dao;

import LegacySecurityModule.SecurityModuleImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import project.model.User;
import project.model.UserRole;
//import LegacySecurityModule

import java.time.LocalDate;

@Component
public class UserDaoJdbcImpl implements UserDao {

    @Autowired
    public SecurityModuleImpl securityModuleImpl;

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<User> userRowMapper = new UserRowMapper();

    private final String INSERT = "insert into user (firstName, lastName, email, password, registrationDate, subscription, userRole) values(?,?,?,?,?,?,?)";
    private final String DELETE_BY_ID = "DELETE FROM USER WHERE id = ?";
    private final String FIND_BY_ID = "SELECT * FROM USER WHERE id = ?";
    private final String FIND_BY_EMAIL  = "SELECT * FROM USER WHERE EMAIL = ?";
    private final String UPDATE_BY_ID = "UPDATE USER SET FIRSTNAME=?, LASTNAME=?, EMAIL=?, PASSWORD=?, SUBSCRIPTION=?, USERROLE=? WHERE id=?";
    private final String UPDATE_SUBSCRIPTION_BY_ID = "UPDATE USER SET SUBSCRIPTION=? WHERE id=?";

    @Autowired
    public UserDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public User createUser(String firstName, String lastName,
                           String email, String password, UserRole userRole) {
        LocalDate localDate = LocalDate.now();
        jdbcTemplate.update(INSERT,  firstName, lastName,
                            email, password, localDate, "", userRole.getI());

        return jdbcTemplate.queryForObject(FIND_BY_EMAIL, userRowMapper, email);
    }

    @Override
    public User findUserById(int userId) {
        return jdbcTemplate.queryForObject(FIND_BY_ID, userRowMapper, userId);
    }

    @Override
    public boolean deleteUserById(int userId) {
        jdbcTemplate.update(DELETE_BY_ID,userId);
        return true;
    }

    @Override
    public boolean updateUser(User user) {
        jdbcTemplate.update(UPDATE_BY_ID,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword(),
                user.getSubscription(),
                user.getUserRole().getI(),
                user.getId()
        );
        return true;
    }

    @Override
    public boolean updateSubscriptionById(String hash, int id) {
        jdbcTemplate.update(UPDATE_SUBSCRIPTION_BY_ID, hash, id);
        return true;
    }
}
