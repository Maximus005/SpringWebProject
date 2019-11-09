package project.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import project.model.Task;
import project.model.TaskPriority;

import java.time.LocalDate;
import java.util.List;

@Component
public class TaskDaoJdbcImpl implements TaskDao {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Task> taskRowMapper = new TaskRowMapper();

    private final String INSERT = "INSERT INTO task (taskName, DATEOFFINISHED, DESCRIPTION, USERID, PRIORITY) VALUES(?,?,?,?,?)";
    private final String FIND_BY_TASKNAME = "SELECT * FROM task WHERE taskName = ?";
    private final String DELETE_BY_ID = "delete from task where id = ?";
    private final String MARK_AS_FINISHED = "UPDATE task SET STATUS = TRUE WHERE id = ?";
    private final String SET_DATE_OF_FINISHED = "UPDATE task SET dateOfFinished = ? WHERE id = ?";
    private final String DELETE_DATE_OF_FINISHED = "UPDATE task SET dateOfFinished = null WHERE id = ?";
    private final String MARK_AS_UNFINISHED = "UPDATE task SET STATUS = FALSE WHERE id = ?";;
    private final String TASK_PRIORITY = "UPDATE task SET priority = ? WHERE id = ?";
    private final String ALL_TASKS_BY_USER_ID = "SELECT * FROM TASK WHERE ID = ?";
    private final String ALL_TASKS = "SELECT * FROM TASK";
    private final String TASK_BY_ID = "SELECT * FROM TASK WHERE ID = ?";
    private final String TASK_BY_NAME = "SELECT * FROM TASK WHERE taskname = ?";


    @Autowired
    public TaskDaoJdbcImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Task createTask(String taskName, int userId) {
        Task task = new Task(taskName, userId);
        jdbcTemplate.update(INSERT,
                task.getTaskName(),
                task.getDateOfFinished(),
                task.getDescription(),
                userId,
                task.getTaskPriority().getI());
        return jdbcTemplate.queryForObject(FIND_BY_TASKNAME, taskRowMapper ,task.getTaskName());
    }

    @Override
    public boolean deleteTaskById(int taskId) {
        jdbcTemplate.update(DELETE_BY_ID, taskId);
        return true;
    }

    @Override
    public boolean markTaskAsFinishedById(int taskId) {
        jdbcTemplate.update(MARK_AS_FINISHED, taskId);
        jdbcTemplate.update(SET_DATE_OF_FINISHED, LocalDate.now(),taskId);
        return true;
    }

    @Override
    public boolean markTaskAsUnFinishedById(int taskId) {
        jdbcTemplate.update(MARK_AS_UNFINISHED, taskId);
        jdbcTemplate.update(DELETE_DATE_OF_FINISHED, taskId);
        return true;
    }

    @Override
    public TaskPriority setTaskPriorityById(int taskId, TaskPriority taskPriority) {
        jdbcTemplate.update(TASK_PRIORITY, taskPriority.getI(), taskId);
        return taskPriority;
    }

    @Override
    public List<Task> findAllTasksByUserId(int userId) {
        return jdbcTemplate.query(ALL_TASKS_BY_USER_ID, taskRowMapper,userId);
    }

    @Override
    public List<Task> findAllTasks() {
        return jdbcTemplate.query(ALL_TASKS, taskRowMapper);
    }

    @Override
    public Task findTaskById(int taskId) {
        return jdbcTemplate.queryForObject(TASK_BY_ID, taskRowMapper,taskId);
    }

    @Override
    public Task findTaskByName(String name) {
        return jdbcTemplate.queryForObject(TASK_BY_NAME, taskRowMapper, name);
    }
}
