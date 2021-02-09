package com.demo.data.store.repository;


import org.springframework.data.repository.CrudRepository;

import com.demo.data.store.entity.Task;

public interface StoreReposity extends CrudRepository<Task, String> {
	
	

}
