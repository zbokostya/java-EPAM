package bsu.by.zbokostya.service;

import bsu.by.zbokostya.DAO.RouteDao;
import bsu.by.zbokostya.entity.Route;
import bsu.by.zbokostya.exception.ServiceException;

import java.util.ArrayList;

public class RouteService extends Service<Route> {
    RouteDao routeDao;

    public RouteService() {
        routeDao = new RouteDao();
    }

    @Override
    public ArrayList<Route> getData() {
        return routeDao.getData();
    }

    @Override
    public void read() {
        routeDao.read();
    }

    @Override
    public void create(Route entity) {
        try {

            if (!(isEntityExist(entity))) {
                routeDao.create(entity);
            } else {
                throw new ServiceException("such route already exist");

            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void update(Route entity) {
        try {
            if ((isEntityExist(entity))) {
                routeDao.update(entity);
            } else {
                throw new ServiceException("such route does not exist");

            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(Route entity) {
        try {
            if (isEntityExist(entity)) {
                routeDao.delete(entity.getId());
            } else {
                throw new ServiceException("such route does not exist");

            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }
}
