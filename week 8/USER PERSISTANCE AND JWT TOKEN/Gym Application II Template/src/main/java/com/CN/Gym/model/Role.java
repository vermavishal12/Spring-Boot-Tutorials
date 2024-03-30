package com.CN.Gym.model;



/*
    This is the entity class, complete this class by doing the following:
    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "role")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
    private Long id;
	
	@Column
    private String roleName; //Customer, Trainer and Admin

}
