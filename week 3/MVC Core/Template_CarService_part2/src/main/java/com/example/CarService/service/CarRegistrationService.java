package com.example.CarService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CarService.domain.Vehicle;

/**

 1. Implement the interface Registration and Override the method registerCar() and getNewCar() in CarRegistrationService.
 2. Also,autowire car of type Vehicle and use it in method registerCar() and getNewCar().

**/

@Service
public class CarRegistrationService implements Registration {

	@Autowired
	Vehicle car;
	
	@Override
	public Boolean registerCar(String vehicleNo, String vehicleName, String CarDetails, String CarWork) {
		if(vehicleNo == null || vehicleName == null || CarDetails == null || CarWork == null)return false;
		
		if(vehicleNo.length() == 0 || vehicleName.length() == 0 || CarDetails.length() == 0 || CarWork.length() == 0)return false;
		car.createVehicle(vehicleNo, vehicleName, CarDetails, CarWork);
		car.saveVehicleDetails();
		return true;
	}

	@Override
	public Vehicle getNewCar() {
		return car;
	}

}
