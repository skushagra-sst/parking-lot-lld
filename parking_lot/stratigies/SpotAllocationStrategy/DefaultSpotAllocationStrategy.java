package parking_lot.stratigies.SpotAllocationStrategy;

import parking_lot.entities.Gate;
import parking_lot.entities.Spot;
import parking_lot.entities.Vehicle;
import parking_lot.repository.DistanceRepository.DistanceRepository;

public class DefaultSpotAllocationStrategy implements SpotAllocationStrategy {

    private DistanceRepository distanceRepository;

    public DefaultSpotAllocationStrategy(DistanceRepository distanceRepository) {
        this.distanceRepository = distanceRepository;
    }

    @Override
    public Spot getSpot(Gate g, Vehicle v) {
        this.distanceRepository.getSpots(g);

        Spot minDistAvailableSpot = null;
        double minDist = Double.MAX_VALUE;

        for (Spot s : this.distanceRepository.getSpots(g).keySet()) {
            if (s.isFree() && s.getVehicleType() == v.getVehicleType()) {
                double dist = this.distanceRepository.getDistance(g, s);
                if (dist < minDist) {
                    minDist = dist;
                    minDistAvailableSpot = s;
                }
            }
        }

        return minDistAvailableSpot;
    }

}
