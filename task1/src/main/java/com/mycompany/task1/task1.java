/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.task1;

public class task1 {

    public static void main(String[] args) {
        try {
            int n = Integer.parseInt(args[0]);
            int m = Integer.parseInt(args[1]);

            for (int i = 1;;) {
                System.out.println(i);
                i = i + m - 1;
                if (i > n) {
                    i = i % n;
                }
                if (i == 1) {
                    break;
                }
            }
        } catch (NumberFormatException n) {
            System.out.println("no int");
        } catch (Exception e) {
            System.out.println("no args");
        }
    }
}
