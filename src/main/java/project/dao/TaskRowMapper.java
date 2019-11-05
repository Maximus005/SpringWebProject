package project.dao;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import project.model.Task;
import project.model.TaskPriority;

import java.sql.ResultSet;
import java.sql.SQLException;

import static java.util.Objects.nonNull;

public class TaskRowMapper implements RowMapper<Task> {
    @Override
    public Task mapRow(ResultSet resultSet, int i) throws SQLException {
        Task task = new Task(resultSet.getString("taskName"),
                             resultSet.getInt("userId"));
        task.setId(resultSet.getInt("id"));

        if(nonNull(resultSet.getDate("DATEOFFINISHED"))) {
            task.setDateOfFinished(resultSet.getDate("DATEOFFINISHED").toLocalDate());
        }
        task.setDescription(resultSet.getString("DESCRIPTION"));
        task.setStatus(resultSet.getBoolean("status"));
        task.setTaskPriority(TaskPriority.getTaskPriority(resultSet.getInt("priority")));
        return task;
    }
}
