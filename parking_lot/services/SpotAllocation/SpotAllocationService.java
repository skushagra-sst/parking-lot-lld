package parking_lot.services.SpotAllocation;

import parking_lot.entities.Gate;
import parking_lot.entities.Ticket;
import parking_lot.entities.Vehicle;

public interface SpotAllocationService {
    public Ticket allocateSpot(Gate gate, Vehicle vehicle);

    public void deallocateSpot(Ticket ticket);
}
