package com.grp3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.grp3.services.IStorageService;

@Component
public class StorageServiceInitialiser implements CommandLineRunner {
	
	@Autowired
	private IStorageService _storageService;

	@Override
	public void run(String... arg0) throws Exception {
        _storageService.deleteAll();
        _storageService.init();
		
	}

}
