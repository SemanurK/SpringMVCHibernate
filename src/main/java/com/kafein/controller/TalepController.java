package com.kafein.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.kafein.model.Talep;
import com.kafein.service.TalepService;

@Controller
@RequestMapping(value = "/talep")
public class TalepController {

<<<<<<< HEAD
	@Autowired
	TalepService talepService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listPersons(Model model) {
		List<Talep> taleplist=this.talepService.listAllTaleps();
		model.addAttribute("taleplist", this.talepService.listAllTaleps());
		return "Talep/index";
	}
=======
    @Autowired
    TalepService talepService;


    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("taleplist", this.talepService.listAllTaleps());
        return "Talep/index";
    }

//	@RequestMapping(value="/index", method=RequestMethod.GET)
//	public ModelAndView list() {
//		ModelAndView model = new ModelAndView("Talep/index");
//		List taleplist = talepservice.listAllTaleps();
//		model.addObject("taleplist", taleplist);
//		return model;
//
//	}
//	 @RequestMapping(value="/duzenle/{id}", method=RequestMethod.GET)
//	 public ModelAndView update(@PathVariable("id") int id){
//	  ModelAndView model = new ModelAndView("Talep/duzenle");
//	  Talep talepbilgi = talepservice.findTalepById(id);
//	  model.addObject("talepbilgi", talepbilgi);
//	  model.addObject("id",id);	  
//	  return model;
//	 }	 
>>>>>>> b3d692042837a8f744073b820f8a9a4f948f08d7

	// @RequestMapping(value="/index", method=RequestMethod.GET)
	// public ModelAndView list() {
	// ModelAndView model = new ModelAndView("Talep/index");
	// List taleplist = talepservice.listAllTaleps();
	// model.addObject("taleplist", taleplist);
	// return model;
	//
	// }
	// @RequestMapping(value="/duzenle/{id}", method=RequestMethod.GET)
	// public ModelAndView update(@PathVariable("id") int id){
	// ModelAndView model = new ModelAndView("Talep/duzenle");
	// Talep talepbilgi = talepservice.findTalepById(id);
	// model.addObject("talepbilgi", talepbilgi);
	// model.addObject("id",id);
	// return model;
	// }

}
