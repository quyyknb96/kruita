package ifi.solution.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifi.solution.dao.EventDAO;
import ifi.solution.model.Event;
import ifi.solution.model.Value;
import ifi.solution.service.EventService;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	private EventDAO eventDAO;
	
	@Override
	public Event getById(int id) {
		// TODO Auto-generated method stub
		return eventDAO.findById(id);
	}

	@Override
	public List<Event> getAll() {
		// TODO Auto-generated method stub
		return eventDAO.findAll();
	}

	@Override
	public Event save(Event event) {
		// TODO Auto-generated method stub
		return eventDAO.save(event);
	}

	@Override
	public boolean update(Event event) {
		// TODO Auto-generated method stub
		if(eventDAO.save(event)!=null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(this.getById(id)!= null){
			eventDAO.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Event> getByValue(int id) {
		// TODO Auto-generated method stub
		return eventDAO.findByValueId(id);
	}

}
