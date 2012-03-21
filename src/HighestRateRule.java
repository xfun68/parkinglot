import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class HighestRateRule implements ParkingRule{
    public ParkingLot getSuitableLots(List<ParkingLot> parkingLots) {
        return Collections.max(parkingLots, new Comparator<ParkingLot>() {
            public int compare(ParkingLot parkingLot, ParkingLot parkingLot1) {
                return (int) ((parkingLot.emptyRate() - parkingLot1.emptyRate()) * 100000);
            }
        });
    }
}
