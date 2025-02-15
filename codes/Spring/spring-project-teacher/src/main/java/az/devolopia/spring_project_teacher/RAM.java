package az.devolopia.spring_project_teacher;

public class RAM {
    private Integer size;
    private String type;
    private Integer speed;

    public RAM(Integer size, String type, Integer speed) {
        this.size = size;
        this.type = type;
        this.speed = speed;
    }

    public Integer getSize() { return size; }
    public void setSize(Integer size) { this.size = size; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public Integer getSpeed() { return speed; }
    public void setSpeed(Integer speed) { this.speed = speed; }

    public void printRAMDetails() {
        System.out.println("RAM Details:");
        System.out.println("Size: " + size + "GB");
        System.out.println("Type: " + type);
        System.out.println("Speed: " + speed + "MHz");
    }
}
