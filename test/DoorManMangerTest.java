import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DoorManMangerTest {

    private DoorManManger doorManManger;

    @Before
    public void setUp() throws Exception {
        doorManManger = new DoorManManger(new NormalRule());
    }

    @Test
    public void should_pass_car_to_boy_to_park_when_boy_has_available_parking_lot(){
        DoorMan doorMan1 = new DoorMan(new NormalRule());
        doorMan1.manage(new ParkingLot(3));
        DoorMan doorMan2 = new DoorMan(new LessRule());
        doorMan2.manage(new ParkingLot(1));

        doorManManger.manage(doorMan1);
        doorManManger.manage(doorMan2);

        Car car = new Car();
        Receipt receipt = doorManManger.park(car);

        assertThat(doorMan1.fetchCar(receipt), is(car));
    }

    @Test
    public void should_pass_car_to_own_park_when_boy_has_not_available_parking_lot(){
        DoorMan doorMan1 = new DoorMan(new NormalRule());
        doorMan1.manage(new ParkingLot(0));
        DoorMan doorMan2 = new DoorMan(new LessRule());
        doorMan2.manage(new ParkingLot(0));

        doorManManger.manage(doorMan1);
        doorManManger.manage(doorMan2);

        ParkingLot parkingLot = new ParkingLot(1);
        doorManManger.manage(parkingLot);

        Car car = new Car();
        Receipt receipt = doorManManger.park(car);

        assertThat(doorManManger.fetchCar(receipt), is(car));
    }

    @Test
    public void should_fetch_car(){
        DoorMan doorMan1 = new DoorMan(new NormalRule());
        doorMan1.manage(new ParkingLot(3));
        DoorMan doorMan2 = new DoorMan(new LessRule());
        doorMan2.manage(new ParkingLot(1));

        doorManManger.manage(doorMan1);
        doorManManger.manage(doorMan2);

        Car car = new Car();
        Receipt receipt = doorManManger.park(car);

        assertThat(doorManManger.fetchCar(receipt), is(car));
    }

}
