package ifi.solution.service;

import java.util.List;

import ifi.solution.model.Event;

public interface EventService {
	Event getById(int id);
	List<Event> getAll();
	Event save(Event event);
	boolean update(Event event);
	boolean delete(int id);
	List<Event> getByValue(int id);
}
