package ship;

public class App {
    public static void main(String[] args) {
    Ship firstShip = new Ship();
    Ship secondShip = new Ship("Titanik", 5, 48, 23);
    Ship thirdShip = new Ship("Symphony of the Seas", 0, 230, 59, 5400, 10, 4000, false, 100, 40000);
     
    System.out.println("First ship" + "\n" + firstShip);
    System.out.println("Second ship" + "\n" + secondShip);
    System.out.println("Third ship" + "\n" + thirdShip);
    
    Ship.printStaticNumberOfTransportation();
    thirdShip.printNumberOfTransportation();   
    }
}
