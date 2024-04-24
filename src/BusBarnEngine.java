import java.sql.SQLOutput;
import java.util.*;
import java.io.*;

public class BusBarnEngine {

    public static void main(String[] args) {
        Random rand = new Random();
        Set<Bus> barn = new TreeSet<>();
        Map<Integer, String> routes = new TreeMap<>();

        addBuses(barn, rand);
        setRoutes(routes, "routes.txt");
        printBarn(barn);

        printBarnRoutes(barn, routes);
    }

    /**
     * Create a random number of buses from 1 - 10 and add them to the set
     * with a random route number in range 100 - 130
     * @param barn set of bus objects
     * @param r random generator object
     */
    public static void addBuses(Set<Bus> barn, Random r) {

        //generate number of buses to add to barn
        int numBuses = r.nextInt(10) + 1; // 1, 2, 3 ... , 10

        for (int i = 1; i <= numBuses; i++) {
            // construct the buses
            Bus b = new Bus();

            // generate a route number between 100 - 130 and setRoute
            b.setRoute(r.nextInt(100, 131));

            // add the bus object to the set
            barn.add(b);
        }

    }

    public static void printBarn(Set<Bus> barn) {
        System.out.println("\nBuses at the Bus Barn");
        System.out.println("=====================");
//        for (Bus b : barn) {
//            System.out.println(b);
//        }
        if (barn.isEmpty()) {
            System.out.println("The bus barn is empty!");
        }
    }

    /**
     * This method reads in route information from a file and populates a route map
     * @param routes map that uses the route number as key and the route description as the value
     * @param fileName name of the file that holds the route number/description
     */
    public static void setRoutes(Map<Integer, String> routes, String fileName) {
        try (Scanner file = new Scanner(new File(fileName))) {
            while (file.hasNextLine()) {
                String number = file.nextLine();
                String desc = file.nextLine();
                routes.put(Integer.parseInt(number), desc);
            }

            System.out.println("Routes = " + routes);

        } catch (FileNotFoundException e) {

            System.err.println(e); // err prints out the error in red

        }

    }

    /**
     * This method prints the bus route as well as a description if it matches with a route
     * from route.txt
     * @param barn set of bus objects
     * @param routes map that uses the route number as key and the route description as the value
     */
    public static void printBarnRoutes(Set<Bus> barn, Map<Integer, String> routes) {
        // Retrieves a Description for Bus Route by matching with the Routes

        for (Bus bus : barn) {
            System.out.print(bus);
            int num = bus.getRoute();
            if (routes.containsKey(num)) {
                System.out.println(" (" + routes.get(num) + ")");
            }
            else {
                System.out.println(" ");
            }
        }

    }

}