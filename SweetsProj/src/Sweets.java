/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author w028006g
 */
public class Sweets {
    
    public static void main(String[] args) {
        int totalSweets = 40;
        int students = 14;
        int studentTotal = totalSweets / students;
        int teachers = totalSweets - (students * studentTotal);
        
        System.out.println("Students Will Keep " + studentTotal + " Sweets each!");
        System.out.println("Teacher Will Keep " + teachers);
    }
}
