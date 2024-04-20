
public class Bus implements Comparable<Bus> {
    // class variable
    private static int nextID = 1;

    // instance variables / fields
    private final int number;
    private int route;

    public Bus() {
        this.number = nextID++;
        this.route = 0;
    }

    public int getNumber() {
        return this.number;
    }

    public int getRoute() {
        return this.route;
    }

    public void setRoute(int route) {

        this.route = route;
    }

    @Override
    public int compareTo(Bus other) {
        if (this.number < other.number) {
            return -1;
        }
        else if (this.number > other.number) {
            return 1;
        }
        return 0;
    }

    public String toString() {

        return "BUS #" + getNumber() + " traveling ROUTE #" + getRoute();
    }
}