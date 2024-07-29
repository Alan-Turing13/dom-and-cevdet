import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ShoppingCartTest {

    ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void addItem() {
        int itemAmount = cart.getItems().size();
        cart.addItem("Socks", 1000D);
        // check to see if an item has been added to the map
        assertEquals(itemAmount+1, cart.getItems().size());
        // check to see the correct item has been added
        assertEquals( 1000D, cart.getItems().get("Socks"));
    }

    @Test
    void duplicateItem() {
        int itemAmount = cart.getItems().size();
        cart.addItem("Socks", 1001D);
        cart.addItem("Socks", 12222D);
        assertEquals(itemAmount+1, cart.getItems().size());
        assertEquals( 1001D, cart.getItems().get("Socks"));
    }

    @Test
    void invalidItem() {
        // Items should not be added if their name is empty
        int itemAmount = cart.getItems().size();
        cart.addItem("", 100D);
        assertEquals(itemAmount, cart.getItems().size());
    }

    @Test
    void invalidPrice() {
        // Items should not be added if their price <= 0
        int itemAmount = cart.getItems().size();
        cart.addItem("Swingball", 0D);
        assertEquals(itemAmount, cart.getItems().size());
    }

    @Test
    void totalPrice() {

    }
}