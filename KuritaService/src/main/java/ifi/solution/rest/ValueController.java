package ifi.solution.rest;


import java.util.Date;
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

import ifi.solution.model.Meter;
import ifi.solution.model.Value;
import ifi.solution.service.MeterService;
import ifi.solution.service.ValueService;

@RestController
@RequestMapping("kurita")
public class ValueController {

	@Autowired
	private ValueService valueService;
	
	@Autowired
	private MeterService meterService;
	
	@RequestMapping(value="/value/",method=RequestMethod.GET)
	public ResponseEntity<?> listGetAll(){
		List<Value> list = valueService.getAll();
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Value>>(list,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/value/{date}",method=RequestMethod.GET)
	public ResponseEntity<?> listGetDate(@PathVariable Date date){
		List<Value> list = valueService.getByDate(date);
		if(list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<List<Value>>(list,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/value/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> getById(@PathVariable int id){
		Value list = valueService.getById(id);
		if(list == null) {
			return new ResponseEntity<>("Value not found",HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<Value>(list,HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/value/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateValue(@PathVariable int id ,Value value) {
		Value value_current = valueService.getById(id);
		if(value_current == null) {
			return new ResponseEntity<>("Unable to update. Value not found", HttpStatus.NOT_FOUND);
		}else {
			value.setId(value_current.getId());
			value.setMeter(meterService.getById(value.getMeter().getId()));
			valueService.update(value);
			return new ResponseEntity<Value>(value, HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value = "/value/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteValue(@PathVariable int id) {
		Value value = valueService.getById(id);
		if(value == null) {
			return new ResponseEntity<>("Unable to delete. Value not found",HttpStatus.NOT_FOUND);
		}else {
			valueService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/value/", method = RequestMethod.POST)
	public ResponseEntity<?> addValue(Value value, UriComponentsBuilder ucBuilder) {
		value.setMeter(meterService.getById(value.getMeter().getId()));
		valueService.save(value);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/kurita/value/{id}").buildAndExpand(value.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
}
