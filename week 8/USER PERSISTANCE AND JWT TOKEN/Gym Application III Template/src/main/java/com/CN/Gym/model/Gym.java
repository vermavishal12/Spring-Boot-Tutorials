package com.CN.Gym.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


/*
    This is the entity class, complete this class by doing the following:
    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="gym")
public class Gym {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
    private Long id;
	
	@Column
    private String name;
	
	@Column
    private String address;
	
	@Column
    private Long contactNo;
	
	@Column
    private String membershipPlans;
	
	@Column
    private String facilities;
	
	@OneToMany(mappedBy="gym", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	@ToString.Exclude
	private List<User> members = new ArrayList<>();

}
