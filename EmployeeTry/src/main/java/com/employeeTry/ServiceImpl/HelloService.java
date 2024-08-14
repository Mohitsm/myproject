package com.employeeTry.ServiceImpl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeTry.Repo.HelloRepo;
import com.employeeTry.entity.Hello;

@Service
public class HelloService {
	 @Autowired
	    private HelloRepo helloRepo;

	    public List<Hello> getAllHelloRecords() {
	        return helloRepo.findAll();
	    }

	    public Hello getHelloById(Long id) {
	        return helloRepo.findById(id).orElse(null);
	    }

	    public Hello punchIn(Hello Hello) {
	        return helloRepo.save(Hello);
	    }

	    public Hello punchOut(Long id, LocalDateTime punchOutTime) {
	        Hello Hello = helloRepo.findById(id).orElse(null);
	        if (Hello != null) {
	            Hello.setPunchOut(punchOutTime);
	            helloRepo.save(Hello);
	        }
	        return Hello;
	    }
	    
		public long getPresentEmployees() {
			// TODO Auto-generated method stub
			return this.helloRepo.countPresentEmployees();
		}

		
		public long getAbsentEmployees() {
			// TODO Auto-generated method stub
			return this.helloRepo.countAbsentEmployees();
		}

		
		public long getLateEmployees() {
			// TODO Auto-generated method stub
			return this.helloRepo.countAbsentEmployees();
		}

	
		public long getHalfDayEmployees() {
			// TODO Auto-generated method stub
			return this.helloRepo.countHalfDayEmployees();
		}


}
