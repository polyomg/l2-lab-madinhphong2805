package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import poly.edu.service.MailService;
import poly.edu.service.MailService.Mail;

@Controller
public class MailController {

	@Autowired
	MailService mailService;

	@GetMapping("/mail/form")
	public String form() {
		return "mail/form";
	}

	@ResponseBody
	@RequestMapping("/mail/send")
	public String send(Model model) {
		mailService.push("receiver@gmail.com", "Subject", "Body");
		return "Mail của bạn đã được xếp vào hàng đợi";
	}

	@PostMapping("/mail/send-direct")
	public String sendDirect(Model model, @RequestParam(required = false, name = "from") String from,
			@RequestParam("to") String to, @RequestParam(required = false) String cc,
			@RequestParam(required = false) String bcc, @RequestParam("subject") String subject,
			@RequestParam("body") String body, @RequestParam(required = false) String filenames) {
		Mail mail = Mail.builder().from(from != null ? from : "WebShop <web-shop@gmail.com>").to(to).cc(cc).bcc(bcc)
				.subject(subject).body(body).filenames(filenames).build();
		mailService.send(mail);
		model.addAttribute("message", "Đã gửi trực tiếp");
		return "mail/form";
	}

	@PostMapping("/mail/send-queue")
	public String sendQueue(Model model, @RequestParam(required = false, name = "from") String from,
			@RequestParam("to") String to, @RequestParam(required = false) String cc,
			@RequestParam(required = false) String bcc, @RequestParam("subject") String subject,
			@RequestParam("body") String body, @RequestParam(required = false) String filenames) {
		Mail mail = Mail.builder().from(from != null ? from : "WebShop <web-shop@gmail.com>").to(to).cc(cc).bcc(bcc)
				.subject(subject).body(body).filenames(filenames).build();
		mailService.push(mail);
		model.addAttribute("message", "Đã xếp hàng đợi");
		return "mail/form";
	}
}


