/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rh.model;

//import com.rh.model.entities.Employee;
import java.util.ArrayList;

/**
 *
 * @author Calbrix && Ikerchalene 
 */
public class SearchService {

//    private ArrayList<Employee> employees = new ArrayList();

    public SearchService() {
//        employees.add(new Employee("Raul Mazo", "123-45-6789"));
//        employees.add(new Employee("Calbrix Pierre", "000-00-0000"));
//        employees.add(new Employee("Ikerchalene Lahoucine", "111-11-1111"));
//        employees.add(new Employee("Thiam Mbaye Le Major De Promotion", "777-77-7777"));
    }
    

    public ArrayList searchByName(String name) {
        ArrayList resultList = new ArrayList();
//        for (int i = 0; i < employees.size(); i++) {
//            if (employees.get(i).getName().toUpperCase().indexOf(name.toUpperCase()) != -1) {
//                resultList.add(employees.get(i));
//            }
//        }
        return resultList;
    }

    public ArrayList searchBySsNum(String ssNum) {
        ArrayList resultList = new ArrayList();
//        for (int i = 0; i < employees.size(); i++) {
//            if (employees.get(i).getSsNum().equals(ssNum)) {
//                resultList.add(employees.get(i));
//            }
//        }
        return resultList;
    }

    
    public void addEmploye(String name, String ssNum) {
//        employees.add(new Employee(name,ssNum));
    }
}
