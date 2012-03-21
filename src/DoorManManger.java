public class DoorManManger extends DoorMan {

    public DoorManManger(ParkingRule parkingRule) {
        super(parkingRule);
    }

    public Receipt park(Car car) {
        for (ParkingFacility facility : parking_facilities) {
            Receipt receipt = facility.park(car);
            if(null != receipt) {
                return receipt;
            }
        }
        return null;
    }

    @Override
    public String report(int depth) {
        String prefix = "";
        for (int i = 0; i < depth; i++) {
            prefix += "  ";
        }
        String reports = prefix + "Manager:\n";
        for(ParkingFacility facility : parking_facilities) {
            String sub_reports = facility.report(depth + 1);
            sub_reports.replace("  ", "    ");
            reports += sub_reports;
        }
        return reports;
    }

}
