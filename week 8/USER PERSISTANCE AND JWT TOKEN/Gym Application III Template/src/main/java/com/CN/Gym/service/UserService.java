package com.CN.Gym.service;

import com.CN.Gym.dto.UserRequest;
import com.CN.Gym.dto.WorkoutDto;
import com.CN.Gym.exception.UserNotFoundException;
import com.CN.Gym.model.Role;
import com.CN.Gym.model.User;
import com.CN.Gym.model.Workout;
import com.CN.Gym.repository.UserRepository;
import com.CN.Gym.repository.WorkoutRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {

        /*
        This is the service class for User, you need to complete the class by doing the following:
        a. Use appropriate annotations.
        b. Complete the methods given below.
        c. Autowire the necessary dependencies.
     */


    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private WorkoutRepository workoutRepository;

    public List<User> getAllUsers() {
    	return userRepository.findAll();
    }

    public void createUser(UserRequest userRequest) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userRequest.getPassword());
//        User user = User.builder().email(userRequest.getEmail()).age(userRequest.getAge())
  //              .gender(userRequest.getGender()).password(encodedPassword)
    //            .build();
      
        User user = new User();
        user.setAge(userRequest.getAge());
        user.setEmail(userRequest.getEmail());
        user.setGender(userRequest.getGender());
        user.setPassword(encodedPassword);
        
        Role role = new Role();
        Set<Role> roles = new HashSet<>();
        if(userRequest.getUserType() != null) {
            if (userRequest.getUserType().equalsIgnoreCase("TRAINER")) {
                role.setRoleName("ROLE_TRAINER");
                roles.add(role);
                user.setRoles(roles);
            } else if (userRequest.getUserType().equalsIgnoreCase("ADMIN")) {
                role.setRoleName("ROLE_ADMIN");
                roles.add(role);
                user.setRoles(roles);
            } else {
                role.setRoleName("ROLE_CUSTOMER");
                roles.add(role);
                user.setRoles(roles);
            }
        }
        else {
            role.setRoleName("ROLE_CUSTOMER");
            roles.add(role);
            user.setRoles(roles);
        }
        userRepository.save(user);
    }

    public User getUserById(Long id) {
    	User user = userRepository.findById(id).orElse(null);
    	if(user == null) {
    		throw new UserNotFoundException("user not found");
    	}
    	return user;
    }

    public void updateUser(UserRequest userRequest, Long id) {
    	User user = userRepository.findById(id).orElse(null);
    	if(user == null) {
    		throw new UserNotFoundException("user not found");
    	}
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(userRequest.getPassword());
    	user.setAge(userRequest.getAge());
    	user.setEmail(userRequest.getEmail());
    	user.setGender(userRequest.getGender());
    	user.setPassword(encodedPassword);
    	
    	userRepository.save(user);
    }

    public void deleteUser(Long id) {
    	User user = userRepository.findById(id).orElse(null);
    	if(user == null) {
    		throw new UserNotFoundException("user not found");
    	}
    	userRepository.deleteById(id);
    }

    public void addWorkout(WorkoutDto workoutDto, Long userId) {
    	User user = userRepository.findById(userId).orElse(null);
    	if(user == null) {
    		throw new UserNotFoundException("user not found");
    	}
    	Workout workout = new Workout();
    	workout.setDescription(workoutDto.getDescription());
    	workout.setDifficultyLevel(workoutDto.getDifficultyLevel());
    	workout.setDuration(workoutDto.getDuration());
    	workout.setWorkoutName(workoutDto.getWorkoutName());
    	workout.setUser(user);
    	List<Workout> workouts = user.getWorkouts();
    	if(workouts == null) {
    		workouts = new ArrayList<> ();
    	}
    	workouts.add(workout);
    	user.setWorkouts(workouts);
    	
    	workoutRepository.save(workout);
    	userRepository.save(user);
    }
}
