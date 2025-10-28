package model;

public class OrderItem {
    private String name;
    private int qty;
    private double price;
    
    public OrderItem(String name, int qty, double price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
    
    public double total() { return qty * price; }
    
    public String getName() { return name; }
    public int getQty() { return qty; }
    public double getPrice() { return price; }
    
    @Override
    public String toString() {
        return String.format("%s x%d ₹%.2f", name, qty, total());
    }
}