public interface ParkingFacility {
    Receipt park(Car car);

    Car fetchCar(Receipt receipt);

    String report(int depth);
}
