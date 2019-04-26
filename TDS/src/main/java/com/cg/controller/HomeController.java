package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.exceptions.UserNotFoundException;
import com.cg.model.TDSMaster;
import com.cg.service.TDSService;

@RestController
@RequestMapping("/user/tds")
public class HomeController {

	@Autowired
	TDSService tdsserviceimpl;

	@GetMapping("/{id}")
	public ResponseEntity getById(@PathVariable int id) {
		TDSMaster tDSMaster = tdsserviceimpl.getById(id);
		if (tDSMaster != null) {
			return new ResponseEntity(tDSMaster, HttpStatus.OK);
		} else
			throw new UserNotFoundException("ID Not Found wrong ID : " + id);
	}
}
