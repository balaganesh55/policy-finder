package com.policy_springboot_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.policy_springboot_application.dto.PolicyDTO;
import com.policy_springboot_application.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/policies")
public class PolicyController {
	// write your logic here
	@Value("${profile.validate.data}")
	private String name;
	@Autowired
	private PolicyService policyService;

	@PostMapping("/")
	public PolicyDTO makePolicy(@Valid @RequestBody PolicyDTO policyDTO) {
		PolicyDTO PolicyDTO2 = policyService.makePolicy(policyDTO);
		return PolicyDTO2;
	}

	@PutMapping("/{PolicyId}")
	public PolicyDTO updatePolicyDTO(@PathVariable Long PolicyId,
			@Valid @RequestBody PolicyDTO PolicyDTO) {
		PolicyDTO PolicyDTO2 = policyService.updatePolicy(PolicyId, PolicyDTO);

		return PolicyDTO2;
	}

	@DeleteMapping("/{PolicyId}")
	public boolean deletePolicy(@PathVariable Long PolicyId) {
		return policyService.deletePolicy(PolicyId);

	}

	@GetMapping("/{PolicyId}")
	public PolicyDTO getbyId(@PathVariable Long PolicyId) {
		PolicyDTO PolicyDTO2 = policyService.getPolicyById(PolicyId);
		return PolicyDTO2;
	}

	@GetMapping
	public List<PolicyDTO> getbyprojectid() {
		List<PolicyDTO> PolicyDTOs = policyService.getAllPolicies();
		return PolicyDTOs;
	}

	@GetMapping("/searchByName")
	public List<PolicyDTO> getByPolicyName(@RequestParam String PolicyName) {
		List<PolicyDTO> PolicyDTOs = policyService.searchPoliciesByName(PolicyName);
		return PolicyDTOs;
	}
	@GetMapping("/searchByCoverage")
	public List<PolicyDTO> getByCoverage(@RequestParam String coverage) {
		List<PolicyDTO> PolicyDTOs = policyService.searchPoliciesByCoverage(coverage);
		return PolicyDTOs;
	}

	@GetMapping("/profile")
	public String getProfile() {
		return this.name;
	}

}