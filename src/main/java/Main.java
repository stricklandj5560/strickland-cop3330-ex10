import java.util.ArrayList;
import java.util.Scanner;

/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Jonathan Strickland
 */
public class Main {
    final static double taxRate = 0.055;
    final static int numItems = 3;
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            ArrayList<double[]> priceList = new ArrayList<>();
            for (int i = 0; i < numItems; i++) {
                // format is [price, quantity]
                double[] priceQuant = new double[2];
                // get price
                System.out.print("Enter the price of item " + (i + 1) + ": ");
                priceQuant[0] = scan.nextDouble();
                System.out.print("Enter the quanitity of item " + (i + 1) + ": ");
                priceQuant[1] = scan.nextInt();
                priceList.add(priceQuant);
            }
            // calculate subtotal
            double subtotal = 0;
            for (double[] pq : priceList)
                subtotal += pq[0] * pq[1];
            // round tax and total to two decimal places.
            double tax = (double) Math.round((subtotal * taxRate) * 100) / 100;
            double total = (double) Math.round((subtotal + tax) * 100) / 100;
            System.out.println(String.format("Subtotal: $%s\nTax: $%s\nTotal: $%s", subtotal, tax, total));
            scan.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
