package ifi.solution.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifi.solution.model.Meter;
import ifi.solution.model.Value;
import ifi.solution.service.ValueService;
import ifi.solution.dao.ValueDAO;


@Service
public class ValueServiceImpl implements ValueService {
	@Autowired
	private ValueDAO valueRepository;
	
	@Override
	public Value getById(int id) {
		// TODO Auto-generated method stub
		return valueRepository.findById(id);
	}

	@Override
	public List<Value> getAll() {
		// TODO Auto-generated method stub
		return valueRepository.findAll();
	}

	@Override
	public Value save(Value value) {
		// TODO Auto-generated method stub
		return valueRepository.save(value);
	}

	@Override
	public boolean update(Value value) {
		// TODO Auto-generated method stub
		if(valueRepository.save(value) != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if (this.getById(id)!=null) {
			valueRepository.deleteById(id);
			return true;
		}else {
			return false;	
		}		
	}

	@Override
	public List<Value> getByDate(Date date) {
		// TODO Auto-generated method stub
		return valueRepository.findByDate(date);
	}
	

//	@Override
//	public Value getDateNearest(Date date, Meter meter) {
//		// TODO Auto-generated method stub
//		return valueRepository.findTopByDateLessThanOrderByDateDescAndByMeter(date, meter);
//	}

}
