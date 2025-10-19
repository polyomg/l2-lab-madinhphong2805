package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import poly.edu.dao.ProductDAO;
import poly.edu.entity.Product;
import poly.edu.service.SessionService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    
    @Autowired
    ProductDAO dao;
    
    @Autowired
    SessionService session;
    
    // Exercise 1: Search by price range
    @RequestMapping("/product/search")
    public String search(Model model,
                        @RequestParam("min") Optional<Double> min,
                        @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = dao.findByPrice(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search";
    }
    
    // Exercise 2: Search with pagination
    @RequestMapping("/product/search-and-page")
    public String searchAndPage(Model model,
                               @RequestParam("keywords") Optional<String> kw,
                               @RequestParam("p") Optional<Integer> p) {
        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findByKeywords("%" + kwords + "%", pageable);
        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);
        return "product/search-and-page";
    }
    
    // Exercise 4: Search by price range using DSL
    @RequestMapping("/product/search-dsl")
    public String searchDSL(Model model,
                           @RequestParam("min") Optional<Double> min,
                           @RequestParam("max") Optional<Double> max) {
        double minPrice = min.orElse(Double.MIN_VALUE);
        double maxPrice = max.orElse(Double.MAX_VALUE);
        List<Product> items = dao.findByPriceBetween(minPrice, maxPrice);
        model.addAttribute("items", items);
        return "product/search";
    }
    
    // Exercise 5: Search with pagination using DSL
    @RequestMapping("/product/search-and-page-dsl")
    public String searchAndPageDSL(Model model,
                                  @RequestParam("keywords") Optional<String> kw,
                                  @RequestParam("p") Optional<Integer> p) {
        String kwords = kw.orElse(session.get("keywords", ""));
        session.set("keywords", kwords);
        Pageable pageable = PageRequest.of(p.orElse(0), 5);
        Page<Product> page = dao.findAllByNameLike("%" + kwords + "%", pageable);
        model.addAttribute("page", page);
        model.addAttribute("keywords", kwords);
        return "product/search-and-page";
    }
}
