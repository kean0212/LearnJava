import java.util.*;

class AlertStatus {
    public String toString() {
        return "AlertStatus";
    }
}

class Normal extends AlertStatus {
    public String toString() {
        return "Normal";
    }
}

class Malfunction extends AlertStatus {
    public String toString() {
        return "Malfunction";
    }
}

class Abandon extends AlertStatus {
    public String toString() {
        return "Abandon";
    }
}

public class Starship {
    AlertStatus alertStatus = new Normal();

    void statusChange() {
        if (alertStatus instanceof Normal) {
            alertStatus = new Malfunction();
        } else {
            alertStatus = new Abandon();
        }
    }

    public static void main(String[] args) {
        Starship ship = new Starship();
        System.out.println(ship.alertStatus);
        ship.statusChange();
        System.out.println(ship.alertStatus);
        ship.statusChange();
        System.out.println(ship.alertStatus);
    }
}
