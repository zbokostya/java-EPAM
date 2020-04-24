package bsu.by.zbokostya.service;

import bsu.by.zbokostya.DAO.TicketDao;
import bsu.by.zbokostya.entity.Ticket;
import bsu.by.zbokostya.exception.ServiceException;

import java.util.ArrayList;

public class TicketService extends Service<Ticket> {

    private TicketDao ticketDao;

    public TicketService() {
        ticketDao = new TicketDao();
    }

    @Override
    public ArrayList<Ticket> getData() {
        return ticketDao.getData();
    }

    @Override
    public void read() {
        ticketDao.read();
    }

    @Override
    public void create(Ticket entity) {
        try {

            if (!(isEntityExist(entity))) {
                ticketDao.create(entity);
            } else {
                throw new ServiceException("such ticket already exist");

            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void update(Ticket entity) {
        try {
            if ((isEntityExist(entity))) {
                ticketDao.update(entity);
            } else {
                throw new ServiceException("such ticket does not exist");

            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }

    @Override
    public void delete(Ticket entity) {
        try {
            if (isEntityExist(entity)) {
                ticketDao.delete(entity.getId());
            } else {
                throw new ServiceException("such plane does not exist");

            }
        } catch (ServiceException e) {
            log.error(e.getMessage());
        }
    }
}
