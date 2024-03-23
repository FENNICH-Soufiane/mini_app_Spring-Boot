package com.fstg.mediatech.models;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "produits")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProduitEntity implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7942433389457075472L;
	
	@Id
	private Integer id;
	
	@Column(nullable = false)
	private String libelle;
	
	@Column(nullable = false)
	private String ref;
	
	@Column(nullable = false)
	private BigDecimal prix;
	
	@Column(nullable = false)
	private double quantity_stock;
	
	@OneToMany(mappedBy = "produit", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<LigneFactureEntity> factureEntities;
	
}
