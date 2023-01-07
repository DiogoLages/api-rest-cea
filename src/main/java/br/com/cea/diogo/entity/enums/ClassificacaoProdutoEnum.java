package br.com.cea.diogo.entity.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import br.com.cea.diogo.service.exception.ResourceNotFoundException;

public enum ClassificacaoProdutoEnum {

	NAO_CLASSIFICADO("#", "Não classificado"), 
	ALTA_ROTATIVIDADE("A", "Alta rotatividade"),
	MEDIA_ROTATIVIDADE("B", "Média rotatividade"), 
	BAIXA_ROTATIVIDADE("C", "Baixa rotatividade");

	private String cls;
	private String descricao;

	private ClassificacaoProdutoEnum(String cls, String descricao) {
		this.cls = cls;
		this.descricao = descricao;
	}

	@JsonValue
	public String getCls() {
		return this.cls;
	}

	public String getDescricao() {
		return this.descricao;
	}
    
	@JsonCreator
	public static ClassificacaoProdutoEnum toEnum(String value) {
		for (ClassificacaoProdutoEnum cls : ClassificacaoProdutoEnum.values()) {
			if (value.toUpperCase().equals(cls.getCls())) {
				return cls;
			}
		}
		throw new ResourceNotFoundException("Classificação inválida! Informe A, B, C, ou # ");
	}

}
