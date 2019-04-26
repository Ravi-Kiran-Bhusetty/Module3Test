package com.cg.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.dao.TDSDao;
import com.cg.model.TDSMaster;

@Component("tdsserviceimpl")
@Service
@Transactional
public class TDSServiceImpl implements TDSService{

	@Autowired
	TDSDao tdsdaoimpl;
	@Override
	public TDSMaster getById(int id) {
		return tdsdaoimpl.getById(id);
	}

}
