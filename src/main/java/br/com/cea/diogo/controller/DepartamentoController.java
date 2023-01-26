package br.com.cea.diogo.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.cea.diogo.service.DepartamentoService;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value="/api/v1/departamentos")
public class DepartamentoController {
	
	public final DepartamentoService departamentoService;
	
	@Autowired
	public DepartamentoController(DepartamentoService departamentoService) {
		this.departamentoService = departamentoService;
	}

	@ApiOperation(value="Listar todos os departamentos")
	@GetMapping
	public ResponseEntity<?> findAllDepartments(){
		Map<String, Object> map = new LinkedHashMap<String, Object>();
		map.put("status", HttpStatus.OK.value());
		map.put("data", departamentoService.findAllDepartments());
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
}
