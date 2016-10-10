package com.ironyard.util;

import com.ironyard.data.Employee;



import com.google.gson.Gson;


import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raul on 10/10/16.
 */
public class JsonUtility {
    public static void main(String[] args) {

        Employee staff = createDummyObject();

        //1. Convert object to JSON string
        Gson gson = new Gson();
        String json = gson.toJson(staff);
        System.out.println(json);

        //2. Convert object to JSON string and save into a file directly
        try (FileWriter writer = new FileWriter("D:\\staff.json")) {

            gson.toJson(staff, writer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static Employee  createDummyObject() {

        Employee staff = new Employee();

        staff.setFname("Raul") ;
        staff.setAge(35);
        staff.setLname("Lavin") ;
        staff.setSalary(new BigDecimal("10000"));
        staff.getEmail("lavin.raul@yahoo.com");
        staff.getSsn("433-343-3433");

        List<String> skills = new ArrayList<>();
        skills.add("java");
        skills.add("python");
        skills.add("shell");

        staff.setSkills(skills);

        return staff;

    }

}
