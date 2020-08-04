package com.project.convention.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.project.convention.model.Convention;


public interface IConventionDAO extends PagingAndSortingRepository<Convention, Integer>, CrudRepository<Convention, Integer> {

}
