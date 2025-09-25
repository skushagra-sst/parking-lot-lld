package parking_lot.services.BillingService;

import parking_lot.entities.Ticket;
import parking_lot.utils.PostPaymentProcess;

public interface BillingService {
    PostPaymentProcess pay(Ticket ticket);
}
