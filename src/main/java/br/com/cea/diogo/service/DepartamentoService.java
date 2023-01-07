package br.com.cea.diogo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cea.diogo.entity.Departamento;
import br.com.cea.diogo.repository.DepartamentoRepository;
import br.com.cea.diogo.service.exception.ResourceNotFoundException;

@Service
public class DepartamentoService {

	@Autowired
	private DepartamentoRepository departamentoRepository;
	
	public List<Departamento> findAllDepartments(){
		
		List<Departamento> departmentList = departamentoRepository.findAll();
		
		if(departmentList.isEmpty()) {
			throw new ResourceNotFoundException("Nenhum registro encontrado!");
		}
		
		return departmentList;
	}
	
}
