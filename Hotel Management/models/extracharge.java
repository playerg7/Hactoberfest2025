package model;

public class ExtraCharge {
    private final String description;
    private final double amount;
    
    public ExtraCharge(String description, double amount) {
        this.description = description;
        this.amount = amount;
    }
    
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    
    @Override
    public String toString() {
        return String.format("%s: ₹%.2f", description, amount);
    }
}