package com.CodingNinjas.TaxEase.model;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
    This is the entity class, complete this class by doing the following:

    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="taxrecord")
public class TaxRecord {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
    private Long id;
	
	@Column(name="username")
    private String userName;
	
	@Column(name="taxyear")
    private String taxYear;
	
	@Column(name="income")
    private int Income;
	
	@Column(name="deductions")
    private int deductions;
	
	
	@Column(name="is_filling_approved")
    private boolean isFilingApproved;

}
