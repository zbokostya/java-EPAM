package bsu.by.zbokostya.service;

import bsu.by.zbokostya.DAO.FlightDao;
import bsu.by.zbokostya.entity.Flight;
import bsu.by.zbokostya.exception.ServiceException;

import java.util.ArrayList;

public class FlightService extends Service<Flight> {
    private FlightDao flightDao;

    public FlightService() {
        flightDao = new FlightDao();
    }

    @Override
    public ArrayList<Flight> getData() {
        return flightDao.getData();
    }

    @Override
    public void read() {
        flightDao.read();
    }

    @Override
    public void create(Flight entity) {
        try {

            if (!(isEntityExist(entity))) {
                flightDao.create(entity);
            } else {
                throw new ServiceException("such flight already exist");

            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void update(Flight entity) {
        try {
            if ((isEntityExist(entity))) {
                flightDao.update(entity);
            } else {
                throw new ServiceException("such flight does not exist");

            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(Flight entity) {
        try {
            if (isEntityExist(entity)) {
                flightDao.delete(entity.getId());
            } else {
                throw new ServiceException("such flight does not exist");

            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }
}
