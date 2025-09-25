import java.util.ArrayList;
import java.util.List;

import parking_lot.ParkingLot;
import parking_lot.entities.Gate;
import parking_lot.entities.Spot;
import parking_lot.entities.Ticket;
import parking_lot.entities.Vehicle;
import parking_lot.enums.VehicleType;
import parking_lot.facade.ParkingLotFacade;
import parking_lot.repository.DistanceRepository.DistanceRepository;
import parking_lot.repository.DistanceRepository.SimpleDistanceRepository;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Spot> spots = new ArrayList<>();
        List<Gate> gates = new ArrayList<>();
        DistanceRepository distanceRepository = new SimpleDistanceRepository();

        for (int i = 1; i <= 3; i++) {
            Gate g = new Gate("G" + i);
            gates.add(g);
            distanceRepository.addGate(g);
        }

        for (int i = 1; i <= 10; i++) {
            Spot s = new Spot("S" + i,
                    i % 3 == 0 ? VehicleType.BIKE : (i % 3 == 1 ? VehicleType.CAR : VehicleType.TRUCK));
            spots.add(s);
            for (Gate g : gates) {
                distanceRepository.addDistance(g, s, Math.random() * 100);
            }
        }

        ParkingLot parkingLot = ParkingLotFacade.create(gates, spots, distanceRepository);

        Vehicle v = new Vehicle(VehicleType.CAR, "HP 39A 0118");

        Ticket t = parkingLot.allocateSpot(gates.get(0), v);

        parkingLot.checkout(t);

    }
}
