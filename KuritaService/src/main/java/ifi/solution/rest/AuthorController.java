package ifi.solution.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ifi.solution.model.Author;
import ifi.solution.service.AuthorService;

@RestController
@RequestMapping("/kurita")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	@RequestMapping(value = "/author/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable int id){
		Author author = authorService.getById(id);
		if(author != null) {
			return new ResponseEntity<Author>(author,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("Author not found",HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value = "/author/", method = RequestMethod.GET)
	public ResponseEntity<?> listGetAll(){
		List<Author> list = authorService.getAll();
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Author>>(list,HttpStatus.NOT_FOUND);
		}
	}
}
