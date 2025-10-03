package poly.edu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RectangleController {

    @GetMapping("/rectangle/form")
    public String form() {
        return "rectangle";
    }

    @PostMapping("/rectangle/calculate")
    public String calculate(@RequestParam("width") double width,
                           @RequestParam("length") double length,
                           Model model) {
        
        // Kiểm tra giá trị hợp lệ
        if (width <= 0 || length <= 0) {
            model.addAttribute("error", "Chiều rộng và chiều dài phải lớn hơn 0!");
            return "rectangle";
        }
        
        // Tính diện tích và chu vi
        double area = width * length;
        double perimeter = 2 * (width + length);
        
        // Làm tròn đến 2 chữ số thập phân
        area = Math.round(area * 100.0) / 100.0;
        perimeter = Math.round(perimeter * 100.0) / 100.0;
        
        // Truyền dữ liệu về view
        model.addAttribute("width", width);
        model.addAttribute("length", length);
        model.addAttribute("area", area);
        model.addAttribute("perimeter", perimeter);
        model.addAttribute("result", true);
        
        return "rectangle";
    }
}
