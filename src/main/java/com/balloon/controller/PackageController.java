package com.balloon.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balloon.Enums.Status;
import com.balloon.Exception.ResourceNotFoundException;
import com.balloon.model.Package;
import com.balloon.repository.PackageRepo;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class PackageController {

	@Autowired
	private PackageRepo packageRepository;

	// get all packages
	@GetMapping("/packages")
	public List<Package> getPackages() {
		return packageRepository.findAll();

	}
	
	
	// Add Package
		@PostMapping("/packages")
		public Package addPackage(@RequestBody Package packageType) {
			 return packageRepository.save(packageType);

		}
		
	// get Package by id
		@GetMapping("/packages/{id}")
		public ResponseEntity<Package> getPackage(@PathVariable Long id) {
			 Package packageType = packageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No packageType found for id: "+ id));
			 return ResponseEntity.ok(packageType);
		}
		
	// update Package details
		@PutMapping("/packages/{id}")
		public ResponseEntity<Package> updatePackage(@PathVariable Long id, @RequestBody Package packageDetails) {
			 Package packageType = packageRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("No packageType found for id: "+ id));
			 packageType.setPackageName(packageDetails.getPackageName());
			 packageType.setPackagePrice(packageDetails.getPackagePrice());
			 packageType.setFeatures(packageDetails.getFeatures());
			 packageType.setStatus(Status.ACTIVE);
			 
			 packageRepository.save(packageType);
			 return ResponseEntity.ok(packageType);
		}
		
	// delete Package details
		@DeleteMapping("packages/{id}")
		public ResponseEntity<Map<String, Boolean>> deletePackage(@PathVariable Long id){
			 Package packageType = packageRepository.findById(id)
					 .orElseThrow(() -> new ResourceNotFoundException("No packageType found for id: "+ id));
			 packageRepository.delete(packageType);
			 Map<String, Boolean> response = new HashMap<>();
			 response.put("deleted", Boolean.TRUE);
			 return ResponseEntity.ok(response);
		}
}
