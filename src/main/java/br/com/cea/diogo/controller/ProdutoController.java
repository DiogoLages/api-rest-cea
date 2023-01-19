package br.com.cea.diogo.controller;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cea.diogo.entity.Produto;
import br.com.cea.diogo.service.ProdutoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api//v1/produtos")
public class ProdutoController {

	private final ProdutoService produtoService;
	
	@Autowired
	public ProdutoController(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}

	@Transactional
	@ApiOperation(value="Cadastrar um novo produto")
	@PostMapping(path = "/salvarProdutos")
	public ResponseEntity<?> saveProduct(@RequestBody Produto produto) {
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		Produto produtoCreated = produtoService.save(produto);
		map.put("status", HttpStatus.CREATED.value());
		map.put("message", "O registro foi salvo com sucesso!");
		map.put("dateTime", LocalDateTime.now());
		map.put("data", produtoCreated);
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}
	
	@ApiOperation(value="Listar todos os produtos")
	@GetMapping
	public ResponseEntity<?> findAllProducts(){
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("status", HttpStatus.OK.value());
		map.put("data", produtoService.findAll());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@ApiOperation(value="Retorna a quantidade de produtos por departamento com classificação (A,B,C, ou #)")
	@GetMapping(value = "/departamento/{ids}")
	public ResponseEntity<?> countProductsByClassificationDepartament(@PathVariable("ids") List<Long> ids){
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("status", HttpStatus.OK.value());
		map.put("data", produtoService.countProductsByClassificationDepartament(ids));
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
}
