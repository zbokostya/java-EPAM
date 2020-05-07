package bsu.by.zbokostya;

import bsu.by.zbokostya.DAO.*;
import bsu.by.zbokostya.entity.Flight;
import bsu.by.zbokostya.entity.Plane;
import bsu.by.zbokostya.entity.Route;
import bsu.by.zbokostya.entity.Ticket;
import bsu.by.zbokostya.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        //ClientService clientService = new ClientService();
        RouteService routeService = new RouteService();
        FlightService flightService = new FlightService();
        PlaneService planeService = new PlaneService();
        TicketService ticketService = new TicketService();

        Route route = new Route("Minsk", "Moscow");
        Plane plane = new Plane("Plane1", 30, "123-ab", 1);
        Flight flight = new Flight(plane, route, new Date());
        Ticket ticket = new Ticket(flight, plane, 5, 30);

        routeService.create(route);
        System.out.println(route.getId());
        //flightService.create(flight);
        //planeService.create(plane);
        //ticketService.create(ticket);
        //routeService.read();
        //System.out.println(routeService.getData());

        //routeService.read();
        //routeService.update(route);
        //System.out.println(routeService.getData());
    }
}
