/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.task4;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Task4 {

    public static void main(String[] args) {
        try {
            Path path = Path.of(args[0]);
            List<String> arr = Files.readAllLines(path);
            int sum = 0;
            for (int i = 0; i < arr.size(); i++) {
                sum += Integer.parseInt(arr.get(i));
            }
            sum /= arr.size();

            int res = 0;
            for (int i = 0; i < arr.size(); i++) {
                res += Math.abs(Integer.parseInt(arr.get(i)) - sum);
            }
            System.out.println(res);
        } catch (Exception e) {
            System.err.println(e.toString());
        }
    }
}
