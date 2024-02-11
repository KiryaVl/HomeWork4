package hw.HomeWork4.controllers;

import hw.HomeWork4.models.Task;
import hw.HomeWork4.repositorys.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public List<Task> index(Model model) {
        return taskRepository.findAll();
    }
}
