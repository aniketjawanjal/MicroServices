package net.java.orgnizationservice.orgnizationservice.repo;



import org.springframework.data.jpa.repository.JpaRepository;


import net.java.orgnizationservice.orgnizationservice.entity.Orgnization;

public interface OrganizationRepo extends JpaRepository<Orgnization, Long>{
		
	Orgnization findByorganizationCode(String departmentname);
	
}
