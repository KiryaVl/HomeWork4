package hw.HomeWork4.services;

import hw.HomeWork4.models.Task;
import hw.HomeWork4.repositorys.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    private List<Task> tasks = new ArrayList<>();

    private TaskRepository taskRepository = new TaskRepository();

    public void addTask(String taskName, String taskDescription) {
        Task task = new Task(UUID.randomUUID(), taskName, taskDescription);
        tasks.add(task);
        taskRepository.save(task);
    }

    public void removeTask(UUID taskId) {
        tasks.removeIf(task -> task.getId().equals(taskId));
    }

    public List<Task> getTasks() {
        if (taskRepository.findAll() != null) {
            return taskRepository.findAll();
        } return tasks;
    }

    public Task getTaskById(UUID taskId) {
        return tasks.stream()
                .filter(task -> task.getId().equals(taskId))
                .findFirst()
                .orElse(null);
    }
}
