package dev.jonatansoares.daily.tasks.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dev.jonatansoares.daily.tasks.model.Task;

@Controller
public class IndexController {

	private static final String INDEX_PAGE = "index";

	@RequestMapping("/")
	public ModelAndView home(Task task) {
		ModelAndView mv = new ModelAndView(INDEX_PAGE);
		return mv;
	}
}
