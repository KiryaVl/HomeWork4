package hw.HomeWork4.controllers;

import hw.HomeWork4.models.Task;
import hw.HomeWork4.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
public class TaskController {

    @Autowired
    private TaskService taskService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.getTasks());
        return "index";
    }

    @GetMapping("/task/{id}")
    public String taskDetails(@PathVariable("id") UUID id, Model model) {
        Task task = taskService.getTaskById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "taskDetails";
        } else {
            return "error";
        }
    }

    @GetMapping("/addTask")
    public String showAddTaskForm(Model model) {
        model.addAttribute("task", new Task());
        return "addTaskForm";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute("task") Task task) {
        taskService.addTask(task.getTaskName(), task.getTaskDescription());
        return "redirect:/";
    }

    @PostMapping("/task/{id}/delete")
    public String deleteTask(@PathVariable("id") UUID id) {
        taskService.removeTask(id);
        return "redirect:/";
    }
}
