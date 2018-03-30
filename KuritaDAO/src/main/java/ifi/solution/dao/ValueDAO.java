package ifi.solution.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifi.solution.model.Meter;
import ifi.solution.model.Value;

@Repository
public interface ValueDAO extends JpaRepository<Value, Integer> {
	Value findById(int id);
	List<Value> findByMeter(Meter meter);
	Value findByMeterAndDateGreaterThanDate(Meter meter , Long date);
}
