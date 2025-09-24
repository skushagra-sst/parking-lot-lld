package parking_lot.services.BillingService;

import parking_lot.entities.Ticket;

public interface BillingService {
    double calculateBill(Ticket ticket);
}
