import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

public class DoorManTest {
    @Test
    public void should_park_car_to_parking_lot_when_there_is_lot() {
        ParkingLot parkingLot = new ParkingLot(2);
        DoorMan doorMan = new DoorMan(new NormalRule());
        Car car = new Car();
        doorMan.manage(parkingLot);

        Receipt receipt = doorMan.park(car);

        assertThat(receipt, notNullValue());
    }

    @Test
    public void should_park_cars_to_different_parking_lot_when_1_parking_lot_is_not_enough() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(1);
        Car car1 = new Car();
        Car car2 = new Car();

        DoorMan doorMan = new DoorMan(new NormalRule());
        doorMan.manage(parkingLot1);
        doorMan.manage(parkingLot2);

        assertThat(doorMan.park(car1), notNullValue());
        assertThat(doorMan.park(car2), notNullValue());
    }

    @Test
    public void should_fetch_cars_by_receipt_when_there_are_more_than_1_parking_lot() {
        ParkingLot parkingLot1 = new ParkingLot(1);
        ParkingLot parkingLot2 = new ParkingLot(2);
        Car car1 = new Car();
        Car car2 = new Car();

        DoorMan doorMan = new DoorMan(new NormalRule());
        doorMan.manage(parkingLot1);
        doorMan.manage(parkingLot2);

        Receipt receipt1 = doorMan.park(car1);
        assertThat(receipt1, notNullValue());
        Receipt receipt2 = doorMan.park(car2);
        assertThat(receipt2, notNullValue());

        assertThat(doorMan.fetchCar(receipt1), is(car1));
        assertThat(doorMan.fetchCar(receipt2), is(car2));
    }
}
