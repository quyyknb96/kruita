package ifi.solution.service;

import java.util.List;

import ifi.solution.model.Meter;

public interface MeterService {
	Meter getById(int id);	
	List<Meter> getAll();
	Meter save(Meter meter);
	boolean update(Meter meter);
	boolean delete(int id);
	boolean isExist(Meter meter);
}
