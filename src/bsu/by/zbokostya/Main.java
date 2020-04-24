package bsu.by.zbokostya;

import bsu.by.zbokostya.DAO.*;
import bsu.by.zbokostya.entity.Flight;
import bsu.by.zbokostya.entity.Route;
import bsu.by.zbokostya.service.ClientService;
import bsu.by.zbokostya.service.RouteService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        ClientService clientService = new ClientService();
        RouteService routeService = new RouteService();
        Route route = new Route("Minsk", "Moscow");
        routeService.create(route);
        //routeService.read();
        //routeService.update(route);
        //System.out.println(routeService.getData());
    }
}
