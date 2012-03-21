import java.util.List;

public class Report {
    private final int depth;

    public Report() {
        this(0);
    }

    private Report(int depth) {
        this.depth = depth;
    }

    public String reportParkingLot(int availableSize, int capacity) {
        return indent() + "ParkingLot: " + availableSize + "/" + capacity + "\n";
    }

    private String indent() {
        String prefix = "";
        for (int i = 0; i < depth; i++) {
            prefix += "  ";
        }
        return prefix;
    }

    public String reportManager(List<? extends ParkingFacility> parkingFacilities, String name) {
        String reports = indent() + name;
        for (ParkingFacility facility : parkingFacilities) {
            reports += facility.report(new Report(depth +1));
        }
        return reports;
    }
}
