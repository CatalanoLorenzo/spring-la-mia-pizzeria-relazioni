package org.java.app.controller;

import java.util.List;

import org.java.app.db.pojo.Pizza;
import org.java.app.db.pojo.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {

	@Autowired
	private PizzaService pizzaService;

	@GetMapping
	public String getIndex(Model model, @RequestParam(required = false) String nome) {

		List<Pizza> pizzas = nome == null ? pizzaService.findAll() : pizzaService.findByName(nome);

		model.addAttribute("pizzas", pizzas);
		System.out.println("pizza: " + pizzas);

		return "pizza-index";
	}

	@GetMapping("/{id}")
	public String getShow(@PathVariable int id, Model model) {

		Pizza pizza = pizzaService.findById(id);
		model.addAttribute("pizza", pizza);

		return "pizza-show";
	}
}