package ship;

public class Ship {

    private String shipName;
    private int numberOfContainers;
    private float waterCapacity;

    private float cruisingSpeed;
    private int numberOfCrew;
    private float boardHight;
    private float swimingRange;
    private boolean inVoyage;

    static private int numberOfTransportation;

    protected int numberOfCabin;
    protected int tonnage;

    public void SetValues(String shipName, int numberOfContainers, float waterCapacity, float cruisingSpeed,
            int numberOfCrew, float boardHight, float swimingRange, boolean inVoyage, int numberOfCabin, int tonnage) {
        this.setShipName(shipName);
        this.setNumberOfContainers(numberOfContainers);
        this.setWaterCapacity(waterCapacity);
        this.setCruisingSpeed(cruisingSpeed);
        this.setNumberOfCrew(numberOfCrew);
        this.setBoardHight(boardHight);
        this.setSwimingRange(swimingRange);
        this.setInVoyage(inVoyage);
        this.setNumberOfCabin(numberOfCabin);
        this.setTonnage(tonnage);
    }

    public Ship(String shipName, int numberOfContainers, float waterCapacity, float cruisingSpeed, int numberOfCrew,
            float boardHight, float swimingRange, boolean inVoyage, int numberOfCabin, int tonnage) {
        this.SetValues(shipName, numberOfContainers, waterCapacity, cruisingSpeed, numberOfCrew, boardHight,
                swimingRange, inVoyage, numberOfCabin, tonnage);
        numberOfTransportation++;
    }

    public Ship(String shipName, int numberOfContainers, float waterCapacity, float cruisingSpeed) {
        this(shipName, numberOfContainers, waterCapacity, cruisingSpeed, 150, 5, 2300, true, 40, 3000);
    }

    public Ship() {
        this("Carolina", 220, 150, 30);
    }

    @Override
    public String toString() {
        return  "Ship name: " + this.getShipName() + "\n" +
                "Number of container: " + this.getNumberOfContainers() + "\n" +
                "Water capacity: " + this.getWaterCapacity() + "\n" +
                "Cruising speed: " + this.getCruisingSpeed() + "\n" +
                "Number of crew: " + this.getNumberOfCrew() + "\n" +
                "Board hight: " + this.getBoardHight() + "\n" +
                "Swiming range: " + this.getSwimingRange() + "\n" +
                "In voyage: " + this.getInVoyage() + "\n" +
                "Number of cabin: " + this.getNumberOfCabin() + "\n" +
                "Tonnage: " + this.getTonnage() + "\n";
    }

    public static void printStaticNumberOfTransportation() {
        System.out.println("Number of transportation: " + getNumberOfTransportation());
    }

    public void printNumberOfTransportation() {
        System.out.println("Number of transportation: " + getNumberOfTransportation());
    }    

    public void resetValues (String shipName, int numberOfContainers, float waterCapacity, float cruisingSpeed,
    int numberOfCrew, float boardHight, float swimingRange, boolean inVoyage, int numberOfCabin, int tonnage) {
        this.SetValues(shipName, numberOfContainers, waterCapacity, cruisingSpeed, numberOfCrew, boardHight, swimingRange, inVoyage, numberOfCabin, tonnage);
    }

    public String getShipName() {
        return shipName;
    }

    public void setShipName(String shipName) {
        this.shipName = shipName;
    }

    public int getNumberOfContainers() {
        return numberOfContainers;
    }

    public void setNumberOfContainers(int numberOfContainers) {
        this.numberOfContainers = numberOfContainers;
    }

    public float getWaterCapacity() {
        return waterCapacity;
    }

    public void setWaterCapacity(float waterCapacity) {
        this.waterCapacity = waterCapacity;
    }

    public float getCruisingSpeed() {
        return cruisingSpeed;
    }

    public void setCruisingSpeed(float cruisingSpeed) {
        this.cruisingSpeed = cruisingSpeed;
    }

    public int getNumberOfCrew() {
        return numberOfCrew;
    }

    public void setNumberOfCrew(int numberOfCrew) {
        this.numberOfCrew = numberOfCrew;
    }

    public float getBoardHight() {
        return boardHight;
    }

    public void setBoardHight(float boardHight) {
        this.boardHight = boardHight;
    }

    public float getSwimingRange() {
        return swimingRange;
    }

    public void setSwimingRange(float swimingRange) {
        this.swimingRange = swimingRange;
    }

    public boolean getInVoyage() {
        return inVoyage;
    }

    public void setInVoyage(boolean inVoyage) {
        this.inVoyage = inVoyage;
    }

    public static int getNumberOfTransportation() {
        return numberOfTransportation;
    }

    public static void resetNumberOfTransportation() {
        Ship.numberOfTransportation = 0;
    }

    public int getNumberOfCabin() {
        return numberOfCabin;
    }

    public void setNumberOfCabin(int numberOfCabin) {
        this.numberOfCabin = numberOfCabin;
    }

    public int getTonnage() {
        return tonnage;
    }

    public void setTonnage(int tonnage) {
        this.tonnage = tonnage;
    }
}