package parking_lot.services.BillingService;

import parking_lot.entities.Ticket;
import parking_lot.enums.PaymentStatus;
import parking_lot.facade.PaymentFacade;
import parking_lot.stratigies.BillingStrategy.BillingStrategy;
import parking_lot.utils.PostPaymentProcess;

public class DefaultBillingService implements BillingService {

    private BillingStrategy billingStrategy;

    public DefaultBillingService(BillingStrategy billingStrategy) {
        this.billingStrategy = billingStrategy;
    }

    @Override
    public PostPaymentProcess pay(Ticket ticket) {
        double amount = this.billingStrategy.calculate(ticket);

        PaymentStatus ps = PaymentFacade.processPayment(ticket, amount);

        return new PostPaymentProcess() {
            private Runnable successCallback;
            private Runnable failureCallback;

            @Override
            public PostPaymentProcess onSuccess(Runnable successCallback) {
                this.successCallback = successCallback;
                return this;

            }

            @Override
            public PostPaymentProcess onFailure(Runnable failureCallback) {
                this.failureCallback = failureCallback;
                return this;
            }

            @Override
            public void execute() {
                if (ps == PaymentStatus.COMPLETED) {
                    successCallback.run();
                } else {
                    failureCallback.run();
                }
            }
        };
    }

}
