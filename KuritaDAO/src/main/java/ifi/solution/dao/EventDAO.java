package ifi.solution.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifi.solution.model.Event;

@Repository
public interface EventDAO extends JpaRepository<Event, Integer> {
	Event findById(int id);
	List<Event> findByValueId(int id);
}
