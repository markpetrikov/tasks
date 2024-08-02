/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.task2;

import java.nio.file.Files;
import java.nio.file.Path;

public class Task2 {

    private static int equation(int x, int y, int r, int i, int j) {
        int a = (int) Math.pow((i - x), 2) + (int) Math.pow((j - y), 2);
        int b = r * r;
        if (a > b) {
            return 2;
        } else if (a < b) {
            return 1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        try {
            Path path = Path.of(args[0]);
            String circle = Files.readString(path);
            String[] c = circle.split("[^-0-9\\/]+");
            int x = Integer.parseInt(c[0]);
            int y = Integer.parseInt(c[1]);
            int r = Integer.parseInt(c[2]);

            String dots = Files.readString(Path.of(args[1]));
            String[] d = dots.split("[^-0-9\\/]+");
            for (int i = 0; i < d.length; i += 2) {
                System.out.println(equation(x, y, r, Integer.parseInt(d[i]), Integer.parseInt(d[i + 1])));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}
