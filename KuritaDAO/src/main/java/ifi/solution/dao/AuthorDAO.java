package ifi.solution.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ifi.solution.model.Author;

@Repository
public interface AuthorDAO extends JpaRepository<Author, Integer>{
	Author findById(int id);
	Author findByUsername(String username);
}
