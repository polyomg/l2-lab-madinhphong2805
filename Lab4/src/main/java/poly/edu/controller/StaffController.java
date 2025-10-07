package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import poly.edu.model.Staff;

@Controller
public class StaffController {
	
	@RequestMapping("/staff/create/form")
	public String createForm(Model model, @ModelAttribute("staff") Staff staff) {
		model.addAttribute("message", "Vui lòng nhập thông tin nhân viên!");
		return "/demo/staff-create";
	}
	
	@RequestMapping("/staff/create/save")
	public String createSave(Model model, 
			@RequestPart(value = "photo_file", required = false) MultipartFile photoFile,
			@ModelAttribute("staff") Staff staff) {
		
		// Gán tên file upload cho thuộc tính photo của bean nếu có upload file
		if(photoFile != null && !photoFile.isEmpty()) {
			staff.setPhoto(photoFile.getOriginalFilename());
		}
		
		model.addAttribute("message", "Xin chào " + staff.getFullname() + "! Dữ liệu đã được lưu thành công.");
		
		return "/demo/staff-validate";
	}
}