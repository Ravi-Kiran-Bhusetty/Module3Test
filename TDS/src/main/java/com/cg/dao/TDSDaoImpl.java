package com.cg.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.cg.model.TDSMaster;

@Component("tdsdaoimpl")
@Repository
@ComponentScan("com")
public class TDSDaoImpl implements TDSDao {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public TDSMaster getById(int id) {
		TDSMaster tDSMaster = entityManager.find(TDSMaster.class, id);
		if (tDSMaster != null)
			return tDSMaster;
		else
			return null;
	}

}
