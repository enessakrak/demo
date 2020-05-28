package com.demo;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NadzorController {

	@Autowired
    private NadzorService nadzorservice;
	
	 @RequestMapping(value="/nadzor")
	    public String viewHomePage(Model model) {
	        List<Test_nadzor> listNadzor = nadzorservice.listAll();
	        model.addAttribute("listNadzor", listNadzor);
	       
	        return "nadzor";
	    }
	 @RequestMapping(value="/newnadzor")
	    public String showNewNadzorPage(Model model) {
	        Test_nadzor nadzor = new Test_nadzor();
	        model.addAttribute("nadzor", nadzor);
	        model.addAttribute("datum", LocalDate.now());
	        return "new_nadzor";
	    }
	 @RequestMapping(value = "/savenadzor", method = RequestMethod.POST)
	    public String saveNadzor(@ModelAttribute("nadzor") Test_nadzor nadzor) {
		 
	        nadzorservice.save(nadzor);
	         
	        return "redirect:/nadzor";
	    }
	 @RequestMapping(value="/editnadzor/{id}")
	    public ModelAndView showEditNadzorPage(@PathVariable(name = "id") int id) {
	        ModelAndView mav = new ModelAndView("edit_nadzor");
	        Test_nadzor nadzor = nadzorservice.get(id);
	        mav.addObject("nadzor", nadzor);
	         
	        return mav;
	    }
	 @RequestMapping("/deletenadzor/{id}")
	    public String deleteNadzor(@PathVariable(name = "id") int id) {
	        nadzorservice.delete(id);
	        return "redirect:/nadzor";       
	    }
	
}
