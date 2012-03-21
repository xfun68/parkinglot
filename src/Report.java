import java.util.List;

public class Report {
    private int depth;

    public Report() {
        this.depth = 0;
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
        depth++;
        for (ParkingFacility facility : parkingFacilities) {
            reports += facility.report(this);
        }
        depth--;
        return reports;
    }
}
