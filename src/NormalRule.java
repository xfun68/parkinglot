import java.util.List;

public class NormalRule implements ParkingRule{
    public ParkingLot getSuitableLots(List<ParkingLot> parkingLots) {
        ParkingLot temp = parkingLots.get(0);
        for (ParkingLot lot : parkingLots) {
            if (lot.availableSize() > 0)
                temp = lot;
        }
        return temp;
    }
}
