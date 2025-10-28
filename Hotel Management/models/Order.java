package model;

import model.enums.OrderStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int id;
    private final int reservationId;
    private final List<OrderItem> items = new ArrayList<>();
    private OrderStatus status = OrderStatus.PLACED;
    private final LocalDateTime placedAt = LocalDateTime.now();
    
    public Order(int id, int reservationId) {
        this.id = id;
        this.reservationId = reservationId;
    }
    
    public int getId() { return id; }
    public int getReservationId() { return reservationId; }
    public void addItem(OrderItem it) { items.add(it); }
    public List<OrderItem> getItems() { return items; }
    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus s) { status = s; }
    
    public double total() {
        double s = 0;
        for (OrderItem i : items) s += i.total();
        return s;
    }
    
    @Override
    public String toString() {
        return String.format("Order #%d | Resv:%d | Items:%d | ₹%.2f | %s | %s", 
                id, reservationId, items.size(), total(), status, 
                placedAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}