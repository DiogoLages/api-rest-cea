package br.com.cea.diogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.cea.diogo.entity.Departamento;
import br.com.cea.diogo.entity.Produto;
import br.com.cea.diogo.entity.enums.ClassificacaoProdutoEnum;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

	Long countByDepartamentoAndClassificacao(Departamento departamento, ClassificacaoProdutoEnum cls);

	@Query("SELECT COUNT(p.id) FROM Produto p WHERE p.departamento.id = :idDep AND p.classificacao = :cls")
	Long countProductsByCodeDepartamentAndClassification(@Param("idDep") Long idDep, @Param("cls") ClassificacaoProdutoEnum cls);

}
