import java.util.ArrayList;
import java.util.List;

import parking_lot.ParkingLot;
import parking_lot.entities.Gate;
import parking_lot.entities.Spot;
import parking_lot.entities.Vehicle;
import parking_lot.entities.VehicleType;
import parking_lot.services.BillingService.BillingService;
import parking_lot.services.BillingService.DefaultBillingService;
import parking_lot.services.SpotAllocation.DefaultSpotAllocationService;
import parking_lot.services.SpotAllocation.SpotAllocationService;
import parking_lot.stratigies.BillingStrategy.BillingStrategy;
import parking_lot.stratigies.BillingStrategy.DefaultBillingStrategy;
import parking_lot.stratigies.SpotAllocationStrategy.DefaultSpotAllocationStrategy;
import parking_lot.stratigies.SpotAllocationStrategy.SpotAllocationStrategy;

public class Main {
    public static void main(String[] args) {

        SpotAllocationStrategy spotAllocationStrategy = new DefaultSpotAllocationStrategy();
        SpotAllocationService spotAllocationService = new DefaultSpotAllocationService(spotAllocationStrategy);

        BillingStrategy billingStrategy = new DefaultBillingStrategy();
        BillingService billingService = new DefaultBillingService(billingStrategy);

        List<Spot> spots = new ArrayList<>();
        List<Gate> gates = new ArrayList<>();

        ParkingLot parkingLot = new ParkingLot.Builder()
                .setBillingService(billingService)
                .setSpotAllocationService(spotAllocationService)
                .setSpots(spots)
                .setGates(gates)
                .build();

        parkingLot.allocateSpot(gates.get(0), new Vehicle(VehicleType.CAR, "HP 39A 0118"));
    }
}
