package com.fruit.web.route;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/fruits")
public class FruitController {
	
	@GetMapping(value = "")
	public String goFruitList() {
		return "fruit/list";
	}

	@GetMapping(value = "/post")
	public String goFruitPost() {
		return "fruit/post";
	}
	
	@GetMapping(value = "/{fruitId}")
	public String goFruitDetail(
			@PathVariable(name = "fruitId") int fruitId,
			Model model) {
		model.addAttribute("fruitId", fruitId);
		return "fruit/detail";
	}

	@GetMapping(value = "/{fruitId}/edit")
	public String goFruitEdit(
			@PathVariable(name = "fruitId") int fruitId,
			Model model) {
		model.addAttribute("fruitId", fruitId);
		return "fruit/edit";
	}

}
