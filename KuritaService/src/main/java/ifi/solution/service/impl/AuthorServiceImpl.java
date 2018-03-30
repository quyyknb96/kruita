package ifi.solution.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ifi.solution.dao.AuthorDAO;
import ifi.solution.model.Author;
import ifi.solution.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	private AuthorDAO authorRepository;
	
	@Override
	public Author getById(int id) {
		// TODO Auto-generated method stub
		return authorRepository.findById(id);
	}

	@Override
	public Author getByUsername(String username) {
		// TODO Auto-generated method stub
		return authorRepository.findByUsername(username);
	}

	@Override
	public List<Author> getAll() {
		// TODO Auto-generated method stub
		return authorRepository.findAll();
	}

	@Override
	public boolean update(Author author) {
		// TODO Auto-generated method stub
		if(authorRepository.save(author) != null) {
			return true;
		}else {
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		if(this.getById(id)!=null) {
			authorRepository.deleteById(id);
			return true;
		}else {
			return false;
		}
	}

	@Override
	public Author save(Author author) {
		// TODO Auto-generated method stub
		authorRepository.save(author);
		return author;
	}

}
