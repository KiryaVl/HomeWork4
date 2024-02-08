package hw.HomeWork4.repositorys;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import hw.HomeWork4.models.Task;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TaskRepository {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File jsonFile = new File("tasks.json");
    private List<Task> tasks;

    public TaskRepository() {
        loadTasksFromFile();
    }

    private void loadTasksFromFile() {
        try {
            if (!jsonFile.exists()) {
                tasks = new ArrayList<>();
            } else {
                tasks = objectMapper.readValue(jsonFile, new TypeReference<List<Task>>() {});
            }
        } catch (IOException e) {
            // Обработка ошибок при чтении файла
            tasks = new ArrayList<>();
            e.printStackTrace();
        }
    }

    public List<Task> findAll() {
        return tasks;
    }

    public Task findById(UUID id) {
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Task task) {
        tasks.add(task);
        saveTasksToFile();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        saveTasksToFile();
    }

    private void saveTasksToFile() {
        try {
            objectMapper.writeValue(jsonFile, tasks);
        } catch (IOException e) {
            // Обработка ошибок при записи в файл
            e.printStackTrace();
        }
    }
}

