import java.util.ArrayList;
import java.util.List;

public class DoorMan implements ParkingFacility {
    protected List<ParkingFacility> parking_facilities;
    protected SuperParkingRule parkingRule;

    public DoorMan(ParkingRule parkingRule) {
        this(new SuperRuleAdapter(parkingRule));
    }


    public DoorMan(SuperParkingRule superRule) {
        this.parkingRule = superRule;
        this.parking_facilities = new ArrayList<ParkingFacility>();
    }


    public static class SuperRuleAdapter implements SuperParkingRule {
        private ParkingRule rule;

        public SuperRuleAdapter(ParkingRule rule) {
            this.rule = rule;
        }

        public ParkingLot getSuitableLots(List<ParkingFacility> input) {
            return rule.getSuitableLots(getParkingLots(input));
        }
    }

    public Receipt park(Car car) {
        ParkingLot suitableLots = parkingRule.getSuitableLots(parking_facilities);
        return suitableLots.park(car);
    }

    private static List<ParkingLot> getParkingLots(List<ParkingFacility> parkingLots) {
        List<ParkingLot> result = new ArrayList<ParkingLot>();
        for (ParkingFacility facility : parkingLots) {
            if (facility instanceof ParkingLot)
                result.add((ParkingLot) facility);
        }
        return result;
    }

    public Car fetchCar(Receipt receipt) {
        for (ParkingFacility lot : parking_facilities) {
            Car car = lot.fetchCar(receipt);
            if (car != null)
                return car;
        }
        return null;
    }

    public void manage(ParkingFacility parking_facilities) {
        this.parking_facilities.add(parking_facilities);
    }
}
