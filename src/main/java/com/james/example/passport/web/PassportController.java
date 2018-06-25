package com.james.example.passport.web;

import java.io.IOException;
import java.util.Base64;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.james.example.passport.business.PassportBusinessService;
import com.james.example.passport.model.entity.PassportEntity;

/**
 * 
 * @author James Jayaputera (james.jayaputera@gmail.com)
 *
 */
@Controller
public class PassportController {
	private PassportBusinessService passportService;
	
	@Autowired
	public PassportController(PassportBusinessService passportService) {
		this.passportService = passportService;
	}

	@RequestMapping(value="/", method=RequestMethod.GET)
	public String index(Model model) {
		return "index";
	}

	@RequestMapping(value="/passport/create", method=RequestMethod.GET)
	public String create(Model model) {
		model.addAttribute("passport", new Passport());
		return "create";
	}

	@RequestMapping(method=RequestMethod.POST, value="/passport/create")
	public String createPassport(@RequestParam("file") MultipartFile file, @Valid @ModelAttribute Passport passport,
			                     BindingResult result, Model model) throws IOException {
		if (result.hasErrors()) {
			return "create";
		}

		if (file.getOriginalFilename().isEmpty()) {
			model.addAttribute("message", "Image file is not given.");
			return "create";
		}

		byte[] content = file.getBytes();
		if (content.length == 0) {
			model.addAttribute("message", "Image file size is zero.");
			return "create";
		}

		if (passportService.findByPassportDocNo(passport.getDocNo()) != null) {
			System.out.println("Passport Number " + passport.getDocNo() + " exists in database.");
			model.addAttribute("message", "Passport Number " + passport.getDocNo() + " exists in database.");
			return "create";
		}
		String imgBase64 = Base64.getEncoder().encodeToString(content);
		passport.setImage("data:"+file.getContentType() + ";base64," + imgBase64);
		passport.setImageContentType(file.getContentType());				
		passport.setImageFilename(file.getOriginalFilename());
		this.passportService.create(passport);
		System.out.println("Passport created");
		model.addAttribute("passport", new Passport());
		model.addAttribute("message", "Passport Number " + passport.getDocNo() + " saved.");
		return "create";
	}
	
	@RequestMapping(value="/passport/search", method=RequestMethod.GET)
	public String search(Model model) {
		return "search";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/passport/search")
	public String searchPassport(@RequestParam("keyword") String keyword, @ModelAttribute Passport passport,
			                     BindingResult result, Model model) throws IOException {
		String kw = keyword.trim();
		System.out.println("Searching for passport# " + kw);
		if (kw.isEmpty()) {
			model.addAttribute("errMsg", "Passport number has not been entered.");
			return "search";
		}

		Passport p = passportService.findByPassportDocNo(kw);
		if (p == null) {
			model.addAttribute("errMsg", "Passport number cannot be found.");
		}
		else {
			model.addAttribute("errMsg", "");
			model.addAttribute("passport", p);			
		}

		return "search";
	}
}
