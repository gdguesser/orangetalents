package com.orangetalents.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orangetalents.restapi.model.Endereco;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Long>{
}
