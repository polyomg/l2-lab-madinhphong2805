package poly.edu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import poly.edu.model.Product;

@Controller
@SessionAttributes({"items"})
public class ProductController {

	private List<Product> items = new ArrayList<>(Arrays.asList(
		new Product("A", 1.0), 
		new Product("B", 12.0), 
		new Product("C", 0.0), 
		new Product("D", 0.0)
	));

	@ModelAttribute("p1")
	public Product defaultProduct() {
		return new Product("iPhone 30", 5000.0);
	}

	@GetMapping("/product/form")
	public String form(Model model) {
		// p1 is provided by @ModelAttribute above
		return "product/form";
	}

	@PostMapping("/product/save")
	public String save(@ModelAttribute("p2") Product p) {
		return "product/form";
	}

	@PostMapping("/product/saveC")
	public String saveC(@ModelAttribute("p3") Product p) {
		// Update C in items list
		for (int i = 0; i < items.size(); i++) {
			if ("C".equals(items.get(i).getName())) {
				items.set(i, new Product(p.getName(), p.getPrice()));
				break;
			}
		}
		return "product/form";
	}

	@PostMapping("/product/saveD")
	public String saveD(@ModelAttribute("p4") Product p) {
		// Update D in items list
		for (int i = 0; i < items.size(); i++) {
			if ("D".equals(items.get(i).getName())) {
				items.set(i, new Product(p.getName(), p.getPrice()));
				break;
			}
		}
		return "product/form";
	}

	@ModelAttribute("items")
	public List<Product> getItems() {
		return items;
	}

	@ModelAttribute("p3")
	public Product productC() {
		return new Product("C", 0.0);
	}

	@ModelAttribute("p4")
	public Product productD() {
		return new Product("D", 0.0);
	}
}


