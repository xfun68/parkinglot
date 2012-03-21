import java.util.List;

public class MoreRule implements ParkingRule{
    public ParkingLot getSuitableLots(List<ParkingLot> parkingLots) {
        ParkingLot lots = parkingLots.get(0);
        for (ParkingLot parkingLot : parkingLots) {
            if (lots.availableSize() < parkingLot.availableSize()) {
                lots = parkingLot;
            }
        }
        return lots;
    }
}
