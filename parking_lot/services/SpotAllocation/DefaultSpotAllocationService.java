package parking_lot.services.SpotAllocation;

import java.sql.Timestamp;

import parking_lot.entities.Gate;
import parking_lot.entities.Spot;
import parking_lot.entities.Ticket;
import parking_lot.entities.Vehicle;
import parking_lot.stratigies.SpotAllocationStrategy.SpotAllocationStrategy;

public class DefaultSpotAllocationService implements SpotAllocationService {

    private SpotAllocationStrategy spotAllocationStrategy;

    public DefaultSpotAllocationService(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    private String generateTicketID() {
        return "TICKET-" + System.currentTimeMillis();
    }

    @Override
    public Ticket allocateSpot(Gate gate, Vehicle vehicle) {

        Spot s = this.spotAllocationStrategy.getNearestSpot(gate, vehicle);

        return new Ticket.Builder()
                .setGate(gate)
                .setSpot(s)
                .setVehicle(vehicle)
                .setTicketId(generateTicketID())
                .setIssuedAt(new Timestamp(System.currentTimeMillis()))
                .build();
    }

}
