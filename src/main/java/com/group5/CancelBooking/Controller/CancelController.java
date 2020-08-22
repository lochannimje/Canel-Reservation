package com.group5.CancelBooking.Controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.group5.CancelBooking.Service.CancelService;
import com.group5.CancelBooking.dto.BookingDTO;
import com.group5.CancelBooking.dto.CancelDTO;
import com.group5.CancelBooking.dto.Status;
import com.group5.CancelBooking.entity.CancelEntity;

import com.group5.CancelBooking.repository.CancelRepository;



@RestController
@CrossOrigin
@RequestMapping(value="/cancel")

public class CancelController {
	
		Logger logger = LoggerFactory.getLogger(this.getClass());
		
		@Autowired
		CancelService cancelService;

		
		@Autowired
		RestTemplate template;
		
		@PostMapping(value = "/add",  consumes = MediaType.APPLICATION_JSON_VALUE)
		public void addDetails(@RequestBody CancelDTO cancelDTO) {
			System.out.println("inside cont");
			BookingDTO dto = template.getForObject("http://BOOKINGMS"+"/booking/Id/"+cancelDTO.getBooking_id(), BookingDTO.class);

		    	System.out.println("inside cont1");
		    	if(dto.getStatus().equals(Status.Confirmed)){

		    		cancelDTO.setStatus(Status.Cancelled);
		    		cancelDTO.setDate(dto.getDate());
		    		cancelDTO.setDest(dto.getDest());
		    		cancelDTO.setSource(dto.getSource());
		    		cancelDTO.setTravel_mode(dto.getTravelMode());
		    	
		    	}
		    	

			logger.info("booking details added {}", cancelDTO);
			
				
			cancelService.addDetails(cancelDTO);
		
			
		}	
		
		@GetMapping(value = "/details",  produces = MediaType.APPLICATION_JSON_VALUE)
		public List<CancelDTO> getAlldetails() {
			System.out.println("inside get method");
			return cancelService.getAlldetails();
		}
		

		@GetMapping(value= "/details/{bookingId}", produces = MediaType.APPLICATION_JSON_VALUE)
		public CancelDTO getCancelDetails(@PathVariable Integer bookingId) {
			return cancelService.getCancelDetails(bookingId);
			
		}
		
		


	
	
	}


	

	


