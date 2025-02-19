package az.devolopia.spring_project_teacher;

import org.springframework.stereotype.Component;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Computer {
    private Integer id;
    private String brand;
    private Double price;
    private String color;
    private RAM ram;

    public Computer(RAM ram) {
        this.id = 1;
        this.brand = "Dell";
        this.price = 1200.0;
        this.color = "Black";
        this.ram = ram;
    }

    @PostConstruct
    public void init() {
        System.out.println("init - Computer bean is initialized.");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("destroy - Computer bean is being destroyed.");
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public RAM getRam() { return ram; }
    public void setRam(RAM ram) { this.ram = ram; }
}
