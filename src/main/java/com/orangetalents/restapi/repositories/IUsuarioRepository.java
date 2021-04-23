package com.orangetalents.restapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.orangetalents.restapi.models.Usuario;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long>{

}
