package parking_lot.entities;

import java.sql.Timestamp;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;
    private Spot spot;
    private Gate gate;
    private Timestamp issuedAt;
    private Timestamp exitedAt;

    public Ticket(String ticketId, Vehicle vehicle, Spot spot, Gate gate, Timestamp issuedAt, Timestamp exitedAt) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.spot = spot;
        this.gate = gate;
        this.issuedAt = issuedAt;
        this.exitedAt = exitedAt;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Timestamp getIssuedAt() {
        return issuedAt;
    }

    public Timestamp getExitedAt() {
        return exitedAt;
    }

    public Spot getSpot() {
        return spot;
    }

    public Gate getGate() {
        return gate;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public static class Builder {
        private String ticketId;
        private Vehicle vehicle;
        private Gate gate;
        private Spot spot;
        private Timestamp issuedAt;
        private Timestamp exitedAt;

        public Builder setTicketId(String ticketId) {
            this.ticketId = ticketId;
            return this;
        }

        public Builder setIssuedAt(Timestamp issuedAt) {
            this.issuedAt = issuedAt;
            return this;
        }

        public Builder setExitedAt(Timestamp exitedAt) {
            this.exitedAt = exitedAt;
            return this;
        }

        public Builder setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
            return this;
        }

        public Builder setSpot(Spot spot) {
            this.spot = spot;
            return this;
        }

        public Builder setGate(Gate gate) {
            this.gate = gate;
            return this;
        }

        public Ticket build() {
            return new Ticket(ticketId, vehicle, spot, gate, issuedAt, exitedAt);
        }
    }
}
