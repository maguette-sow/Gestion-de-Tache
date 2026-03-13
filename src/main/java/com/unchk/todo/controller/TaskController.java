package com.unchk.todo.controller;

import com.unchk.todo.dto.TaskDTO;
import com.unchk.todo.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private final TaskService service;

    public TaskController(TaskService service) {
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {

        model.addAttribute("tasks", service.findAll());
        model.addAttribute("task", new TaskDTO());

        return "tasks";
    }

    @PostMapping("/add")
    public String add(@Valid @ModelAttribute("task") TaskDTO dto,
                      BindingResult result,
                      Model model,
                      RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            model.addAttribute("tasks", service.findAll());
            return "tasks";
        }

        service.create(dto);

        redirectAttributes.addFlashAttribute("success",
                "Tâche ajoutée avec succès");

        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Long id, Model model) {

        TaskDTO task = service.findById(id);

        model.addAttribute("task", task);

        return "edit-task";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable Long id,
                         @ModelAttribute("task") TaskDTO dto) {

        service.update(id, dto);

        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {

        service.delete(id);

        return "redirect:/tasks";
    }

    @GetMapping("/complete/{id}")
    public String complete(@PathVariable Long id) {

        service.markAsCompleted(id);

        return "redirect:/tasks";
    }
}