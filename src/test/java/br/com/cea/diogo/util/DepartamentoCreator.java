package br.com.cea.diogo.util;

import java.util.ArrayList;
import java.util.List;

import br.com.cea.diogo.entity.Departamento;

public class DepartamentoCreator {

	public static List<Departamento> createValidListDepartamento() {
		List<Departamento> departamentos = new ArrayList<>();
		departamentos.add(Departamento.builder()
				.id(1L)
				.nome("Feminino")
				.build());
		
		departamentos.add(Departamento.builder()
				.id(2L)
				.nome("Masculino")
				.build());

		return departamentos;
	}

}
