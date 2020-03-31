package com.fruit.web.fruit;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/fruits")
public class FruiteRestController {
	
	@Autowired
	private FruitDao fruitDao;

	@GetMapping(value = "")
	public ArrayList<Fruit> getFruits() {
		return fruitDao.getFruitList();
	}
	
	@PostMapping(value = "")
	public void postFruit(Fruit fruit) {
		fruitDao.insertFruit(fruit);
	}
	
	@GetMapping(value = "/{fruitId}")
	public Fruit getFruit(
			@PathVariable(value = "fruitId") int fruitId) {
		return fruitDao.getFruitByFruitId(fruitId);
	}

	@PatchMapping(value = "/{fruitId}")
	public void patchFruit(
			@PathVariable(value = "fruitId") int fruitId,
			@RequestBody Fruit fruit) {
		fruit.setFruitId(fruitId);
		fruitDao.updateFruit(fruit);
	}
	
	@DeleteMapping(value = "/{fruitId}")
	public void deleteFruit(
			@PathVariable(value = "fruitId") int fruitId) {
		fruitDao.deleteFruitByFruitId(fruitId);
	}
}
