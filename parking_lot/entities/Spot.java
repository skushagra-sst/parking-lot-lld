package parking_lot.entities;

public class Spot {

    private String slotId;

    public Spot(String slotId) {
        this.slotId = slotId;
    }

    public String getSlotId() {
        return slotId;
    }

    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }

}
