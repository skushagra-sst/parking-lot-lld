package parking_lot.facade;

import parking_lot.entities.Ticket;
import parking_lot.enums.PaymentStatus;

public class PaymentFacade {

    public static PaymentStatus processPayment(Ticket t, double amount) {
        System.out.println("Processing payment of $" + amount + " for ticket ID: " + t.getTicketId());
        return PaymentStatus.COMPLETED;
    }

}
