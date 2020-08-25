
package com.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PREMIUM_ESTIMATE_MOTOR")
public class Premium {

	@Id
	@SequenceGenerator(name = "premium_id", initialValue = 1, allocationSize = 1)
	@GeneratedValue
	private int id;

	@Column(name = "type")
	private String type;

	@Column(name = "age")
	private int age;

	@Column(name = "model")
	private String model;

	@Column(name = "amount")
	private double amount;

	@Column(name = "depreciationRate")
	private int depreciationRate;
    
    @Column(name = "duration")
    private int duration;
    
    @Column(name = "loss_suffered")
    private double lossSuffered;
    
    @Column(name = "total_cost_of_vehicle")
    private double totalCostOfVehicle;
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getDepreciationRate() {
		return depreciationRate;
	}

	public void setDepreciationRate(int depreciationRate) {
		this.depreciationRate = depreciationRate;
	}
    
    public void setDuration(int duration) {
		this.duration = duration;
	}
    
    public int getDuration() {
		return duration;
	}

	public double getLossSuffered() {
		return lossSuffered;
	}
    
    public void setLossSuffered(double lossSuffered) {
		this.lossSuffered = lossSuffered;
	}
    
    public double getTotalCostOfVehicle() {
		return totalCostOfVehicle;
	}

	public void setTotalCostOfVehicle(double totalCostOfVehicle) {
		this.totalCostOfVehicle = totalCostOfVehicle;
	}

}
