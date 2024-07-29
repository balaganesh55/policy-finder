package com.policy_springboot_application.service;

import java.util.List;

import com.policy_springboot_application.dto.PolicyDTO;

public interface PolicyService {
	PolicyDTO makePolicy(PolicyDTO PolicyDTO);

	PolicyDTO updatePolicy(Long PolicyId, PolicyDTO PolicyDTO);

	boolean deletePolicy(Long PolicyId);

	PolicyDTO getPolicyById(Long PolicyId);

	List<PolicyDTO> getAllPolicies();

	List<PolicyDTO> searchPoliciesByName(String name);

	List<PolicyDTO> searchPoliciesByCoverage(String coverage);
}