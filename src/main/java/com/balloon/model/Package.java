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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="package")
public class Package {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name="package_name")
	private String packageName;
	
	@Column(name="package_price")
	private int packagePrice;
	
	@ManyToMany
	@JoinTable(name = "package_features", joinColumns = @JoinColumn(name = "package_id"),
	inverseJoinColumns = @JoinColumn(name = "feature_id"))
    Set<Feature> features;
	
	@Enumerated(EnumType.STRING)
	@Column(name="status")
	private Status status;

	public Package() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPackageName() {
		return packageName;
	}

	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}

	public int getPackagePrice() {
		return packagePrice;
	}

	public void setPackagePrice(int packagePrice) {
		this.packagePrice = packagePrice;
	}

	public Set<Feature> getFeatures() {
		return features;
	}

	public void setFeatures(Set<Feature> features) {
		this.features = features;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Package [id=" + id + ", packageName=" + packageName + ", packagePrice=" + packagePrice + ", features="
				+ features + ", status=" + status + "]";
	}
	
	
	

	
}
