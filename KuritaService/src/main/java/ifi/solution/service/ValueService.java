package ifi.solution.service;

import java.util.Date;
import java.util.List;

import ifi.solution.model.Meter;
import ifi.solution.model.Value;

public interface ValueService {
	Value getById(int id);	
	List<Value> getAll();
	Value save(Value value);
	boolean update(Value value);
	boolean delete(int id);
}
