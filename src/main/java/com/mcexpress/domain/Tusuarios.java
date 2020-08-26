package com.mcexpress.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mcexpress.domain.enums.Perfil;

@Entity
public class Tusuarios implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer CODUSUARIO;
	private String login;
	@JsonIgnore
	private String SENHA;
	private Integer CODGRUPO;
	
	@OneToOne
	@JoinColumn(name = "CODFUNC")
	private Tfuncionarios FUNCIONARIO;
	
	private Date DTULTALTERACAO;
	private Integer CODAGENTE;
	@JsonIgnore
	private String SENHAJAVA;
	private String email;


	@OneToOne
	@JoinColumn(name = "CODGRUPO", insertable = false, updatable = false)
	private Tgrupos GRUPO;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "Tperfis")
	private Set<Integer> perfis = new HashSet<>();

	public Tusuarios() {
		addPerfil(Perfil.USUARIO);
	}

	public Tusuarios(Integer cODUSUARIO, String lOGIN, String sENHA, Integer cODGRUPO, Tgrupos gRUPO, Tfuncionarios fUNCIONARIO, 
			Date dTULTALTERACAO, Integer cODAGENTE, String sENHAJAVA, String eMAIL) {
		super();
		CODUSUARIO = cODUSUARIO;
		login = lOGIN;
		SENHA = sENHA;
		CODGRUPO = cODGRUPO;
		FUNCIONARIO = fUNCIONARIO;
		DTULTALTERACAO = dTULTALTERACAO;
		CODAGENTE = cODAGENTE;
		SENHAJAVA = sENHAJAVA;
		email = eMAIL;

		this.GRUPO = gRUPO;
	}

	public Integer getCODUSUARIO() {
		return CODUSUARIO;
	}

	public String getLogin() {
		return login;
	}

	public String getSENHA() {
		return SENHA;
	}

	public Date getDTULTALTERACAO() {
		return DTULTALTERACAO;
	}

	public Integer getCODAGENTE() {
		return CODAGENTE;
	}
	
	public String getEmail() {
		return email;
	}

	public String getSENHAJAVA() {
		return SENHAJAVA;
	}
	
	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}
	
	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	public Tfuncionarios getFUNCIONARIO() {
		return FUNCIONARIO;
	}

	public Integer getCODGRUPO() {
		return CODGRUPO;
	}

	public Tgrupos getGRUPO() {
		return GRUPO;
	}

	public void setCODUSUARIO(Integer cODUSUARIO) {
		CODUSUARIO = cODUSUARIO;
	}

	public void setLOGIN(String login) {
		this.login = login;
	}

	public void setSENHA(String sENHA) {
		SENHA = sENHA;
	}

	public void setDTULTALTERACAO(Date dTULTALTERACAO) {
		DTULTALTERACAO = dTULTALTERACAO;
	}

	public void setCODAGENTE(Integer cODAGENTE) {
		CODAGENTE = cODAGENTE;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public void setSENHAJAVA(String sENHAJAVA) {
		SENHAJAVA = sENHAJAVA;
	}

	public void setFUNCIONARIO(Tfuncionarios fUNCIONARIO) {
		FUNCIONARIO = fUNCIONARIO;
	}

	public void setCODGRUPO(Integer cODGRUPO) {
		CODGRUPO = cODGRUPO;
	}

	public void setGRUPO(Tgrupos gRUPO) {
		GRUPO = gRUPO;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CODUSUARIO == null) ? 0 : CODUSUARIO.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tusuarios other = (Tusuarios) obj;
		if (CODUSUARIO == null) {
			if (other.CODUSUARIO != null)
				return false;
		} else if (!CODUSUARIO.equals(other.CODUSUARIO))
			return false;
		return true;
	}

}
