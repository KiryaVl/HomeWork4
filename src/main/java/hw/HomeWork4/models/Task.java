package hw.HomeWork4.models;

import lombok.Data;
import lombok.Setter;
import javax.persistence.Entity;
import org.springframework.data.annotation.Id;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
public class Task {
    enum TaskStatus {
        NOT_STARTED, IN_PROGRESS, COMPLETED;
    }

    @Id
    private UUID id;
    private String taskName;
    private String taskDescription;
    private TaskStatus taskStatus;
    @Setter
    private LocalDateTime dateTaskCreate;

    public Task() {
        this.id = UUID.randomUUID();
    }

    // Конструктор с параметрами для создания объекта с конкретными значениями
    public Task(UUID id, String taskName, String taskDescription) {
        this.id = id;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = TaskStatus.NOT_STARTED;
        this.dateTaskCreate = LocalDateTime.now();
    }

    public UUID getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public LocalDateTime getDateTaskCreate() {
        return dateTaskCreate;
    }

}
