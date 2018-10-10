package com.practice.sp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.practice.sp.dao.JapanDAO;
import com.practice.sp.vo.Japan;

@Controller
public class JapanController {
	@Autowired
	private JapanDAO jdao;
	
	@RequestMapping(value="/japan",method=RequestMethod.GET)
	public @ResponseBody List<Japan> japanList(@ModelAttribute Japan jp) {
		return jdao.getJapanList(jp);
	}
	
	@RequestMapping(value="/japan/{jpnum}",method=RequestMethod.GET)
	public @ResponseBody Japan japan(@PathVariable int jpnum) {
		return jdao.getjapan(jpnum);
	}
	
	@RequestMapping(value="/japan",method=RequestMethod.POST)
	public @ResponseBody String insertJapan(@RequestBody Japan jp) {
		return jdao.insertJapan(jp) + "";
	}
	
	@RequestMapping(value="/japan",method=RequestMethod.PUT)
	public @ResponseBody String updateJapan(@RequestBody Japan jp) {
		System.out.println(jp);
		return jdao.updateJapan(jp) + "";
	}
	
	@RequestMapping(value="/japan/{jpnum}",method=RequestMethod.DELETE)
	public @ResponseBody String deleteJapan(@PathVariable int jpnum) {
		return jdao.deleteJapan(jpnum) + "";
	}
}
