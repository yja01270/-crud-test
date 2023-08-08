package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Jungah;

public interface IJungahService {
	List<Jungah> selectAllJungah();
	Jungah view(int no);
	 void insertJungah(String title, String content);
	 void updateJungah(int no,String title, String content);
	 void delete(int no);

}
