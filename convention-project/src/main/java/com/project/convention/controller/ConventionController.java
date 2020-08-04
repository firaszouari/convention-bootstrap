package com.project.convention.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.project.convention.model.Convention;
import com.project.convention.service.IConventionService;

@Controller
public class ConventionController {
	
	@Autowired
	IConventionService conventionService;
	
	@RequestMapping(value="/convention")
	public ModelAndView listConventions(ModelAndView model) throws IOException{
		List<Convention> listConvention = conventionService.getAllConvention();
		if(listConvention.size()>0)
			model.addObject("listConventions",listConvention);
		model.setViewName("convention");
		return model;
	}
	
	@RequestMapping(value="/editconvention/{id}")
	public ModelAndView editConvention(ModelAndView model, @PathVariable(value="id") int id) throws IOException{
		Convention convention = conventionService.getConventionById(id);
		if(convention != null)
			model.addObject("modifiedConvention",convention);
		else
			model.addObject("modifiedConvention",new Convention());
		model.setViewName("conventionForm");
		return model;
	}
	
	@GetMapping(value="/deleteconvention/{id}")
	public String deleteConvention(ModelAndView model, @PathVariable(value="id") int id) throws IOException{
		conventionService.supprimerConvention(id);
		return "redirect:/convention";
	}
	
	@PostMapping(value="/addconvention")
	public String saveConvention(@ModelAttribute(name="modifiedConvention") Convention convention) throws IOException{
		if(convention != null)
			conventionService.mettreAJourConvention(convention);
		else
			conventionService.ajouterConvention(convention);
		
		return "redirect:/convention";
	}
	
    @InitBinder
    public void initBinder(HttpServletRequest request, ServletRequestDataBinder binder)
    {
    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, null,  new CustomDateEditor(dateFormat, true));
    }
}
