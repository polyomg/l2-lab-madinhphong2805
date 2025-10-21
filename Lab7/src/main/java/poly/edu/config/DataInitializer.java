package poly.edu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import poly.edu.dao.ProductDAO;
import poly.edu.entity.Product;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    
    @Autowired
    private ProductDAO productDAO;
    
    @Override
    public void run(String... args) throws Exception {
        // Sample data based on the images
        Product[] products = {
            new Product(null, "Aniseed Syrup", 190.0, LocalDate.of(1980, 3, 29), "Nước hoa"),
            new Product(null, "Change", 19.0, LocalDate.of(1982, 12, 18), "Nữ trang"),
            new Product(null, "Aniseed Syrup", 10.0, LocalDate.of(1973, 6, 14), "Nước hoa"),
            new Product(null, "Chef Anton's Cajun Seasoning", 22.0, LocalDate.of(1976, 3, 10), "Nữ trang"),
            new Product(null, "Chef Anton's Gumbo Mix", 21.35, LocalDate.of(1978, 12, 6), "Nữ trang"),
            new Product(null, "Konbu", 6.0, LocalDate.of(2002, 7, 1), "Đồng hồ đeo tay"),
            new Product(null, "Filo Mix", 7.0, LocalDate.of(2001, 5, 20), "Đồng hồ đeo tay"),
            new Product(null, "Tourtiare", 7.45, LocalDate.of(2009, 10, 7), "Đồng hồ đeo tay"),
            new Product(null, "RhanbrAu Klosterbier", 7.75, LocalDate.of(1982, 10, 31), "Đồng hồ đeo tay"),
            new Product(null, "Laptop Pro", 299.99, LocalDate.of(2020, 1, 15), "Máy tính xách tay"),
            new Product(null, "Smartphone X", 199.99, LocalDate.of(2021, 3, 20), "Điện thoại"),
            new Product(null, "Camera DSLR", 399.99, LocalDate.of(2020, 6, 10), "Máy ảnh"),
            new Product(null, "Travel Bag", 49.99, LocalDate.of(2019, 8, 5), "Túi xách du lịch"),
            new Product(null, "Fashion Hat", 29.99, LocalDate.of(2021, 4, 12), "Nón thời trang"),
            new Product(null, "Gold Ring", 89.99, LocalDate.of(2020, 11, 8), "Nữ trang"),
            new Product(null, "Silver Necklace", 79.99, LocalDate.of(2021, 2, 14), "Nữ trang"),
            new Product(null, "Diamond Watch", 599.99, LocalDate.of(2020, 9, 25), "Đồng hồ đeo tay"),
            new Product(null, "Luxury Perfume", 129.99, LocalDate.of(2021, 1, 30), "Nước hoa"),
            new Product(null, "Gaming Laptop", 799.99, LocalDate.of(2021, 5, 18), "Máy tính xách tay"),
            new Product(null, "Professional Camera", 899.99, LocalDate.of(2020, 12, 3), "Máy ảnh"),
            new Product(null, "Premium Phone", 699.99, LocalDate.of(2021, 7, 22), "Điện thoại"),
            new Product(null, "Designer Bag", 199.99, LocalDate.of(2021, 3, 15), "Túi xách du lịch"),
            new Product(null, "Elegant Hat", 39.99, LocalDate.of(2021, 6, 8), "Nón thời trang"),
            new Product(null, "Platinum Ring", 299.99, LocalDate.of(2020, 10, 12), "Nữ trang"),
            new Product(null, "Luxury Watch", 999.99, LocalDate.of(2021, 4, 20), "Đồng hồ đeo tay"),
            new Product(null, "Exclusive Perfume", 199.99, LocalDate.of(2021, 8, 10), "Nước hoa")
        };
        
        for (Product product : products) {
            productDAO.save(product);
        }
    }
}
