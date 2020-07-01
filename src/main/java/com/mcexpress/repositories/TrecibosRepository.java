package com.mcexpress.repositories;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mcexpress.domain.Trecibos;


//anotação para classe e transformá-la em uma interface e herança de JPAREpository do Spring
@Repository
public interface TrecibosRepository extends JpaRepository<Trecibos, Integer>  {
	
	@Query("SELECT obj FROM Trecibos obj "
			+ "WHERE obj.nrorecibo =:cod ")
			Optional<Trecibos> findId(
			@Param("cod") Integer cod);
		
	//=================================Recibos por id do mensageiro com paginação
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecibos obj "
			+ "WHERE obj.codmensageiro =:cod ")
			Page<Trecibos> findAllByMensRecibo(
			@Param("cod") Integer cod, Pageable pageRequest);
	
	//==================================Recibos por id do mensageiro entre datas
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecibos obj "
			+ "WHERE obj.codmensageiro =:cod "
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate "
			+ "AND obj.impresso = 'S' ")
		List<Trecibos> findByMensageiroRecibo( 
			@Param("cod") Integer cod,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	//================================== Recibos por id do mensageiro entre datas (recebido) =================
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecibos obj "
			+ "WHERE obj.codmensageiro =:cod "
			+ "AND obj.statusrec = 'B' "
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate ")
			Page<Trecibos> findRecibosRecebidos( 
			@Param("cod") Integer cod,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,
			Pageable pageRequest);
	
	//================================== Recibos por id do mensageiro entre datas (Em abertdo) =================
		@Transactional(readOnly = true)
		@Query("SELECT obj FROM Trecibos obj "
				+ "WHERE obj.codmensageiro =:cod "
				+ "AND obj.statusrec = 'G' "
				+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate ")
			Page<Trecibos> findRecibosAbertos( 
			@Param("cod") Integer cod,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate,
			Pageable pageRequest);
	

	//================================== Recibos por id do mensageiro entre datas tabela do app mobile =================
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecibos obj "
			+ "WHERE obj.codmensageiro =:cod "
			+ "AND obj.statusrec = 'G' "
			+ "AND obj.entregaweb IS NULL "
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate ")
		List<Trecibos> findRecibosApp( 
			@Param("cod") Integer cod,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	
	//==================================Lista Recibos por mensageiro Web ***
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecibos obj "
			+ "WHERE obj.codmensageiro =:cod "
			+ "AND obj.statusrec =:status "
			//+ "AND obj.tconbribuintes.CIDADESECUNDARIO =:cidade "
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate ")
			List<Trecibos> findRecibosPorMensageiro(
			@Param("cod") Integer cod,
			@Param("status") String status,
			//@Param("cidade") String cidade,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	//==================================Lista Recibos Reimpressos ***
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecibos obj "
			+ "WHERE obj.via = 2 "
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate ")
			List<Trecibos> findRecibosReimpressos(
				@Param("startDate") Date startDate,
				@Param("endDate") Date endDate);
	
	
	//================================== Atualiza recibos por id do mensageiro entre datas tabela do app mobile (Baixar) =================
	@Transactional
	@Modifying
	@Query("UPDATE Trecibos obj SET obj.entregaweb = 'S' "
			+ "WHERE obj.codmensageiro =:cod "
			+ "AND obj.statusrec = 'G' "
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate ")
		void updateRecibosApp( 
			@Param("cod") Integer cod,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	//================================== Lista recebido por mensageiro entre datas *** ====================
	@Transactional(readOnly = true)
	@Query("SELECT obj.codmensageiro, COUNT(obj.nrorecibo), SUM(obj.valorgerado) FROM Trecibos obj "
			+ "WHERE obj.statusrec = 'B' "
			+ "AND obj.impresso = 'S' "
			+ "AND obj.dtbaixa BETWEEN :startDate AND :endDate "
			+ "GROUP BY obj.codmensageiro "
			+ "HAVING obj.codmensageiro NOT IN (709,746,755,822,764,147,226,606,353,607,298,164) "
			+ "ORDER BY COUNT(obj.nrorecibo) DESC")
		List<String> findRecebidoMensageiro(
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	//================================== Lista relatorio diario *** ##########
	@Transactional(readOnly = true)
	@Query("SELECT COUNT(obj.nrorecibo), SUM(obj.valorgerado) "
			+ "FROM Trecibos obj "
			+ "WHERE obj.codmensageiro =:cod "
			+ "AND EXTRACT(month from dtbaixa) =:mes "
			+ "AND EXTRACT(year from dtbaixa) =:ano "
			//+ "HAVING obj.codmensageiro NOT IN (709,746,755,822,764,147,226,606,353,607,298,164) "
			+ "GROUP BY EXTRACT(month from dtbaixa), EXTRACT(year from dtbaixa)")
		List<String> findRelatorioDiario(
			@Param("cod") Integer cod,
			@Param("mes") Integer mes,
			@Param("ano") Integer ano);
	
	
	//================================== Lista de recibos entre datas a reprocessar =================
	@Transactional(readOnly = true)
	@Query("SELECT obj.codmensageiro, COUNT(obj.nrorecibo), SUM(obj.valorgerado) FROM Trecibos obj "
			+ "WHERE obj.statusrec = 'G' "
			+ "AND obj.entregaweb IS NULL "
			//+ "AND obj.codmensageiro NOT IN (709,746,755,822,764,147,226,606,353,607,298,164) " // Esses códigos não são mensageiros ativamente
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate "
			+ "GROUP BY obj.codmensageiro "
			+ "HAVING obj.codmensageiro NOT IN (709,746,755,822,764,147,226,606,353,607,298,164) "
			+ "ORDER BY COUNT(obj.nrorecibo) DESC")
		List<String> findRecibosReprocesssar( 
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	
	//==================================Resumo por id do mensageiro entre datas========================================
	@Transactional(readOnly = true)
	@Query("SELECT obj.statusrec, COUNT(obj.nrorecibo), SUM(obj.valorgerado) "
			+ "FROM Trecibos obj "
			+ "WHERE obj.codmensageiro =:cod "
			+ "AND obj.statusrec IN ('B','C','D','G') "
			+ "AND obj.tconbribuintes.CIDADESECUNDARIO != '' "
			+ "AND obj.tconbribuintes.CIDADESECUNDARIO != 'SEM CADASTRO' "
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate "
			+ "GROUP BY obj.statusrec ")
		List<String> ResumoRecibosMensageiroData( 
			@Param("cod") Integer cod,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
			
	
	//==================================Resumo do mensageiro por cidade
	@Transactional(readOnly = true)
	@Query("SELECT obj.tconbribuintes.CIDADESECUNDARIO, COUNT(obj.codmensageiro), SUM(obj.valorgerado), obj.statusrec "
			+ "FROM Trecibos obj "
			+ "WHERE obj.codmensageiro =:cod "
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate "
			+ "AND obj.statusrec IN ('B','C','D','G') "
			+ "GROUP BY obj.tconbribuintes.CIDADESECUNDARIO, obj.statusrec "
			+ "HAVING obj.tconbribuintes.CIDADESECUNDARIO != '' "
			+ "AND obj.tconbribuintes.CIDADESECUNDARIO != 'SEM CADASTRO' "
			+ "ORDER BY obj.tconbribuintes.CIDADESECUNDARIO ")
		List<String> recibosMensageiroPorCidade( 
			@Param("cod") Integer cod,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);

	//====================================Recibos por id do contribuinte ativo entre datas
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecibos obj "
			+ "WHERE obj.tconbribuintes.codcontrib =:cod "
			+ "AND obj.dtcobranca BETWEEN :startDate AND :endDate "
			+ "AND obj.tconbribuintes.STATUS.CODSTATUS = 1 ")
			List<Trecibos> buscarRecibosContribData(
			@Param("cod") Integer cod,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);
	
	// ====================================Recibos por id do contribuinte ativo TOP 25
	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Trecibos obj "
			+ "WHERE obj.tconbribuintes.codcontrib =:cod "
			+ "AND obj.dtcobranca <= :dtAtual "
			+ "ORDER BY obj.nrorecibo DESC")
	Page<Trecibos> buscarRecibosContrib(
			@Param("cod") Integer cod, @Param("dtAtual") Date dtAtual, Pageable pageRequest);
	
			
	
	
	//Sql nativo @Query(value = "select * from pergunta where ativo = 1", nativeQuery = true)
	/*
	@Transactional(readOnly = true)
	@Query("SELECT count(obj) FROM Trecibos obj WHERE obj.codmensageiro =:cod AND obj.dtcobranca BETWEEN :startDate AND :endDate AND obj.statusrec = 'C'")
			Integer findByMensageiroRecibo(
			@Param("cod") Integer cod,
			@Param("startDate") Date startDate,
			@Param("endDate") Date endDate);*/
	
	
	/*
	@Transactional(readOnly = true) // Não necessita ser envolvida como transação no banco de dados, diminui o gerenciamento de loking
	Trecibos findBycodmensageiro(String codMensageiro);
		*/
}






