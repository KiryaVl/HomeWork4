package hw.HomeWork4.models;

import lombok.Data;

import java.util.UUID;

@Data
public class Task {

    private UUID id;
    private String taskName;
    private String taskDescription;

    public Task() {
        this.id = UUID.randomUUID();
    }

    // Конструктор с параметрами для создания объекта с конкретными значениями
    public Task(UUID id, String taskName, String taskDescription) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", taskName='" + taskName + '\'' +
                ", taskDescription='" + taskDescription + '\'' +
                '}';
    }
}
