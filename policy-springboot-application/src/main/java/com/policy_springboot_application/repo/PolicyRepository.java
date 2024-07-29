package com.policy_springboot_application.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.policy_springboot_application.entity.Policy;

public interface PolicyRepository extends JpaRepository<Policy, Long> {

	// write your code for method to find list of investments associated with a specific project ID,
	// and it must return data in list
	@Query("Select o from Policy o where o.name=:name")
	List<Policy> findByName(@Param("name") String name);
	

	
	// write your code for method to find list of investments made by an investor with the specified name,
	// and it must return data in list
	@Query("Select o from Policy o where o.coverage=:coverage")
	List<Policy> findByCoverage(@Param("coverage") String coverage);
	
}