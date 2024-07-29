import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("returns 0 when shopping cart is empty")
    void testTotalPriceZeroIfCartIsEmpty() {
        assertEquals(0.0, cart.totalPrice());
    }

    @Test
    @DisplayName("returns the sum of product prices")
    void testTotalPriceIfCartIsNotEmpty() {
        cart.addItem("Socks", 1001D);
        cart.addItem("Swingball", 100D);

        assertEquals(1101, cart.totalPrice());
    }

    @Test
    @DisplayName("returns false when discount value is invalid")
    void testDoNotApplyDiscountIfValueIsInvalid() {
        assertAll(
                () -> assertFalse(cart.applyDiscount(2.5)),
                () -> assertFalse(cart.applyDiscount(-1.0))
                );
    }

    @Test
    @DisplayName("applies discount successfully on each of the shopping cart item")
    void testApplyDiscountOnEachCartItem() {
        cart.addItem("Socks", 1001D);
        cart.addItem("Swingball", 100D);

        assertTrue(cart.applyDiscount(0.5));

        assertEquals(0.5, cart.getDiscount());
        assertEquals(50.0, cart.getItems().get("Swingball"));
    }

//    @Test
//    @DisplayName("returns false when shopping cart is empty")
}