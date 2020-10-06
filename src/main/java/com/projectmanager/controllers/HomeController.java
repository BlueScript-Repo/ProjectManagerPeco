package com.projectmanager.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.projectmanager.util.HTMLElements;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.mvc.AbstractController;

import com.projectmanager.dao.BOQDetailsDao;
import com.projectmanager.dao.ProjectDao;
import com.projectmanager.entity.Project;

import java.util.ArrayList;

@Controller
@EnableWebMvc
public class HomeController extends AbstractController {

	@Autowired
	BOQDetailsDao boqDetailsDao;

	@Autowired
	ProjectDao projectDao;

	final static String VIEW = "Home";
	final static String NEW_HOME = "newHome";

	@Override
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		ModelAndView modelAndView = new ModelAndView(NEW_HOME);
		ArrayList<String> projectIdVal = new ArrayList<>();

		projectIdVal = boqDetailsDao.getRecentProject();

		int sizeToIterate = projectIdVal.size()>5?5:projectIdVal.size();

		StringBuilder StringToSend = new StringBuilder();

		for(int k=0; k<sizeToIterate; k++)
		{
			String template = HTMLElements.CURRENT_PROJECTS;

			Project project = projectDao.getProject(Integer.parseInt(projectIdVal.get(k)));

			template = template.replaceAll("projectNameVal",project.getProjectName());
			template = template.replaceAll("projectIdVal", String.valueOf(project.getProjectId()));
			template = template.replaceAll("projectDescVal",project.getProjectDesc());

			StringToSend.append(template);
		}

		int proId = projectDao.getProjectId();
		

		modelAndView.addObject("projectId", proId);

		modelAndView.addObject("projectList", StringToSend.toString());
		

		return modelAndView;
	}
}