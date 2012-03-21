import org.junit.Test;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ParkingLotTest {

    public static final int DEFAULT_CAPACITY = 2;

    @Test
    public void should_park_car_successfully_when_there_are_enough_capacity() {
        ParkingLot parkingLot = new ParkingLot(DEFAULT_CAPACITY);
        Car car = new Car();

        Receipt receipt = parkingLot.park(car);

        assertThat(receipt, notNullValue());

        assertThat(parkingLot.allCars().size(), is(1));
        assertThat(parkingLot.allCars().get(receipt), is(car));
    }

    @Test
    public void should_park_car_failed_when_there_no_enough_capacity() {
        ParkingLot parkingLot = new ParkingLot(0);
        Car car = new Car();

        Receipt receipt = parkingLot.park(car);

        assertThat(receipt, nullValue());
        assertThat(parkingLot.allCars().isEmpty(), is(true));
    }

    @Test
    public void should_fetch_car_by_receipt_after_parked_car() {
        ParkingLot parkingLot = new ParkingLot(DEFAULT_CAPACITY);
        Car car = new Car();

        Receipt receipt = parkingLot.park(car);

        assertThat(parkingLot.fetchCar(receipt), is(car));
        assertThat(parkingLot.allCars().size(), is(0));
    }

    @Test
    public void should_not_fetch_car_by_wrong_receipt_after_parked_car() {
        ParkingLot parkingLot = new ParkingLot(DEFAULT_CAPACITY);
        Car car = new Car();

        parkingLot.park(car);

        assertThat(parkingLot.fetchCar(new Receipt()), nullValue());
        assertThat(parkingLot.allCars().size(), is(1));
    }
}
