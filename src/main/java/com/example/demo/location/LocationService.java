package com.example.demo.location;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class LocationService {
		Location location1 = new Location("1", "Lagos");
		Location location2 = new Location("2", "Asaba");
		Location location3 = new Location("3", "Budapest");	
	
//		private List<Location> locations = Arrays.asList(location1, location2, location3);
		private List<Location> locations = new ArrayList<>(Arrays.asList(location1, location2, location3));
		
		public List<Location> getAllLocations() {
			return locations;
		}
			
		// Get location by Id
		public Location getLocation(String id) {
			Location location = locations.stream()
					.filter(t -> id.equals(t.getId()))
					.findFirst()
					.orElse(null);
			return location;
		} 
		
		// Add a location resource
		public void addLocation(Location location) {
			locations.add(location);
		}

		public void updateLocation(Location location, String id) {
			// Iteration on locations list to find out the requested resource before modification
			for(int i = 0; i < locations.size(); i++) {
				Location loc = locations.get(i);
				if(loc.getId().equals(id)) {
					locations.set(i, location);
				}
			}
		}

		public void deleteLocation(String id) {
			
		}
		
}
