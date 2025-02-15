package az.devolopia.spring_project_teacher;

import org.springframework.stereotype.Component;

@Component
public class Computer {
    private Integer id;
    private String brand;
    private Double price;
    private String color;

    public Computer() {
        this.id = 1;
        this.brand = "Dell";
        this.price = 1200.0;
        this.color = "Black";
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }

    public void printComputerDetails() {
        System.out.println("Computer Details:");
        System.out.println("ID: " + id);
        System.out.println("Brand: " + brand);
        System.out.println("Price: $" + price);
        System.out.println("Color: " + color);
    }
}
