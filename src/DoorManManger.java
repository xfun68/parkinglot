public class DoorManManger extends DoorMan {

    public DoorManManger(ParkingRule parkingRule) {
        super(parkingRule);
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

}
