package util;

import service.Hotel;
import model.*;
import model.enums.RoomType;
import java.time.LocalDate;

public class DemoData {
    public static void seed(Hotel hotel) {
        // Only seed if empty to avoid duplicates
        if (hotel.totalRooms() > 0) return;

        hotel.addRoom(new Room("101", RoomType.SINGLE, 1500));
        hotel.addRoom(new Room("102", RoomType.SINGLE, 1500));
        hotel.addRoom(new Room("201", RoomType.DOUBLE, 2500));
        hotel.addRoom(new Room("202", RoomType.DOUBLE, 2500));
        hotel.addRoom(new Room("301", RoomType.DELUXE, 4000));
        hotel.addRoom(new Room("401", RoomType.SUITE, 8000));

        Guest g1 = hotel.registerGuest("gp", "+91-90000-00000", "gp@example.com");
        Guest g2 = hotel.registerGuest("Aisha", "+91-91234-56789", "aisha@example.com");

        try {
            hotel.makeReservation(g1.getId(), "201", LocalDate.now().plusDays(1), LocalDate.now().plusDays(4));
            hotel.makeReservation(g2.getId(), "301", LocalDate.now().plusDays(2), LocalDate.now().plusDays(3));
        } catch (Exception ignored) {}
        
        hotel.addStaff("Ravi", "Housekeeping");
        hotel.addStaff("Priya", "Chef");
    }
}