package parking_lot.entities;

import parking_lot.enums.VehicleType;

public class Spot {

    private String slotId;
    private VehicleType supportedVehicleType;
    private Vehicle occupiedBy;

    public Spot(String slotId, VehicleType vehicleType) {
        this.slotId = slotId;
        this.supportedVehicleType = vehicleType;
        this.occupiedBy = null;
    }

    public String getSlotId() {
        return slotId;
    }

    public VehicleType getVehicleType() {
        return supportedVehicleType;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.supportedVehicleType = vehicleType;
    }

    public Vehicle getOccupiedBy() {
        return occupiedBy;
    }

    public void setOccupiedBy(Vehicle occupiedBy) {
        this.occupiedBy = occupiedBy;
    }

    public boolean isFree() {
        return this.occupiedBy == null;
    }

    public void freeSpot() {
        this.occupiedBy = null;
    }

}
