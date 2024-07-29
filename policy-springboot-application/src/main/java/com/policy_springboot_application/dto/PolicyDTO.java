package com.policy_springboot_application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PolicyDTO {

	private Long id;
	@NotBlank(message = "Name should not be null")
	private String name;
	@NotNull
	private Integer tenure;

	@NotNull(message = "Amount should not be null")
	private Double amount;

	@NotNull(message = "InterestRate should not br null")
	private Double interestRate;

	@NotBlank(message = "Not null")
	private String coverage;

	public PolicyDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PolicyDTO(Long id, String name, Integer tenure, Double amount, Double interestRate, String coverage) {
		super();
		this.id = id;
		this.name = name;
		this.tenure = tenure;
		this.amount = amount;
		this.interestRate = interestRate;
		this.coverage = coverage;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getTenure() {
		return tenure;
	}

	public void setTenure(Integer tenure) {
		this.tenure = tenure;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public String getCoverage() {
		return coverage;
	}

	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}

}