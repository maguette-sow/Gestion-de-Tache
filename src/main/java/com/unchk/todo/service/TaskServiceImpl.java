package com.unchk.todo.service;

import com.unchk.todo.dto.TaskDTO;
import com.unchk.todo.entity.Task;
import com.unchk.todo.mapper.TaskMapper;
import com.unchk.todo.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository repository;
    private final TaskMapper mapper;

    public TaskServiceImpl(TaskRepository repository, TaskMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public TaskDTO create(TaskDTO dto) {

        Task task = mapper.toEntity(dto);

        return mapper.toDTO(repository.save(task));
    }

    @Override
    public List<TaskDTO> findAll() {

        return repository.findAll()
                .stream()
                .map(mapper::toDTO)
                .toList();
    }

    @Override
    public TaskDTO findById(Long id) {

        Task task = repository.findById(id)
                .orElseThrow();

        return mapper.toDTO(task);
    }

    @Override
    public TaskDTO update(Long id, TaskDTO dto) {

        Task task = repository.findById(id)
                .orElseThrow();

        task.setTitle(dto.getTitle());
        task.setDescription(dto.getDescription());

        return mapper.toDTO(repository.save(task));
    }

    @Override
    public void delete(Long id) {

        repository.deleteById(id);
    }

    @Override
    public void markAsCompleted(Long id) {

        Task task = repository.findById(id)
                .orElseThrow();

        task.setStatus(Task.Status.TERMINE);

        repository.save(task);
    }
}