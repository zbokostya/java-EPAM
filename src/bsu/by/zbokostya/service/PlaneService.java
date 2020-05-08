package bsu.by.zbokostya.service;

import bsu.by.zbokostya.DAO.PlaneDao;
import bsu.by.zbokostya.entity.Plane;
import bsu.by.zbokostya.exception.ServiceException;

import java.util.ArrayList;

public class PlaneService extends Service<Plane>{
    private PlaneDao planeDao;

    public PlaneService() {
        planeDao = new PlaneDao();
    }

    @Override
    public ArrayList<Plane> getData() {
        return planeDao.getData();
    }

    @Override
    public void read() {
        planeDao.read();
    }

    @Override
    public void create(Plane entity) {
        try {

            if (!(isEntityExist(entity))) {
                entity.setId(planeDao.create(entity));
                if(entity.getId() == 0 ) throw new ServiceException("plane id not created");
            } else {
                throw  new ServiceException("such plane already exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void update(Plane entity) {
        try {
            if ((isEntityExist(entity))) {
                planeDao.update(entity);
            } else {
                throw  new ServiceException("such plane does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(Plane entity) {
        try {
            if (isEntityExist(entity)) {
                planeDao.delete(entity.getId());
            } else {
                throw  new ServiceException("such plane does not exist");

            }
        }
        catch (ServiceException e){
            log.error(e.getMessage());
        }
    }
}
