package com.sbipblockchain.springdemo.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;


@RestController
public class DemoRestController {


	/*@GetMapping("/send")
	public String send() {

	}*/

	@PostMapping("/send")
	@ResponseBody
	public Request createRequest(@RequestBody Request req){
		return req;
	}

	@PostMapping("/get-balance")
	@ResponseBody
	public Request getRequest(@RequestBody Request req){
		return  req;
	}



}
