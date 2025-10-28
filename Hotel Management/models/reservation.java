package model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Reservation {
    private final int id;
    private final Guest guest;
    private final Room room;
    private final LocalDate checkIn;
    private final LocalDate checkOut;
    private boolean checkedIn = false;
    private boolean checkedOut = false;
    private final List<ExtraCharge> extras = new ArrayList<>();

    public Reservation(int id, Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
        this.id = id;
        this.guest = guest;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    // Getters and setters
    public int getId() { return id; }
    public Guest getGuest() { return guest; }
    public Room getRoom() { return room; }
    public LocalDate getCheckIn() { return checkIn; }
    public LocalDate getCheckOut() { return checkOut; }
    public boolean isCheckedIn() { return checkedIn; }
    public boolean isCheckedOut() { return checkedOut; }
    public void setCheckedIn(boolean v) { checkedIn = v; }
    public void setCheckedOut(boolean v) { checkedOut = v; }
    public List<ExtraCharge> getExtras() { return extras; }
    public void addExtra(ExtraCharge e) { extras.add(e); }

    public boolean overlaps(LocalDate a, LocalDate b) {
        return (checkIn.isBefore(b) && a.isBefore(checkOut));
    }

    public long nights() {
        return ChronoUnit.DAYS.between(checkIn, checkOut);
    }

    public double roomCost() {
        return nights() * room.getPricePerNight();
    }

    public double totalCost() {
        double sum = roomCost();
        for (ExtraCharge e : extras) sum += e.getAmount();
        return sum;
    }

    @Override
    public String toString() {
        java.time.format.DateTimeFormatter f = java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return String.format("Resv #%d | Guest: %s | Room: %s | %s -> %s | Nights: %d | ₹%.2f %s%s",
                id, guest.getName(), room.getRoomNumber(),
                checkIn.format(f), checkOut.format(f), nights(), totalCost(),
                checkedIn ? "[Checked-In]" : "", checkedOut ? "[Checked-Out]" : "");
    }
}