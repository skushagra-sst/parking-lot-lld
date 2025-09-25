package parking_lot.stratigies.BillingStrategy;

import java.sql.Timestamp;
import java.time.Duration;

import parking_lot.entities.Ticket;

public class DefaultBillingStrategy implements BillingStrategy {

    @Override
    public double calculate(Ticket t) {
        Timestamp inputTime = t.getIssuedAt();
        Timestamp exitTime = t.getExitedAt();

        Duration duration = Duration.between(inputTime.toInstant(), exitTime.toInstant());
        long totalMinutes = duration.toMinutes();

        double hours = Math.ceil(totalMinutes / 60.0);

        return hours * 10;
    }
}
