import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class EmptyRateRuleTest {
    @Test
    public void should_park_to_highest_empty_rate_parking_lots() {
        HighestRateRule highestRateRule = new HighestRateRule();
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

        ParkingLot parkingLot1 = new ParkingLot(5);
        parkingLot1.park(new Car());

        ParkingLot parkingLot2 = new ParkingLot(4);
        parkingLot2.park(new Car());

        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        ParkingLot suitableLots = highestRateRule.getSuitableLots(parkingLots);
        assertThat(suitableLots, notNullValue());
        assertThat(suitableLots, is(parkingLot1));
    }

    @Test
    public void should_return_null_given_can_not_find_parking_lot() {
        HighestRateRule highestRateRule = new HighestRateRule();
        List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();

        ParkingLot parkingLot1 = new ParkingLot(1);
        parkingLot1.park(new Car());

        ParkingLot parkingLot2 = new ParkingLot(2);
        parkingLot2.park(new Car());

        parkingLots.add(parkingLot1);
        parkingLots.add(parkingLot2);

        ParkingLot suitableLots = highestRateRule.getSuitableLots(parkingLots);
        assertThat(suitableLots, notNullValue());
        assertThat(suitableLots, is(parkingLot2));
    }
}
