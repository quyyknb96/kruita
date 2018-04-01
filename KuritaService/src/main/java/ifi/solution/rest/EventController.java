package ifi.solution.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import ifi.solution.model.Event;
import ifi.solution.service.EventService;

@RestController
@RequestMapping("/kurita")
public class EventController {

	@Autowired
	private EventService eventService;
	
	@RequestMapping(value="/event/",method=RequestMethod.GET)
	public ResponseEntity<?> listGetAll(){
		List<Event> list = eventService.getAll();
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Event>>(list,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/event/value{id}",method=RequestMethod.GET)
	public ResponseEntity<?> listGetDate(@PathVariable int id){
		List<Event> list = eventService.getByValue(id);
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Event>>(list,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/event/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable int id){
		Event list = eventService.getById(id);
		if(list == null) {
			return new ResponseEntity<>("Event not found",HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Event>(list,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/event/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateEvent(@PathVariable int id ,Event Event) {
		Event Event_current = eventService.getById(id);
		if(Event_current == null) {
			return new ResponseEntity<>("Unable to update. Event not found", HttpStatus.NOT_FOUND);
		}else {
			Event.setId(Event_current.getId());
			eventService.update(Event);
			return new ResponseEntity<Event>(Event, HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEvent(@PathVariable int id) {
		Event Event = eventService.getById(id);
		if(Event == null) {
			return new ResponseEntity<>("Unable to delete. Event not found",HttpStatus.NOT_FOUND);
		}else {
			eventService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/event/", method = RequestMethod.POST)
	public ResponseEntity<?> addEvent(Event Event, UriComponentsBuilder ucBuilder) {

		eventService.save(Event);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/kurita/event/{id}").buildAndExpand(Event.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
}
