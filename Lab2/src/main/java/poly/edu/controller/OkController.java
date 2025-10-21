package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/ctrl/ok")
public class OkController {

    @GetMapping("/form")
    public String showForm() {
		return "ok";
	}

	@PostMapping
	public String m1(Model model) {
		model.addAttribute("called", "m1");
		return "ok";
	}

    @RequestMapping(method = RequestMethod.GET)
	public String m2(Model model) {
		model.addAttribute("called", "m2");
		return "ok";
	}

	@RequestMapping(method = RequestMethod.POST, params = "x")
	public String m3(Model model) {
		model.addAttribute("called", "m3");
		return "ok";
	}
}


