package dev.jonatansoares.daily.tasks.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.jonatansoares.daily.tasks.model.Task;
import dev.jonatansoares.daily.tasks.repository.TaskRepository;

@Service
public class TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	public List<Task> listAll() {
		return taskRepository.findAll(new Sort(Sort.Direction.DESC, "id"));
	}
	
	public Task getById(Long id) {
		return taskRepository.getOne(id);
	}
	
	public void save(Task task) {
		taskRepository.save(task);
	}
	
	public void delete(Long id) {
		taskRepository.deleteById(id);
	}
}
