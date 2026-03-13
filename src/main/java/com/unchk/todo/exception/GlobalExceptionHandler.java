package com.unchk.todo.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(TaskNotFoundException.class)
    public String handleTaskNotFound(TaskNotFoundException ex, Model model) {

        model.addAttribute("errorMessage", ex.getMessage());

        return "error";
    }

}