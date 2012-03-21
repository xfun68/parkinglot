import java.util.List;

public class DoorManManger implements ParkingFacility {

    protected List<ParkingFacility> parking_facilities;

    public void manage(ParkingFacility parking_facilities) {
        this.parking_facilities.add(parking_facilities);
    }

    public Receipt park(Car car) {
        for (ParkingFacility facility : parking_facilities) {
            Receipt receipt = facility.park(car);
            if(null != receipt) {
                return receipt;
            }
        }
        return null;
    }

    public Car fetchCar(Receipt receipt) {
        for (ParkingFacility lot : parking_facilities) {
            Car car = lot.fetchCar(receipt);
            if (car != null)
                return car;
        }
        return null;
    }

    public String report(Report report) {
        return report.reportManager(parking_facilities, "Manager:\n");
    }

}
