package com.balloon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.balloon.Enums.Status;
import com.balloon.Exception.ResourceNotFoundException;
import com.balloon.model.Feature;
import com.balloon.repository.FeatureRepo;

public class FeatureController {

	@Autowired
	private FeatureRepo featureRepository;

	// get all features
	@GetMapping("/features")
	public List<Feature> getFeatures() {
		return featureRepository.findAll();

	}
	
	
	// Add Feature
		@PostMapping("/features")
		public Feature addFeature(@RequestBody Feature feature) {
			 return featureRepository.save(feature);

		}
		
	// get Feature by id
		@GetMapping("/features/{id}")
		public ResponseEntity<Feature> getFeature(@PathVariable Long id) {
			 Feature feature = featureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No feature found for id: "+ id));
			 return ResponseEntity.ok(feature);
		}
		
	// update Feature details
		@PutMapping("/features/{id}")
		public ResponseEntity<Feature> updateFeature(@PathVariable Long id, @RequestBody Feature featureDetails) {
			 Feature feature = featureRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No feature found for id: "+ id));
			 feature.setFeatureName(featureDetails.getFeatureName());
			 feature.setFeatureCharge(featureDetails.getFeatureCharge());
			 feature.setStatus(Status.ACTIVE);
			 
			 featureRepository.save(feature);
			 return ResponseEntity.ok(feature);
		}
		
	// delete Feature details
		@DeleteMapping("features/{id}")
		public ResponseEntity<Map<String, Boolean>> deleteFeature(@PathVariable Long id){
			 Feature feature = featureRepository.findById(id)
					 .orElseThrow(() -> new ResourceNotFoundException("No feature found for id: "+ id));
			 featureRepository.delete(feature);
			 Map<String, Boolean> response = new HashMap<>();
			 response.put("deleted", Boolean.TRUE);
			 return ResponseEntity.ok(response);
		}
	
}
