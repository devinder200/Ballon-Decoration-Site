package com.balloon.model;

import java.util.Set;

import com.balloon.Enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="feature")
public class Feature {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="feature_name")
	private String featureName;
	
	@Column(name="feature_charge")
	private int featureCharge;
	
	@ManyToMany(mappedBy = "features")
    Set<Package> packages;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;

	public Feature() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public int getFeatureCharge() {
		return featureCharge;
	}

	public void setFeatureCharge(int featureCharge) {
		this.featureCharge = featureCharge;
	}

	public Set<Package> getPackages() {
		return packages;
	}

	public void setPackages(Set<Package> packages) {
		this.packages = packages;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Feature [id=" + id + ", featureName=" + featureName + ", featureCharge=" + featureCharge + ", packages="
				+ packages + ", status=" + status + "]";
	}

	
}
