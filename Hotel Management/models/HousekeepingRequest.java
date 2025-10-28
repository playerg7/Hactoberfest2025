package model;

import model.enums.HKStatus;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HousekeepingRequest {
    private final int id;
    private final String roomNumber;
    private final String description;
    private HKStatus status;
    private final LocalDateTime createdAt;
    
    public HousekeepingRequest(int id, String roomNumber, String description) {
        this.id = id;
        this.roomNumber = roomNumber;
        this.description = description;
        this.status = HKStatus.PENDING;
        this.createdAt = LocalDateTime.now();
    }
    
    public int getId() { return id; }
    public String getRoomNumber() { return roomNumber; }
    public String getDescription() { return description; }
    public HKStatus getStatus() { return status; }
    public void setStatus(HKStatus s) { status = s; }
    
    @Override
    public String toString() {
        return String.format("HK #%d | Room %s | %s | %s | %s", id, roomNumber, description, status, 
                createdAt.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
    }
}