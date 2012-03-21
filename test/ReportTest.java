import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ReportTest {

    @Test
    public void should_return_correct_give_parkingLot() {
        ParkingLot parkingLot = new ParkingLot(10);
        assertThat(parkingLot.report(), is("ParkingLot: 10/10"));
    }
}
