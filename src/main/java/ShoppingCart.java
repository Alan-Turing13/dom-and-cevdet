import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();

    public Map<String, Double> getItems() {
        return items;
    }

    public void addItem(String name, Double price){

        if (name.trim().length() != 0 && price > 0) {
            if (items.putIfAbsent(name, price) == null) {
                System.out.println("Added " + name + " at price £" + price);
            } else {
                System.out.println("There's already a " + name + " item.");
            }
        } else{
            System.out.println("Invalid input.");
        }
    }

    public double totalPrice(){
        return 0;
    }
}
