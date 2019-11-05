package project.model;

import org.springframework.stereotype.Component;

public enum TaskPriority {
    LOW(1),
    MEDIUM(2),
    HIGHT(3),
    IMPORTANT(4);

    int i;
    private static TaskPriority[] taskPriorities = TaskPriority.values();

    TaskPriority(int i) { this.i = i;}

    public int getI(){
        return i;
    }

    public static TaskPriority getTaskPriority(int i) {
        for(TaskPriority task : taskPriorities) {
            if(task.getI() == i) {
                return task;
            }
        }
        return null;
    }

}
