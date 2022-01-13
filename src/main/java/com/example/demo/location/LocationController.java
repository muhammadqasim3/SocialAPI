package com.example.demo.location;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@GetMapping("locations/{id}")
	public Location getLocation(@PathVariable String id) {
		return locationService.getLocation(id);
	}
	
	@RequestMapping(value = "locations",method=RequestMethod.POST)
	public void addLocation(@RequestBody Location location) {
		locationService.addLocation(location);
	}

}
