package hw.HomeWork4.services;

import hw.HomeWork4.models.Task;
import hw.HomeWork4.repositorys.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public void addTask(String taskName, String taskDescription) {
        Task task = new Task(UUID.randomUUID(), taskName, taskDescription);
        taskRepository.save(task);
    }

    public void removeTask(UUID taskId) {
        taskRepository.deleteById(taskId);
    }

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task getTaskById(UUID taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }
}

