package project.dao;

import org.springframework.jdbc.core.RowMapper;
import project.model.User;
import project.model.UserRole;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int row) throws SQLException {
        User user = new User(resultSet.getInt("id"),
                             resultSet.getString("firstName"),
                             resultSet.getString("lastName"),
                             resultSet.getString("email"),
                             resultSet.getString("password"),
                             UserRole.getUserRole(resultSet.getInt("userRole"))
        );

        user.setSubscription(resultSet.getString("SUBSCRIPTION"));
        user.setRegistrationDate(resultSet.getDate("REGISTRATIONDATE").toLocalDate());
        return user;
    }
}
