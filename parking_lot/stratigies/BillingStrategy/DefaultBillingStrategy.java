package parking_lot.stratigies.BillingStrategy;

import parking_lot.entities.Ticket;

public class DefaultBillingStrategy implements BillingStrategy {

    @Override
    public double calculate(Ticket t) {
        return 0;
    }

}
