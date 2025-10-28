package model;

import model.enums.RoomType;
import java.util.*;

public class Room {
    private final String roomNumber;
    private final RoomType type;
    private double pricePerNight;
    private boolean occupied = false;
    private final List<Reservation> reservations = new ArrayList<>();

    public Room(String roomNumber, RoomType type, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.type = type;
        this.pricePerNight = pricePerNight;
    }

    // Getters and setters
    public String getRoomNumber() { return roomNumber; }
    public RoomType getType() { return type; }
    public double getPricePerNight() { return pricePerNight; }
    public void setPricePerNight(double p) { pricePerNight = p; }
    public boolean isOccupied() { return occupied; }
    public void setOccupied(boolean v) { occupied = v; }
    public List<Reservation> getReservations() { return reservations; }
    public void addReservation(Reservation r) { reservations.add(r); }
    public void removeReservation(Reservation r) { reservations.remove(r); }

    @Override
    public String toString() {
        return String.format("Room %s (%s) - ₹%.2f/night %s", roomNumber, type, pricePerNight, occupied ? "[OCCUPIED]" : "");
    }
}