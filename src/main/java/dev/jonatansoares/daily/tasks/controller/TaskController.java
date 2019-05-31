package dev.jonatansoares.daily.tasks.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import dev.jonatansoares.daily.tasks.model.Task;
import dev.jonatansoares.daily.tasks.service.TaskService;

@Controller
@RequestMapping("/task")
public class TaskController {

	private static final String ADD_TASK = "addTask";
	private static final String LIST_TASKS = "listTasks";
	private static final String EDIT_TASK = "editTask";
	private static final String REDIRECT_LIST = "redirect:list";

	@Autowired
	private TaskService taskService;

	@GetMapping("/add")
	public String addPage(Task task) {
		return ADD_TASK;
	}

	@PostMapping("/add-action")
	public ModelAndView addTask(@Validated Task task, Errors errors) {
		if (errors.hasErrors()) {
			return new ModelAndView(ADD_TASK);
		}
		ModelAndView mv = new ModelAndView(ADD_TASK);
		taskService.save(task);
		mv.addObject(new Task());
		mv.addObject("mensagem", "Atividade adicionada com sucesso!");
		return mv;
	}

	@GetMapping("/list")
	public ModelAndView listTasks() {
		ModelAndView mv = new ModelAndView(LIST_TASKS);
		mv.addObject("tasks", taskService.listAll());
		return mv;
	}

	@GetMapping("/change/{id}")
	public ModelAndView editPage(@PathVariable Long id) {
		Task task = taskService.getById(id);
		return new ModelAndView(EDIT_TASK).addObject("task", task);

	}

	@PostMapping("/change-action")
	public String updateTask(@Validated Task task, Errors errors, RedirectAttributes attributes) {
		if (errors.hasErrors()) {
			return EDIT_TASK;
		}
		Task taskEncontrada = taskService.getById(task.getId());
		BeanUtils.copyProperties(task, taskEncontrada);
		taskService.save(taskEncontrada);
		attributes.addFlashAttribute("mensagem", "Atividade atualizada com sucesso!")
					.addFlashAttribute("tasks", taskService.listAll());
		return REDIRECT_LIST;
	}

	@GetMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable Long id, RedirectAttributes attributes) {
		taskService.delete(id);
		attributes.addFlashAttribute("excluido", "Atividade excluida com sucesso!")
				  .addFlashAttribute("tasks", taskService.listAll());
		return listTasks();
	}
}
