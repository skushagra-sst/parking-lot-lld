package parking_lot;

import java.util.List;

import parking_lot.entities.Gate;
import parking_lot.entities.Spot;
import parking_lot.entities.Ticket;
import parking_lot.entities.Vehicle;
import parking_lot.enums.PaymentStatus;
import parking_lot.services.BillingService.BillingService;
import parking_lot.services.SpotAllocation.SpotAllocationService;

public class ParkingLot {

    private SpotAllocationService spotAllocationService;
    private BillingService billingService;
    private List<Spot> spots;
    private List<Gate> gates;

    private ParkingLot() {
    }

    public Ticket allocateSpot(Gate g, Vehicle v) {
        return this.spotAllocationService.allocateSpot(g, v);
    }

    public void checkout(Ticket t) {
        t.setExitedAt();
        this.billingService.pay(t)
                .onSuccess(() -> {

                    this.spotAllocationService.deallocateSpot(t);
                })
                .onFailure(() -> {
                    System.out.println("Payment Failed for ticket: " + t.getTicketId());
                }).execute();

    }

    public void addSpot(Spot s) {
        this.spots.add(s);
    }

    public void addGate(Gate g) {
        this.gates.add(g);
    }

    public static class Builder {
        private SpotAllocationService spotAllocationService;
        private BillingService billingService;
        private List<Spot> spots;
        private List<Gate> gates;

        public Builder setBillingService(BillingService billingService) {
            this.billingService = billingService;
            return this;
        }

        public Builder setSpotAllocationService(SpotAllocationService spotAllocationService) {
            this.spotAllocationService = spotAllocationService;
            return this;
        }

        public Builder setSpots(List<Spot> spots) {
            this.spots = spots;
            return this;
        }

        public Builder setGates(List<Gate> gates) {
            this.gates = gates;
            return this;
        }

        public ParkingLot build() {
            ParkingLot parkingLot = new ParkingLot();
            parkingLot.spots = this.spots;
            parkingLot.gates = this.gates;
            parkingLot.spotAllocationService = this.spotAllocationService;
            parkingLot.billingService = this.billingService;
            return parkingLot;
        }
    }
}
