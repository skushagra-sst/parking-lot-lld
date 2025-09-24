package parking_lot.stratigies.SpotAllocationStrategy;

import parking_lot.entities.Gate;
import parking_lot.entities.Spot;
import parking_lot.entities.Vehicle;

public interface SpotAllocationStrategy {
    public Spot getNearestSpot(Gate g, Vehicle v);
}
