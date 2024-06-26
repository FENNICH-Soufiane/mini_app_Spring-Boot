package com.fstg.mediatech.models;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="factures")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FactureEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1855233643188554749L;
	
	
	@Id
	private Integer id;
	@Column(nullable = false)
	private String ref;
	@Column(nullable = false, name= "date_creation_facture")
	private Date date;
	
	@ManyToOne
	private ClientEntity client;
	
	@OneToMany(mappedBy = "facture", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LigneFactureEntity> factureEntities;
	
}
