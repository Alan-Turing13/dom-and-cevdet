import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private Map<String, Double> items = new HashMap<>();
    private double discount = 0.0;

    public double getDiscount() {
        return discount;
    }

    public Map<String, Double> getItems() {
        return items;
    }

    public void addItem(String name, Double price) {
        if (name.trim().isEmpty() || price <= 0.0) {
            System.out.println("Invalid input.");
            return;
        }

        if (items.putIfAbsent(name, price) == null) {
            System.out.println("Added " + name + " at price £" + price);
        } else {
            System.out.println("There's already a " + name + " item.");
        }

    }

    public double totalPrice() {
        if (items.isEmpty()) {
            return 0.0;
        }

        double totalPrice = 0.0;

        for (double d : this.items.values()) {
            totalPrice+= d;
        }

        return totalPrice;
    }

    public boolean applyDiscount(double discount) {
        if (discount < 0.0 || discount > 1.0) {
            throw new IllegalArgumentException("Invalid input.");
        }

        if (this.items.isEmpty()) {
            throw new IllegalStateException("Shopping cart is empty.");
        }

        this.discount = discount;

        for (String productName : this.items.keySet()) {
            this.items.put(productName, (this.items.get(productName) * discount));
        }

        System.out.println("Discount applied on the cart!");
        return true;
    }
}
