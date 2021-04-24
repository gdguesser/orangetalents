package com.orangetalents.restapi.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.orangetalents.restapi.model.Usuario;
import com.orangetalents.restapi.repository.IUsuarioRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/api/v1/usuarios")
@Api(value = "Usuario")
public class UsuarioController {

	@Autowired
    private IUsuarioRepository usuarioRepository;

	@PostMapping()
	@ApiOperation(value = "Cadastra um usuário")
    public ResponseEntity<Usuario> criarUsuario(@Valid @RequestBody Usuario usuario) {

		usuarioRepository.save(usuario);

		return new ResponseEntity<Usuario>(usuario, HttpStatus.CREATED);
    }
	
	@GetMapping(path = "{idUsuario}")
	@ApiOperation(value = "Busca um usuário e seus endereços")
	public Usuario buscaUsuarioPorId(@PathVariable("idUsuario") Long idUsuario) {

		return usuarioRepository.findAll().stream().filter(usuario -> idUsuario.equals(usuario.getId()))
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuário com id " + idUsuario + " não encontrado"));
	}
}