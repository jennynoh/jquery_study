package net.kdigital.ajaxTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.kdigital.ajaxTest.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
