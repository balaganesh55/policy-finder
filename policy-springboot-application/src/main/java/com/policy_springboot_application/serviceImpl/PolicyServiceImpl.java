package com.policy_springboot_application.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.policy_springboot_application.Exception.ResourceNotFoundException;
import com.policy_springboot_application.dto.PolicyDTO;
import com.policy_springboot_application.entity.Policy;
import com.policy_springboot_application.repo.PolicyRepository;
import com.policy_springboot_application.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService {
	@Autowired
	private PolicyRepository repo;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public PolicyDTO makePolicy(PolicyDTO PolicyDTO) {
		// TODO Auto-generated method stub
		Policy policy=modelMapper.map(PolicyDTO, Policy.class);
		Policy policy1=repo.save(policy);
		
		return modelMapper.map(policy1, PolicyDTO.class);
	}

	@Override
	public PolicyDTO updatePolicy(Long PolicyId, PolicyDTO policyDTO) {
		// TODO Auto-generated method stub
		Optional<Policy> policy=repo.findById(PolicyId);
		Policy policyEntity=modelMapper.map(policyDTO, Policy.class);
		if(policy.isPresent()) {
			var policy1=policy.get();
			policy1.setAmount(policyEntity.getAmount());
			policy1.setCoverage(policyEntity.getCoverage());
			policy1.setId(policyEntity.getId());
			policy1.setInterestRate(policyEntity.getInterestRate());
			policy1.setName(policyEntity.getName());
			policy1.setTenure(policyEntity.getTenure());
			Policy policy2= repo.save(policy1);
			return modelMapper.map(policy2, PolicyDTO.class);
			
		}
		throw new ResourceNotFoundException("Policy by id not found");
	
	}

	@Override
	public boolean deletePolicy(Long PolicyId) {
		// TODO Auto-generated method stub
		Optional<Policy> policy=repo.findById(PolicyId);
		if(policy.isPresent()) {
			repo.delete(policy.get());
			return true;
		}
		throw new ResourceNotFoundException("Policy by id not found");
	

	}

	@Override
	public PolicyDTO getPolicyById(Long PolicyId) {
		// TODO Auto-generated method stub
		Optional<Policy> policy=repo.findById(PolicyId);
		if(policy.isPresent()) {
			return modelMapper.map(policy.get(), PolicyDTO.class);
		}
		throw new ResourceNotFoundException("Policy by id not found");
	}

	@Override
	public List<PolicyDTO> getAllPolicies() {
		// TODO Auto-generated method stub
		List<PolicyDTO> list=repo.findAll().stream().map(policy->modelMapper.map(policy, PolicyDTO.class)).toList();
		return list;
	}

	@Override
	public List<PolicyDTO> searchPoliciesByName(String name) {
		// TODO Auto-generated method stub
		List<PolicyDTO> list=repo.findByName(name).stream().map(policy->modelMapper.map(policy, PolicyDTO.class)).toList();
		return list;
	}

	@Override
	public List<PolicyDTO> searchPoliciesByCoverage(String coverage) {
		// TODO Auto-generated method stub
		List<PolicyDTO> list=repo.findByCoverage(coverage).stream().map(policy->modelMapper.map(policy, PolicyDTO.class)).toList();
		return list;
	}

	
}