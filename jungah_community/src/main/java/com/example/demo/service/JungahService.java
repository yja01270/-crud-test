package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.IJungahRepository;
import com.example.demo.model.Jungah;

@Service
public class JungahService implements IJungahService {
	
	@Autowired
	IJungahRepository jungahRepository;

	public List<Jungah> selectAllJungah() {
		return jungahRepository.selectAllJungah();
	}
	
	 @Override public Jungah view(int no) {
		 return jungahRepository.view(no);
		 }
	
	 @Override
	    public void insertJungah(String title, String content) {
	        jungahRepository.insertJungah(title, content);
	    }

	 @Override
	    public void updateJungah(int no, String title, String content) {
	        jungahRepository.updateJungah(no, title, content);
	    }
	    
	  @Override
	    public void delete(int no) {
	        jungahRepository.delete(no);
	    }
}
