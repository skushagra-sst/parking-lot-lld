package parking_lot.stratigies.BillingStrategy;

import parking_lot.entities.Ticket;

public interface BillingStrategy {
    public double calculate(Ticket t);
}
