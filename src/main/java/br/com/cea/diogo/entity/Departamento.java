package br.com.cea.diogo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "COD_DEPARTAMENTO", nullable = false)
	@EqualsAndHashCode.Include
	private Long id;
	
	@Column(name = "NOM_DEPARTAMENTO", length = 255)
	private String nome;
	
	@JsonIgnore
	@OneToMany(mappedBy="departamento")
	private List<Produto> produtos;
	
	public Departamento(Long id) {
		this.id = id;
	}

}
