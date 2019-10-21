import java.time.LocalDate;


class Task {
    private Integer idTask;
    private Integer idUser;
    private User user;
    private String taskName;
    private Status status;
    private LocalDate startTime;
    private LocalDate endTime;

    public Task(Integer idTask, Integer idUser,
                String taskName, Status status) {
        this.idTask = idTask;
        this.idUser = idUser;
        this.taskName = taskName;
        this.status = status;
        this.startTime = LocalDate.now();
    }

    public Integer getIdTask() {
        return idTask;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public String getTaskName() {
        return taskName;
    }

    public Enum getStatus() {
        return status;
    }

    public LocalDate getStartTime() {
        return startTime;
    }

    public LocalDate getEndTime() {
        return endTime;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public void setIdUser(Integer idUser) {

        this.idUser = idUser;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setStartTime(LocalDate startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalDate endTime) {
        startTime = LocalDate.now();
        this.endTime = endTime;
    }
}
