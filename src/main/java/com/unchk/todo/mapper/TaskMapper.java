package com.unchk.todo.mapper;

import com.unchk.todo.dto.TaskDTO;
import com.unchk.todo.entity.Task;
import org.springframework.stereotype.Component;

@Component
public class TaskMapper {

    public TaskDTO toDTO(Task task) {

        TaskDTO dto = new TaskDTO();

        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setStatus(task.getStatus().name());

        return dto;
    }

    public Task toEntity(TaskDTO dto) {

        Task task = new Task();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());
        task.setStatus(Task.Status.EN_COURS);

        return task;
    }
}