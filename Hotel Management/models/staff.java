package model;

public class Staff {
    private final int id;
    private final String name;
    private final String role;
    
    public Staff(int id, String name, String role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }
    
    public int getId() { return id; }
    public String getName() { return name; }
    public String getRole() { return role; }
    
    @Override
    public String toString() {
        return String.format("Staff #%d: %s (%s)", id, name, role);
    }
}