import ui.UI;
import service.Hotel;
import util.DemoData;

public class Main {
    public static void main(String[] args) {
        Hotel hotel = new Hotel("Cloud-Manifest Hotel", "Mumbai");
        DemoData.seed(hotel);
        UI ui = new UI(hotel);
        ui.start();
    }
}