package com.cn.homeControlSystem.actuator;

import java.util.HashMap;
import java.util.Map;

//add required annotations for this custom actuator endpoinr class.
public class Actuator {

    //Autowire the SmartDeviceRepository object.

    Map<String, String> data = new HashMap<>();

/**
 * Complete the method body of by writing the necessary logic to fetch a map of all smart devices with their status in a key-value pair.
 * Add required annotation.
 */

    public Map getDeviceStatus() {
        return data;
    }
}
