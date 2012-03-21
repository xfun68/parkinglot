import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SmarterDoorManTest {
    @Test
    public void should_park_car_to_parking_slot_with_less_available_cars(){
        DoorMan smarterDoorMan = (DoorMan) new DoorMan(new LessRule());

        ParkingLot moreLots = new ParkingLot(2);
        smarterDoorMan.manage(moreLots);
        ParkingLot lessLots = new ParkingLot(1);
        smarterDoorMan.manage(lessLots);

        Car car = new Car();
        Receipt receipt = smarterDoorMan.park(car);
        assertThat(lessLots.fetchCar(receipt), is(car));
    }
}
