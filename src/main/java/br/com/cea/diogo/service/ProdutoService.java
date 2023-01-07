package br.com.cea.diogo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cea.diogo.entity.Departamento;
import br.com.cea.diogo.entity.Produto;
import br.com.cea.diogo.entity.enums.ClassificacaoProdutoEnum;
import br.com.cea.diogo.repository.ProdutoRepository;
import br.com.cea.diogo.service.exception.ResourceNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public Produto save(Produto produto) {
		
		if (Objects.isNull(produto.getNome()) || Objects.isNull(produto.getClassificacao())
				|| produto.getNome().trim().isEmpty()) {
			throw new ResourceNotFoundException("O atributo nome ou classificação não pode ser nulo ou vazio!");
		}
		
		if (Objects.isNull(produto.getDepartamento()) || Objects.isNull(produto.getDepartamento().getId())) {
			throw new ResourceNotFoundException("O Departamento não pode ser nulo ou vazio!");
		}
		
		return produtoRepository.save(produto);
	}
	
	public List<Produto> findAll(){
		
		List<Produto> productList = produtoRepository.findAll();
		
		if(productList.isEmpty()) {
			throw new ResourceNotFoundException("Nenhum registro encontrado!");
		}
		
		return productList;
	}

	public Map<String, Map<String, Long>> countProductsByClassificationDepartament(List<Long> ids) {
		Map<String, Map<String, Long>> mapRetorno = new HashMap<>();
	
		ids.stream().forEach((id) -> {
			for (Long codeDep : ids) {
				Map<String, Long> mapDep = new HashMap<>();
				Departamento departamento = new Departamento(codeDep);
				for (ClassificacaoProdutoEnum item : ClassificacaoProdutoEnum.values()) {
					mapDep.put(" Classificação: " + item.getCls() + ", quantidade de produtos ",
							produtoRepository.countByDepartamentoAndClassificacao(departamento, item));
					mapRetorno.put("Departamento: " + codeDep, mapDep);
				}
			}

		});
	
		return mapRetorno;
	}
	
}
