package ifi.solution.service;

import java.util.List;

import ifi.solution.model.Author;

public interface AuthorService {
	Author getById(int id);
	Author getByUsername(String username);
	List<Author> getAll();
	boolean update(Author author);
	boolean delete(int id);
	Author save(Author author);
}
