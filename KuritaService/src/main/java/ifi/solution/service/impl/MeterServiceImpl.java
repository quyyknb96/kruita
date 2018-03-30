package ifi.solution.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifi.solution.dao.MeterDAO;
import ifi.solution.model.Meter;
import ifi.solution.service.MeterService;

@Service
public class MeterServiceImpl implements MeterService{

	@Autowired
	private MeterDAO meterRepository;
	
	@Override
	public Meter getById(int id) {
		return meterRepository.findById(id);			
	}

	@Override
	public List<Meter> getAll() {
		// TODO Auto-generated method stub
		return meterRepository.findAll();
	}

	@Override
	public Meter save(Meter meter) {
		// TODO Auto-generated method stub		
		return meterRepository.save(meter);
	}

	@Override
	public boolean update(Meter meter) {
		// TODO Auto-generated method stub
		if(meterRepository.save(meter) != null) {
			return true;
		}else {
			return false;
		}		
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(this.getById(id) != null) {
			meterRepository.deleteById(id);
			return true;
		}else {
			return false;
		}		
	}

	@Override
	public boolean isExist(Meter meter) {
		// TODO Auto-generated method stub
		return false;
	}


}
