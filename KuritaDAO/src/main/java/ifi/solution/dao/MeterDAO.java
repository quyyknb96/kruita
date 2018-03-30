package ifi.solution.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifi.solution.model.Meter;

@Repository
public interface MeterDAO extends JpaRepository<Meter, Integer> {
	Meter findById(int id);
}
