package courses.Java_PRO.task_4.dao;

import courses.Java_PRO.task_4.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public User createUser(String username) {
        String sql = "INSERT INTO users (username) VALUES (?) RETURNING id";
        Long id = jdbcTemplate.queryForObject(sql, new Object[]{username}, Long.class);
        return new User(id, username);
    }

    public void deleteUser(Long id) {
        String sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    public User getUser(Long id) {
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) ->
                new User(rs.getLong("id"), rs.getString("username"))
        );
    }

    public List<User> getAllUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) ->
                new User(rs.getLong("id"), rs.getString("username"))
        );
    }
}
