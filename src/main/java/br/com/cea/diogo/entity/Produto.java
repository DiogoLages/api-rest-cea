package br.com.cea.diogo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.cea.diogo.entity.enums.ClassificacaoProdutoEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_PRODUTO", nullable = false)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "NOM_PRODUTO", nullable = false, length = 255)
	private String nome;
	
	@Column(name = "CLS_PRODUTO", nullable = false, length = 1)
	private ClassificacaoProdutoEnum classificacao;

	@ManyToOne
	@JoinColumn(name="COD_DEPARTAMENTO")
	private Departamento departamento;

}
