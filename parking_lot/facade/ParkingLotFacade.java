package parking_lot.facade;

import java.util.ArrayList;
import java.util.List;

import parking_lot.ParkingLot;
import parking_lot.entities.Gate;
import parking_lot.entities.Spot;
import parking_lot.repository.DistanceRepository.DistanceRepository;
import parking_lot.services.BillingService.BillingService;
import parking_lot.services.BillingService.DefaultBillingService;
import parking_lot.services.SpotAllocation.DefaultSpotAllocationService;
import parking_lot.services.SpotAllocation.SpotAllocationService;
import parking_lot.stratigies.BillingStrategy.BillingStrategy;
import parking_lot.stratigies.BillingStrategy.DefaultBillingStrategy;
import parking_lot.stratigies.SpotAllocationStrategy.DefaultSpotAllocationStrategy;
import parking_lot.stratigies.SpotAllocationStrategy.SpotAllocationStrategy;

public class ParkingLotFacade {

    public static ParkingLot create(List<Gate> gates, List<Spot> spots, DistanceRepository distanceRepository) {
        SpotAllocationStrategy spotAllocationStrategy = new DefaultSpotAllocationStrategy(distanceRepository);
        SpotAllocationService spotAllocationService = new DefaultSpotAllocationService(spotAllocationStrategy);

        BillingStrategy billingStrategy = new DefaultBillingStrategy();
        BillingService billingService = new DefaultBillingService(billingStrategy);

        ParkingLot parkingLot = new ParkingLot.Builder()
                .setBillingService(billingService)
                .setSpotAllocationService(spotAllocationService)
                .setSpots(spots)
                .setGates(gates)
                .build();

        return parkingLot;
    }

}
