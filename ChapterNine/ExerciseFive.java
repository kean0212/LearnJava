class Flight {
    static class Seat {
        String seatNumber;

        Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public String toString() {
            return "Seat " + seatNumber;
        }
    }
}

public class ExerciseFive {
    public static void main(String[] args) {
        Flight.Seat seat = new Flight.Seat("51B"); // either make Seat static or create a Flight object and construct one through it
        System.out.println(seat);
    }
}