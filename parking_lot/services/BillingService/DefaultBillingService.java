package parking_lot.services.BillingService;

import parking_lot.entities.Ticket;
import parking_lot.stratigies.BillingStrategy.BillingStrategy;

public class DefaultBillingService implements BillingService {

    private BillingStrategy billingStrategy;

    public DefaultBillingService(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    @Override
    public double calculateBill(Ticket ticket) {
        return this.billingStrategy.calculate(ticket);
    }

}
