package com.orangetalents.restapi.controllers;

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
import com.orangetalents.restapi.models.Endereco;
import com.orangetalents.restapi.repositories.IEnderecoRepository;
import com.orangetalents.restapi.services.CepService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v1/enderecos")
@Api(value = "Endereço")
public class EnderecoController {

	@Autowired
    private IEnderecoRepository enderecoRepository;
	
	@Autowired
    private CepService cepService;

	@PostMapping
	@ApiOperation(value = "Cadastra o endereço de determinado usuário")
	public ResponseEntity<Endereco> cadastraEndereco(@Valid @RequestBody Endereco endereco) {

		Endereco infosEndereco = cepService.buscaEnderecoPorCep(endereco.getCep());

		endereco.setBairro(infosEndereco.getBairro());
		endereco.setLocalidade(infosEndereco.getLocalidade());
		endereco.setUf(infosEndereco.getUf());
		endereco.setLogradouro(infosEndereco.getLogradouro());

		if (endereco.getComplemento() == null) {
			endereco.setComplemento(infosEndereco.getComplemento());
		}

		endereco.setUserId(endereco.getUserId());
		endereco.setNumero(endereco.getNumero());

		enderecoRepository.save(endereco);

		return new ResponseEntity<>(endereco, HttpStatus.CREATED);
	}
	
	@GetMapping("cep/{cep}")
    public ResponseEntity<Endereco> getCep(@PathVariable String cep) {

        Endereco endereco = cepService.buscaEnderecoPorCep(cep);

        return endereco != null ? ResponseEntity.ok().body(endereco) : ResponseEntity.notFound().build();
    }
}






