package com.orangetalents.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orangetalents.restapi.models.Endereco;

@Repository
public interface IEnderecoRepository extends JpaRepository<Endereco, Long>{
}
