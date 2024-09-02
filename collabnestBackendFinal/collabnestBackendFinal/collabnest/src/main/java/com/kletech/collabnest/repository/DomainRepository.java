package com.kletech.collabnest.repository;


import com.kletech.collabnest.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain,Long> {
}
