package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Jungah;
import com.example.demo.service.IJungahService;

@Controller
public class JungahController {
	@Autowired
	IJungahService jungahService;
	
	
	  @GetMapping("/home")
	  public String home(Model model) { 
		  //데이터 로드 및 모델 설정
	  return "/home"; }
	 
	
	 @RequestMapping("/")
	   public String selectAllJungah(Model model) {
	       List<Jungah> jungah = jungahService.selectAllJungah();
	       model.addAttribute("Jungah", jungah);
	       return "/home";
	   }

	  @GetMapping("/insert")
	   public String insertJungah() {
	       return "/jungah/insert";
	   }
	  
	  @PostMapping("jungah/insert")
	   public String insertJungah(@RequestParam String title, @RequestParam String content) {
	       jungahService.insertJungah(title, content);
	       return "redirect:/";
	   }
	  
	  @GetMapping("/view")
	  public String view(@RequestParam("no") int no,Model model) {
		  Jungah jungah = (Jungah) jungahService.view(no); 
		  System.out.println(jungah.getTitle());
		  model.addAttribute("jungah", jungah );
	  return "jungah/view";
	  }
	  
	  @GetMapping("/update/{no}")
	    public String updateJungah(@PathVariable("no") int no, Model model) {
	        Jungah jungah = (Jungah) jungahService.view(no);
	        model.addAttribute("jungah", jungah);
	        return "jungah/update";
	    }

	    @PostMapping("/update")
	    public String updateJungah(@RequestParam("no") int no, @RequestParam("title") String title, @RequestParam("content") String content) {
	        System.out.println("kjjjjj");
	        jungahService.updateJungah(no, title, content);
	        return "redirect:/";
	    }
	    
	    @RequestMapping(value="/delete/{no}", method=RequestMethod.GET)
	    public String delete(@PathVariable("no") int no, Model model) {
	        jungahService.delete(no);
System.out.println("테스트"+no);
	        return "redirect:/";
	    }
}