package service;

import model.*;
import model.enums.HKStatus;
import model.enums.OrderStatus;
import java.time.LocalDate;
import java.util.*;

public class Hotel {
    private final String name;
    private final String location;

    private final List<Room> rooms = new ArrayList<>();
    private final Map<Integer, Guest> guests = new HashMap<>();
    private final Map<Integer, Reservation> reservations = new HashMap<>();
    private final Map<Integer, Staff> staff = new HashMap<>();
    private final Map<Integer, HousekeepingRequest> hkRequests = new HashMap<>();
    private final Map<Integer, Order> orders = new HashMap<>();

    private int nextGuestId = 1;
    private int nextResvId = 1;
    private int nextStaffId = 1;
    private int nextHkId = 1;
    private int nextOrderId = 1;

    public Hotel(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String getName() { return name; }
    public String getLocation() { return location; }

    /* Rooms */
    public void addRoom(Room r) { rooms.add(r); }
    public List<Room> listRooms() { return Collections.unmodifiableList(rooms); }
    public Room findRoom(String num) {
        for (Room r : rooms) {
            if (r.getRoomNumber().equals(num)) return r;
        }
        return null;
    }

    /* Guests */
    public Guest registerGuest(String name, String phone, String email) {
        Guest g = new Guest(nextGuestId++, name, phone, email);
        guests.put(g.getId(), g);
        return g;
    }
    
    public Guest getGuest(int id) { return guests.get(id); }
    public Collection<Guest> listGuests() { return guests.values(); }

    /* Staff */
    public Staff addStaff(String name, String role) {
        Staff s = new Staff(nextStaffId++, name, role);
        staff.put(s.getId(), s);
        return s;
    }
    
    public Collection<Staff> listStaff() { return staff.values(); }

    /* Reservations */
    public Reservation makeReservation(int guestId, String roomNumber, LocalDate checkIn, LocalDate checkOut) {
        Guest g = guests.get(guestId);
        if (g == null) throw new IllegalArgumentException("Guest not found");
        
        Room room = findRoom(roomNumber);
        if (room == null) throw new IllegalArgumentException("Room not found");
        
        if (!validDates(checkIn, checkOut)) throw new IllegalArgumentException("Invalid dates");
        if (!roomAvailable(room, checkIn, checkOut)) throw new IllegalStateException("Room not available");
        
        Reservation r = new Reservation(nextResvId++, g, room, checkIn, checkOut);
        reservations.put(r.getId(), r);
        room.addReservation(r);
        return r;
    }
    
    public boolean cancelReservation(int id) {
        Reservation r = reservations.remove(id);
        if (r == null) return false;
        r.getRoom().removeReservation(r);
        return true;
    }
    
    public Reservation getReservation(int id) { return reservations.get(id); }
    public Collection<Reservation> listReservations() { return reservations.values(); }
    
    public List<Reservation> listReservationsForGuest(int guestId) {
        List<Reservation> out = new ArrayList<>();
        for (Reservation r : reservations.values()) {
            if (r.getGuest().getId() == guestId) out.add(r);
        }
        return out;
    }
    
    public void checkIn(int resId) {
        Reservation r = reservations.get(resId);
        if (r == null) throw new IllegalArgumentException("Reservation not found");
        if (r.isCheckedIn()) throw new IllegalStateException("Already checked-in");
        r.setCheckedIn(true);
        r.getRoom().setOccupied(true);
    }
    
    public void checkOut(int resId) {
        Reservation r = reservations.get(resId);
        if (r == null) throw new IllegalArgumentException("Reservation not found");
        if (!r.isCheckedIn()) throw new IllegalStateException("Cannot check-out before check-in");
        r.setCheckedOut(true);
        r.getRoom().setOccupied(false);
    }
    
    private boolean roomAvailable(Room room, LocalDate in, LocalDate out) {
        for (Reservation r : room.getReservations()) {
            if (r.overlaps(in, out)) return false;
        }
        return true;
    }
    
    private boolean validDates(LocalDate in, LocalDate out) {
        return in != null && out != null && out.isAfter(in);
    }

    /* Extras / Billing */
    public void addExtraToReservation(int resId, String desc, double amount) {
        Reservation r = reservations.get(resId);
        if (r == null) throw new IllegalArgumentException("Reservation not found");
        r.addExtra(new ExtraCharge(desc, amount));
    }
    
    public double computeBill(int resId) {
        Reservation r = reservations.get(resId);
        if (r == null) throw new IllegalArgumentException("Reservation not found");
        
        double sum = r.totalCost();
        // Add related orders (room service) totals that match reservation id
        for (Order o : orders.values()) {
            if (o.getReservationId() == resId && o.getStatus() != OrderStatus.CANCELLED) {
                sum += o.total();
            }
        }
        return sum;
    }

    /* Housekeeping */
    public HousekeepingRequest createHKRequest(String roomNumber, String desc) {
        Room rm = findRoom(roomNumber);
        if (rm == null) throw new IllegalArgumentException("Room not found");
        
        HousekeepingRequest hk = new HousekeepingRequest(nextHkId++, roomNumber, desc);
        hkRequests.put(hk.getId(), hk);
        return hk;
    }
    
    public Collection<HousekeepingRequest> listHKRequests() { return hkRequests.values(); }
    
    public void updateHKStatus(int id, HKStatus status) {
        HousekeepingRequest hk = hkRequests.get(id);
        if (hk == null) throw new IllegalArgumentException("HK not found");
        hk.setStatus(status);
    }

    /* Restaurant / Orders */
    public Order placeOrder(int reservationId, List<OrderItem> items) {
        Order o = new Order(nextOrderId++, reservationId);
        for (OrderItem it : items) o.addItem(it);
        orders.put(o.getId(), o);
        return o;
    }
    
    public Collection<Order> listOrders() { return orders.values(); }
    
    public void updateOrderStatus(int orderId, OrderStatus s) {
        Order o = orders.get(orderId);
        if (o == null) throw new IllegalArgumentException("Order not found");
        o.setStatus(s);
    }

    /* Admin */
    public int totalRooms() { return rooms.size(); }
    public int totalGuests() { return guests.size(); }
    public int totalReservations() { return reservations.size(); }
    public int totalStaff() { return staff.size(); }
    public Collection<Room> getRooms() { return rooms; }
    public Collection<Staff> getStaff() { return staff.values(); }
}