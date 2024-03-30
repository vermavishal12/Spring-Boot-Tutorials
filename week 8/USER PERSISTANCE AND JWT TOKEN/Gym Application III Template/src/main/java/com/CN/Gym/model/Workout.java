package com.CN.Gym.model;


import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

/*
    This is the entity class, complete this class by doing the following:
    a. Add the required annotations for making this class an entity.
    b. Add the required lombok annotations for getter, setter and constructors
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="workout")
public class Workout {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
    private Long id;
	
	@Column
    private String workoutName;
	
	@Column
    private String description;
	
	@Column
    private String difficultyLevel;
	
	@Column
    private int duration;
	
	@ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    @ToString.Exclude
    private User user;

}
