package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import poly.edu.service.CookieService;
import poly.edu.service.ParamService;
import poly.edu.service.SessionService;

@Controller
public class AccountController {
    @Autowired
    CookieService cookieService;
    
    @Autowired
    ParamService paramService;
    
    @Autowired
    SessionService sessionService;

    @GetMapping("/account/login")
    public String login1() {
        return "/account/login";
    }

    @PostMapping("/account/login")
    public String login2(Model model) {
        String un = paramService.getString("username", "");
        String pw = paramService.getString("password", "");
        boolean rm = paramService.getBoolean("remember", false);
        
        if (un.equals("poly") && pw.equals("123")) {
            // Lưu username vào session
            sessionService.set("username", un);
            
            // Xử lý ghi nhớ tài khoản
            if (rm) {
                // Ghi nhớ tài khoản 10 ngày
                cookieService.add("user", un, 10 * 24); // 10 ngày = 240 giờ
            } else {
                // Xóa cookie tài khoản đã ghi nhớ trước đó
                cookieService.remove("user");
            }
            
            model.addAttribute("message", "Đăng nhập thành công!");
            return "redirect:/item/index";
        } else {
            model.addAttribute("message", "Sai thông tin đăng nhập!");
            return "/account/login";
        }
    }
}
