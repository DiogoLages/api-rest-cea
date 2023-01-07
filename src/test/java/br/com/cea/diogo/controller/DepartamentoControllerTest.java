package br.com.cea.diogo.controller;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.cea.diogo.entity.Departamento;
import br.com.cea.diogo.service.DepartamentoService;
import br.com.cea.diogo.util.DepartamentoCreator;

@ExtendWith(SpringExtension.class)
class DepartamentoControllerTest {
	
	@InjectMocks
	private DepartamentoController departamentoController;

	@Mock
	private DepartamentoService departamentoServiceMock;
	
	@BeforeEach
	void setup() throws Exception {
		List<Departamento> departamento = DepartamentoCreator.createValidListDepartamento();
		BDDMockito.when(departamentoServiceMock.findAllDepartments())
			.thenReturn(departamento);
	}
	
	@Test
	void findAll_ReturnsListOfDepartaments_WhenSuccessful() {
		
		List<Departamento> departamentos = (List<Departamento>) departamentoController.findAllDepartments();
		
		Assertions.assertThat(departamentos)
			.isNotNull()
			.isNotEmpty()
			.hasSize(1);
	}

}
