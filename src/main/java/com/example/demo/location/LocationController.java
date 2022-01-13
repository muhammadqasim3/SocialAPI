package com.example.demo.location;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/locations")
	   public List<Location> index() 
	   {	
			return locationService.getAllLocations();
	   }		

}
