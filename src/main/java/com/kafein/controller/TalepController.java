package com.kafein.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.kafein.model.Kullanici;
import com.kafein.model.Talep;

import com.kafein.service.KullaniciService;
import com.kafein.service.TalepService;

@Controller
@RequestMapping(value = "/talep")
public class TalepController {

	@Autowired
	TalepService talepService;
	@Autowired
	KullaniciService kulService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listPersons(Model model) {

		model.addAttribute("taleplist", this.talepService.listAllTaleps());
		return "Talep/index";
	}

	@RequestMapping(value = "/duzenle")
	public String talep_Duzenle(@ModelAttribute("id") int id, ModelMap model) {
		model.addAttribute("talepbilgi", talepService.findTalepById(id));
		model.addAttribute("kullaniciBilgi", kulService.listAllKullanicis());
		model.addAttribute("id", id);
		return "/Talep/duzenle";
	}

	@RequestMapping("/yenitalep")
	public String yenitalep(ModelMap model) {
		model.addAttribute("kullaniciBilgi", kulService.listAllKullanicis());
		model.addAttribute("talepbilgi", new Talep());
		return "/Talep/duzenle";
	}

	@RequestMapping(value = "/guncelle", method = RequestMethod.POST)
	public String duzenle(@ModelAttribute Talep talep, ModelMap model, BindingResult result,
			final RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			System.out.println("/docreatetask in here" + result.getFieldError().getDefaultMessage());
		}

		if (talep.getId() == 0) {
			int sonuc = talepService.ControlTalepId(talep.getTalep_id());
			if (sonuc != 0) {
				redirectAttributes.addFlashAttribute("sonuc", sonuc);
				return "redirect:/talep/yenitalep";
			} else {
				talep.setTalep_sahip(new Kullanici(1, "Bilinmiyor", ""));
				talepService.addTalep(talep);
				redirectAttributes.addFlashAttribute("sonuc", sonuc);
				return "redirect:/talep/index";
			}
		} else {
			talepService.updateTalep(talep);
		}
		model.addAttribute("taleplist", talepService.listAllTaleps());
		return "redirect:/talep/index";
	}

	@RequestMapping("/sil")
	public String silTalep(@ModelAttribute("id") int id) {

		this.talepService.deleteTalep(id);
		return "redirect:/talep/index";
	}

	@RequestMapping(value = "/filtre", method = RequestMethod.GET)
	public String duzenle(@RequestParam(value = "val") String val, @RequestParam(value = "filter") String filter,
			@RequestParam(value = "state") String state, ModelMap model) {
		List<Talep> taleplist=this.talepService.filterTalep(val, filter, state);
		model.addAttribute("taleplist", taleplist);
		
		return "/Talep/table";
	}

	@InitBinder()
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));

	}

}
