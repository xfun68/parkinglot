import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SmartDoorManTest {
    @Test
    public void should_park_car_to_parking_lots_with_more_available_lots() {
        DoorMan smartDoorMan = new DoorMan(new MoreRule());
        ParkingLot parkingLotWithMoreAvailableLot = new ParkingLot(2);
        ParkingLot parkingLotWithLessAvailableLot = new ParkingLot(1);
        smartDoorMan.manage(parkingLotWithMoreAvailableLot);
        smartDoorMan.manage(parkingLotWithLessAvailableLot);

        Car car = new Car();
        Receipt receipt = smartDoorMan.park(car);

        assertThat(parkingLotWithMoreAvailableLot.fetchCar(receipt), is(car));
    }
}
