package com.CN.Gym.service;


import com.CN.Gym.dto.GymDto;
import com.CN.Gym.exception.GymNotFoundException;
import com.CN.Gym.exception.UserNotFoundException;
import com.CN.Gym.model.Gym;
import com.CN.Gym.model.User;
import com.CN.Gym.repository.GymRepository;
import com.CN.Gym.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GymService {

    /*
        This is the service class for Gym, you need to complete the class by doing the following:
        a. Use appropriate annotations.
        b. Complete the methods given below.
        c. Autowire the necessary dependencies.
     */
	@Autowired
	GymRepository gymRepository;
	
	@Autowired
	UserRepository userRepository;

	
    public List<Gym> getAllGyms() {
    	return gymRepository.findAll();
    }

    public Gym getGymById(long id) {
    	Gym gym = gymRepository.findById(id).orElse(null);
    	if(gym == null) {
    		throw new GymNotFoundException("the gym cannot be found");
    	}
    	return gym;
    }

    public void deleteGymById(long id) {
    	 Gym gym = gymRepository.findById(id)
                 .orElseThrow(() -> new GymNotFoundException("the gym cannot be found") );
    	 
    	 gym.getMembers().forEach(user -> user.setGym(null));
    	 userRepository.saveAll(gym.getMembers());
    	 gymRepository.deleteById(id);
    }

    public void updateGym(GymDto gymDto, Long id) {
    	Gym gym = gymRepository.findById(id).orElse(null);
    	if(gym == null) {
    		throw new GymNotFoundException("the gym cannot be found");
    	}
    	gym.setAddress(gymDto.getAddress());
    	gym.setContactNo(gymDto.getContactNo());
    	gym.setFacilities(gymDto.getFacilities());
    	gym.setMembershipPlans(gymDto.getMembershipPlans());
    	gym.setName(gymDto.getName());
    	gym.setMembers(gymDto.getMembers());
    	
    	gymRepository.save(gym);
    }

    public void createGym(GymDto gymDto) {
    	Gym gym = new Gym();
    	gym.setAddress(gymDto.getAddress());
    	gym.setContactNo(gymDto.getContactNo());
    	gym.setFacilities(gymDto.getFacilities());
    	gym.setMembershipPlans(gymDto.getMembershipPlans());
    	gym.setName(gymDto.getName());
    	if(gymDto.getMembers() != null) {
    		gym.setMembers(gymDto.getMembers());
    		userRepository.saveAll(gymDto.getMembers());
    	}
    	gymRepository.save(gym);
    }

    public void addMember(Long userId, Long gymId) {
    	User user = userRepository.findById(userId).orElse(null);
    	if(user == null) {
    		throw new UserNotFoundException("user not found");
    	}
    	Gym gym = gymRepository.findById(gymId).orElse(null);
    	if(gym == null) {
    		throw new GymNotFoundException("gym not found");
    	}
    	
    	List<User> users = gym.getMembers();
    	if(users == null) {
    		users = new ArrayList<>();
    	}
    	users.add(user);
    	gym.setMembers(users);
    	user.setGym(gym);
    	gymRepository.save(gym);
    	userRepository.save(user);
    }

    public void deleteMember(Long userId, Long gymId) {
    	User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("Invalid user Id:" + userId));
        Gym gym = gymRepository.findById(gymId)
                .orElseThrow(() -> new GymNotFoundException("Invalid gym Id:" + gymId));


		if(gym.getMembers().contains(user)){
			user.setGym(null);
			gym.getMembers().remove(user);
			gymRepository.save(gym);
			userRepository.save(user);
		}
        
//        if (user.getGym() != null && user.getGym().getId().equals(gymId)) {
//            // If the user is indeed part of this gym, remove the association
//            user.setGym(null); // Remove the association from the user's side
//            gym.getMembers().removeIf(member -> member.getId().equals(userId)); // Remove the user from the gym's member list
//            gymRepository.save(gym);
//            userRepository.deleteById(userId);
//            // Note: Depending on the cascade settings and JPA provider behavior, saving the gym might not be necessary.
//        } else {
//            throw new IllegalStateException("User is not a member of this gym.");
//
//    	}
    	
    	
    	
    	
    }
}
