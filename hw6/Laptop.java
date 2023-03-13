package hw6;

public class Laptop {
    private String brand;
    private String model;
    private int ram;
    private int hdd;
    private String os;
    private String color;
    private double price;

    public Laptop(String brand, String model, int ram, int hdd, String os, String color, double price) {
        this.brand = brand;
        this.model = model;
        this.ram = ram;
        this.hdd = hdd;
        this.os = os;
        this.color = color;
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getOs() {
        return os;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

}
