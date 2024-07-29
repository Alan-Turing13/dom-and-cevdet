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
    @DisplayName("adds an item to the shopping cart")
    void testAddItem() {
        int itemAmount = cart.getItems().size();
        cart.addItem("Socks", 1000D);
        // check to see if an item has been added to the map
        assertEquals(itemAmount+1, cart.getItems().size());
        // check to see the correct item has been added
        assertEquals( 1000D, cart.getItems().get("Socks"));
    }

    // TODO: Determine the logic when we want to applyDiscount, and we have an empty list
    /** Whether we
     * throw an Exception about list's emptiness
     * apply discounts for the future items and let them be added with discounted price
     * */
//    @Test
//    @DisplayName("adds an item with the price of already applied discount")
//    void testAddItemWithAlreadyAppliedDiscount() {
//        cart.applyDiscount(0.5);
//        cart.addItem("Socks", 1000D);
//
//        // check to see the item has been added with correct price
//        assertEquals( 500D, cart.getItems().get("Socks"));
//    }

    @Test
    @DisplayName("does not add duplicate items with the same name")
    void testDuplicateItem() {
        int itemAmount = cart.getItems().size();
        cart.addItem("Socks", 1001D);
        cart.addItem("Socks", 12222D);
        assertEquals(itemAmount+1, cart.getItems().size());
        assertEquals( 1001D, cart.getItems().get("Socks"));
    }

    @Test
    @DisplayName("does not add item with empty name")
    void testInvalidItemName() {
        // Items should not be added if their name is empty
        int itemAmount = cart.getItems().size();
        cart.addItem("", 100D);
        assertEquals(itemAmount, cart.getItems().size());
    }

    @Test
    @DisplayName("does not add item with non-positive price")
    void testInvalidItemPrice() {
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

    /** */

    @Test
    @DisplayName("returns false when discount value is invalid")
    void testDoNotApplyDiscountIfValueIsInvalid() {
        assertAll(
                () -> assertThrows(IllegalArgumentException.class, () -> cart.applyDiscount(2.5)),
                () -> assertThrows(IllegalArgumentException.class, () -> cart.applyDiscount(-1.0))
                );
    }

    @Test
    @DisplayName("returns false when shopping cart is empty")
    void testDoNotApplyDiscountIfCartIsEmpty(){
        assertThrows(IllegalStateException.class, () -> cart.applyDiscount(0.5));
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

}