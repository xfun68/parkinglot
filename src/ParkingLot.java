import java.util.HashMap;
import java.util.Map;

public class ParkingLot implements ParkingFacility {
    private int capacity;
    private Map<Receipt, Car> parkedCars;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        parkedCars = new HashMap<Receipt, Car>();
    }

    public Receipt park(Car car) {
        if (capacity - parkedCars.size() > 0) {
            Receipt receipt = new Receipt();
            parkedCars.put(receipt, car);
            return receipt;
        }
        return null;
    }

    public Map<Receipt, Car> allCars() {
        return parkedCars;
    }

    public Car fetchCar(Receipt receipt) {
        return parkedCars.remove(receipt);
    }

    public int availableSize() {
        return capacity - parkedCars.size();
    }

    public double emptyRate() {
        return (double) availableSize() / capacity;
    }
}
