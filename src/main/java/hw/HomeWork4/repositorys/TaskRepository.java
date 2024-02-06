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

    public List<Task> findAll() {
        try {
            if (!jsonFile.exists()) {
                return new ArrayList<>();
            }
            return objectMapper.readValue(jsonFile, new TypeReference<List<Task>>() {});
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public Task findById(UUID id) {
        List<Task> tasks = findAll();
        return tasks.stream()
                .filter(task -> task.getId().equals(id))
                .findFirst()
                .orElse(null);
    }


    public void save(Task task) {
        try {
            List<Task> tasks = findAll();
            if (tasks == null) {
                tasks = new ArrayList<>();
            }
            tasks.add(task);
            objectMapper.writeValue(jsonFile, tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
