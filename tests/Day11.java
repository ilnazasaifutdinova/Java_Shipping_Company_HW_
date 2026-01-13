package Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import containers.Container;
import items.Item;
import methods.Calculation;

public class Day11 {

    public static void main(String[] args) {
    	
        // Add products details
        Item laptop = new Item("Laptop", 60, 50, 50, 6.5);
        Item mouse = new Item("Mouse", 30, 30, 20, 0.2);
        Item desktop = new Item("Desktop", 100, 150, 50, 20);
        Item lcd = new Item("LCD Screen", 120, 140, 80, 2.6);
        
        // Add containers details
        Container smallCon = new Container("Small", 2.59, 2.43, 6.06, 500);
        Container bigCon = new Container("Big", 2.59, 2.43, 12.01, 500);
        
        // Saving the type of containers using ArrayList Data Structure.
        List<Container> containers = new ArrayList<>();
        containers.add(smallCon);
        containers.add(bigCon);
        
        // ArrayList for items1, containers1.
        List<Item> items1 = new ArrayList<>();
        List<Container> containers1 = new ArrayList<>();
        containers1.add(smallCon);
        containers1.add(bigCon);
        
        // Add items (from customer input) //Read the order
        Scanner it = new Scanner(System.in);
        System.out.print("Enter order information (e.g., 100 Laptop, 200 Mouse): ");
        String order = it.nextLine();
        
        // Split the order input
        String[] ordInfo = order.split(",");
        
        // Add each item to the items1 list based on the parsed input
        for (String orderin : ordInfo) {
            String[] parts = orderin.trim().split(" ");
            int quantity = Integer.parseInt(parts[0]);
            String prodName = parts[1].toLowerCase();
            
            switch (prodName) {
                case "laptop":
                    for (int i = 0; i < quantity; i++) {
                        items1.add(laptop);
                    }
                    break;
                case "mouse":
                    for (int i = 0; i < quantity; i++) {
                        items1.add(mouse);
                    }
                    break;
                case "desktop":
                    for (int i = 0; i < quantity; i++) {
                        items1.add(desktop);
                    }
                    break;
                case "lcd":
                case "lcdscreen":
                    for (int i = 0; i < quantity; i++) {
                        items1.add(lcd);
                    }
                    break;
                default:
                    System.out.println("Unknown product: " + prodName);
                    break;
            }
        }
        
        // Perform calculations and print the results
        Calculation calculation = new Calculation();
        calculation.printOrder(items1, containers1);
        
        it.close();
    }
}
