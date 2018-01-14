/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author VM_PC
 */
public class BreakEven {
    public static void main(String[] args) {
        double costToProduce = 3.00;
        double itemPriced = 5.00;
        double calc = 20 / (itemPriced - costToProduce);
        int breakEven = (int)calc;
        
        System.out.println("Break Even is at " + breakEven);
    }
}
