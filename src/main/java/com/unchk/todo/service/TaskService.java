package com.unchk.todo.service;

import com.unchk.todo.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO create(TaskDTO dto);

    List<TaskDTO> findAll();

    TaskDTO findById(Long id);

    TaskDTO update(Long id, TaskDTO dto);

    void delete(Long id);

    void markAsCompleted(Long id);
}