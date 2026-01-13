package methods;

import java.util.ArrayList;
import java.util.List;

import containers.Container;
import items.Item;

public class Calculation {
    
    public double totalVolume(List<Item> items) {
        double totalVolume = 0;
        for (Item item: items) {
            totalVolume += item.itemVolume();
        }
        return totalVolume;
    }
    
    public double totalWeight(List<Item> items) {
        double totalWeight = 0;
        for (Item item: items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public String bestShipping(List<Item> items, List<Container> containers) {
        double totalVolume = totalVolume(items);
        double totalWeight = totalWeight(items);
        
        double smallConVolume = 0;
        double bigConVolume = 0;
        double smallConWeight = 0;
        double bigConWeight = 0;
        
        for (Container container : containers) {
            if (container.getName().equals("Small")) {
                smallConVolume = container.conVolume();
                smallConWeight = container.getMaxWeight();
            } else if (container.getName().equals("Big")) {
                bigConVolume = container.conVolume();
                bigConWeight = container.getMaxWeight();
            }
        }
        
        int numSmallCon = 0;
        int numBigCon = 0;
        double remVolume = totalVolume;
        double remWeight = totalWeight;
        
        while (remVolume > 0 && remWeight > 0) {
            if (remVolume <= bigConVolume && remWeight <= bigConWeight) {
                numBigCon++;
                break;
            } else if (remVolume <= smallConVolume && remWeight <= smallConWeight) {
                numSmallCon++;
                break;
            } else if (remVolume / bigConVolume >= 1 && remWeight / bigConWeight >= 1) {
                numBigCon++;
                remVolume -= bigConVolume;
                remWeight -= bigConWeight;
            } else {
                numSmallCon++;
                remVolume -= smallConVolume;
                remWeight -= smallConWeight;
            }
        }
        
        double totalCost = (numBigCon * 1800) + (numSmallCon * ((remWeight > 500) ? 1200 : 1000));
        
        return "Number of Big Containers: " + numBigCon + "\n" +
               "Number of Small Containers: " + numSmallCon + "\n" +
               "Total Shipping Cost: " + totalCost + " Euros";
    }
    
    public double hippingPrice(List<Item> items, List<Container> containers) {
        double totalWeight = totalWeight(items);
        for (Container container: containers) {
            if (container.getName().equals("Big")) {
                return 1800;
            } else if (container.getName().equals("Small")) {
                if (totalWeight <= 500) {
                    return 1000;
                } else {
                    return 1200;
                }
            }
        }
        return 0;
    }
    
    public void addItems(List<Item> items, String name, double height, double wide, double length, double weight, int quantity) {
        for (int i = 0; i < quantity; i++) {
            items.add(new Item(name, height, wide, length, weight));
        }
    }
    
    public void printItem(List<Item> items) {
        for (Item item: items) {
            item.printItemInfo();
        }
    }
    
    public void printOrder(List<Item> items, List<Container> containers) {
        double totalVolume = totalVolume(items);
        double totalWeight = totalWeight(items);
        String bestShipping = bestShipping(items, containers);
        
        System.out.println("Order Information: ");
        printItem(items);
        System.out.println("Total Volume: " + totalVolume);
        System.out.println("Total Weight: " + totalWeight);
        System.out.println(bestShipping);
    }
}
