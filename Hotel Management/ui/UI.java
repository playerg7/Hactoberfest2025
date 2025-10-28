package ui;

import service.Hotel;
import model.*;
import model.enums.HKStatus;
import model.enums.OrderStatus;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class UI {
    private final Scanner sc = new Scanner(System.in);
    private final Hotel hotel;
    private final DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public UI(Hotel hotel) {
        this.hotel = hotel;
    }

    public void start() {
        println("======================================");
        println(" Welcome to " + hotel.getName() + " (" + hotel.getLocation() + ")");
        println("======================================");
        
        boolean run = true;
        while (run) {
            println("\nMain Menu:");
            println("1. Front Desk");
            println("2. Housekeeping");
            println("3. Restaurant / Room Service");
            println("4. Staff Management");
            println("5. Billing");
            println("6. Admin");
            println("0. Exit");
            
            String choice = prompt("Choose");
            try {
                switch (choice) {
                    case "1": frontDeskMenu(); break;
                    case "2": housekeepingMenu(); break;
                    case "3": restaurantMenu(); break;
                    case "4": staffMenu(); break;
                    case "5": billingMenu(); break;
                    case "6": adminMenu(); break;
                    case "0": run = false; break;
                    default: println("Invalid option"); break;
                }
            } catch (Exception e) {
                println("Error: " + e.getMessage());
            }
        }
        println("Shutting down. Goodbye!");
    }

    // All the menu methods remain the same as in your original code
    // (frontDeskMenu, listRooms, registerGuest, makeReservation, etc.)
    // ... [Include all the UI menu methods from your original code here]
    
    // I've omitted the lengthy UI menu methods for brevity, but they should be copied from your original code
    // The structure and functionality remains exactly the same
}