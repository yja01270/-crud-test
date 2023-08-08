package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Jungah;

@Mapper
@Repository
public interface IJungahRepository {
	List<Jungah> selectAllJungah();
	Jungah view (@Param("no") int no);
	 void insertJungah(@Param("title") String title, @Param("content") String content);
	 void updateJungah(@Param("no") int no,@Param("title") String title, @Param("content") String content);
	 void delete(@Param("no") int no);

	

}
