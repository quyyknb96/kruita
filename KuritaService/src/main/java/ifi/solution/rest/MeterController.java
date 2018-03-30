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

import ifi.solution.model.Meter;
import ifi.solution.service.MeterService;

@RestController
@RequestMapping("/kurita")
public class MeterController {

	@Autowired
	private MeterService meterService;

	@RequestMapping(value = "/meter/", method = RequestMethod.GET)
	public ResponseEntity<List<Meter>> listGetAll() {
		List<Meter> list = meterService.getAll();
		if (list.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Meter>>(list, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/meter/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> listById(@PathVariable int id) {
		Meter list = meterService.getById(id);
		if (list != null) {
			return new ResponseEntity<Meter>(list, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Meter not found", HttpStatus.NOT_FOUND);
		}
	}

	@RequestMapping(value = "/meter/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateMeter(@PathVariable int id ,Meter meter) {
		Meter meter_current = meterService.getById(id);
		if(meter_current == null) {
			return new ResponseEntity<>("Unable to update. Meter not found", HttpStatus.NOT_FOUND);
		}else {
			meter.setId(meter_current.getId());
			meterService.update(meter);
			return new ResponseEntity<Meter>(meter, HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value = "/meter/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteMeter(@PathVariable int id) {
		Meter meter = meterService.getById(id);
		if(meter == null) {
			return new ResponseEntity<>("Unable to delete. Meter not found",HttpStatus.NOT_FOUND);
		}else {
			meterService.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/meter/", method = RequestMethod.POST)
	public ResponseEntity<?> addMeter(Meter meter, UriComponentsBuilder ucBuilder) {

		meterService.save(meter);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/kurita/meter/{id}").buildAndExpand(meter.getId()).toUri());
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}	
	
}
