package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class AuthController {

    @Autowired
    private HttpServletRequest request;

    @GetMapping("/login/form")
    public String form() {
        return "form";
    }

    @PostMapping("/login/check")
    public String login(@RequestParam("username") String username, 
                       @RequestParam("password") String password, 
                       Model model) {
        
        // Kiểm tra thông tin đăng nhập
        if ("poly".equals(username) && "123".equals(password)) {
            model.addAttribute("message", "Đăng nhập thành công!");
            model.addAttribute("messageType", "success");
        } else {
            model.addAttribute("message", "Đăng nhập thất bại! Tên đăng nhập hoặc mật khẩu không đúng.");
            model.addAttribute("messageType", "error");
        }
        
        return "form";
    }
}

