package com.project.convention.service;

import java.util.List;

import org.springframework.data.domain.PageRequest;

import com.project.convention.model.Convention;


public interface IConventionService {
	
	public void ajouterConvention(Convention convention);
	public void supprimerConvention(int id);
	public Convention mettreAJourConvention(Convention convention);
	public List<Convention> getAllConvention();
	public Convention getConventionById(int id);
}
