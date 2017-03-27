
import java.util.*;

public class DiscountModel {

    private double price;
    private double discountedPrice;
    private int outputValue;

    //calculating discount percent
    private int discountPercent() {
        return (int) ((1 - discountedPrice / price) * 100);
    }

    //calculating in percentage how many people think discount is significant
    public String discountSignificance(double price, double discountedPrice) throws InputException {

        this.price = price;
        this.discountedPrice = discountedPrice;
        Map<Integer, Integer> map = new LinkedHashMap<>();

        //array of values of discount percentages that will serve as keys in HashMap
        int[] discounts = new int[99];
        for (int i = 0; i < discounts.length; i++) {
            discounts[i] = i + 1;
        }

        //array of values of pecentage of people considering discount significant, used as HashMap values
        int[] discountSignificance = new int[]{1, 3, 6, 9, 12, 14, 17, 20, 23, 26, 27, 28, 30, 31, 33, 34, 35, 37, 38, 40,
            42, 44, 47, 49, 52, 54, 56, 59, 61, 64, 65, 67, 69, 71, 73, 75, 77, 79, 81, 83, 84, 85, 86, 88, 89, 90, 92, 93,
            94, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96, 96, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97,
            97, 97, 97, 97, 97, 97, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 98, 99};

        //adding keys (discounts) and values (discountSignificance) into HashMap
        for (int i = 0; i < discounts.length; i++) {
            map.put(discounts[i], discountSignificance[i]);
        }

        /* alternative way for better performance without making 'discounts' array
         for (int i = 0; i < 99; i++) {
         map.put(new Double(i + 1), new Double(discountSignificance[i]));
         }
         */
        //filtering input errors
        if (price <= 0 || discountedPrice <= 0) {
            throw new InputException("Prices must be higher than 0!");
        } else if (price <= discountedPrice) {
            throw new InputException("Discounted price must be lower than original price!");
        } else if (discountPercent() < 100) {
            //finding adequate value to be displayed
            for (int d : map.keySet()) {
                if (d >= discountPercent()) {
                    outputValue = map.get(d);
                    break;
                }
            }
        }
        return outputValue + "% of customers consider the discount significant!";
    }
}
