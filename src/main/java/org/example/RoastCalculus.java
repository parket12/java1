package org.example;

import java.util.Scanner;

public class RoastCalculus {
    public static final double RADIUS = 6371.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите координаты первой точки (сначала долгота потом ширина, все в градусах):");
        double a1 = scanner.nextDouble();
        double b1 = scanner.nextDouble();

        System.out.println("Введите координаты второй точки (сначала долгота потом ширина, все в градусах):");
        double a2 = scanner.nextDouble();
        double b2 = scanner.nextDouble();

        double r = calculateDistance(a1, b1, a2, b2);
        System.out.printf("Расстояние между точками: %.2f км\n", r);
    }

    public static double calculateDistance(double a1, double b1, double a2, double b2) {
        double aDiff = Math.toRadians(a2 - a1);
        double bDiff = Math.toRadians(b2 - b1);

        double a = Math.sin(aDiff / 2) * Math.sin(aDiff / 2)
                + Math.cos(Math.toRadians(a1)) * Math.cos(Math.toRadians(a2))
                * Math.sin(bDiff / 2) * Math.sin(bDiff / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double r = RADIUS * c;

        return r;
    }
}
