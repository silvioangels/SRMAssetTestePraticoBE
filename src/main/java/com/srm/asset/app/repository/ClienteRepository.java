package com.srm.asset.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.srm.asset.app.entities.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

}
