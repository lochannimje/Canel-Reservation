package com.group5.CancelBooking.Service;

import java.util.List;
import java.util.ArrayList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group5.CancelBooking.dto.CancelDTO;
//import com.group5.CancelBooking.dto.CancelDTO;
import com.group5.CancelBooking.entity.CancelEntity;
import com.group5.CancelBooking.repository.CancelRepository;



@Service
public class CancelService {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CancelRepository cancelRepo;

	public List<CancelDTO> getAlldetails() {
		// TODO Auto-generated method stub
		
			List<CancelEntity> cancel = cancelRepo.findAll();
			List<CancelDTO> cancelDTO = new ArrayList<>();

			for (CancelEntity cancelEntity : cancel) {
				CancelDTO cancelDTO1 = CancelDTO.valueOf(cancelEntity);
				cancelDTO.add(cancelDTO1);
			}

			logger.info(" details : {}", cancelDTO);
			return cancelDTO;
		
	}
	public  CancelDTO getCancelDetails(Integer bookingId) {
		// TODO Auto-generated method stub
		return CancelDTO.valueOf(cancelRepo.getOne(bookingId));	
	}
	public void addDetails(CancelDTO cancelDTO) {
		System.out.println("inside service");
		logger.info("details of booking {}", cancelDTO);
		CancelEntity order = cancelDTO.createEntity();
		System.out.println("inside service2");
		cancelRepo. save(order);
		
	}

		
	}
	
		
		
	
	
		
	



	
			
	
	
	
	
	
	


	