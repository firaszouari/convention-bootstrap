package com.project.convention.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.project.convention.model.Convention;
import com.project.convention.repository.IConventionDAO;



@Service
public class ConventionService implements IConventionService {

	@Autowired
	IConventionDAO conventionDao;
	
	@Override
	public void ajouterConvention(Convention convention) {
		// TODO Auto-generated method stub
		conventionDao.save(convention);
	}

	@Override
	public void supprimerConvention(int id) {
		// TODO Auto-generated method stub
		conventionDao.deleteById(id);
	}

	@Override
	public Convention mettreAJourConvention(Convention convention) {
		// TODO Auto-generated method stub
		return conventionDao.save(convention);
	}

	@Override
	public List<Convention> getAllConvention() {
		// TODO Auto-generated method stub
		List<Convention> conventionList = new ArrayList<Convention>();
		conventionDao.findAll().forEach(conventionList::add);
		return conventionList;
	}

	@Override
	public Convention getConventionById(int id) {
		// TODO Auto-generated method stub
		Optional<Convention> lstConv = conventionDao.findById(id);
		if(lstConv.isPresent())
			return lstConv.get();
		return null;
	}
	
}
