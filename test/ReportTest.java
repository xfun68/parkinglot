import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ReportTest {

    @Test
    public void should_return_correct_give_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(10);
        assertThat(parkingLot.report(0), is("ParkingLot: 10/10\n"));
    }

    @Test
    public void should_return_correct_give_DoorMan_with_a_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(10);
        DoorMan doorMan = new DoorMan(new NormalRule());
        doorMan.manage(parkingLot);
        assertThat(doorMan.report(0), is("DoorMan:\n  ParkingLot: 10/10\n"));
    }

    @Test
    public void should_return_correct_give_DoorMan_with_2_parkingLot() {
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        DoorMan doorMan = new DoorMan(new NormalRule());
        doorMan.manage(parkingLot1);
        doorMan.manage(parkingLot2);
        assertThat(doorMan.report(0), is("DoorMan:\n  ParkingLot: 10/10\n  ParkingLot: 10/10\n"));
    }

    @Test
    public void should_return_correct_give_manager_with_a_DoorMan_who_with_2_parkingLot() {
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        DoorMan doorMan = new DoorMan(new NormalRule());
        doorMan.manage(parkingLot1);
        doorMan.manage(parkingLot2);
        DoorManManger doorManManger = new DoorManManger(new NormalRule());
        doorManManger.manage(doorMan);
        assertThat(doorManManger.report(0), is("Manager:\n  DoorMan:\n    ParkingLot: 10/10\n    ParkingLot: 10/10\n"));
    }

    @Test
    public void should_return_correct_give_manager_with_a_manager_who_with_a_DoorMan_who_with_2_parkingLot() {
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        DoorMan doorMan = new DoorMan(new NormalRule());
        doorMan.manage(parkingLot1);
        doorMan.manage(parkingLot2);
        DoorManManger doorManManger = new DoorManManger(new NormalRule());
        DoorManManger seniorManger = new DoorManManger(new NormalRule());
        doorManManger.manage(doorMan);
        seniorManger.manage(doorManManger);
        assertThat(seniorManger.report(0), is("Manager:\n  Manager:\n    DoorMan:\n      ParkingLot: 10/10\n      ParkingLot: 10/10\n"));
    }
}
