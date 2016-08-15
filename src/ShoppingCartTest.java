/**
 * The ShoppingCartTest is the test class for ShoppingCart
 * 
 * @author Jyoti Chawla
 * @since 15/08/2016
 * @version 2.0
 */
import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;

public class ShoppingCartTest {

	ShoppingCart cart;
	private static final double DELTA = 1e-15;

	@Before
	public void setUp() {
		cart = new ShoppingCart();
	}

	@Test
	public void addOneItemToCart() {
		cart.addItem("Apple");
		assertEquals(cart.getTotalItems(), 1);
	}

	@Test
	public void addTwoItemToCart() {
		cart.addItem("Apple");
		cart.addItem("Orange");
		assertEquals(cart.getTotalItems(), 2);
	}

	@Test
	public void addThreeItemToCart() {
		cart.addItem("Apple");
		cart.addItem("Apple");
		cart.addItem("Orange");
		assertEquals(cart.getTotalItems(), 3);
	}

	@Test
	public void addInvalidItemToCart() {
		cart.addItem("Banana");
		assertEquals(cart.getTotalItems(), 0);
	}

	
	
	@Test
	public void CheckOutApple() {
		cart.addItem("Apple");
		assertEquals(cart.calculateBill(), .60, DELTA);
	}

	@Test
	public void CheckOutOrange() {
		cart.addItem("Orange");
		assertEquals(cart.calculateBill(), .25, DELTA);
	}

	@Test
	public void CheckOutTwoItems() {
		cart.addItem("Apple");
		cart.addItem("Orange");
		assertEquals(cart.calculateBill(), .85, DELTA);
	}

	@Test
	public void CheckOutMultipleItems() {
		cart.addItem("Apple");
		cart.addItem("Apple");
		cart.addItem("Orange");
		cart.addItem("Apple");
		assertEquals(cart.calculateBill(), 1.45, DELTA);
	}

	@Test
	public void checkOutAnInvalidItem() {
		cart.addItem("Banana");
		assertEquals(cart.calculateBill(), 0, DELTA);
	}

	@Test
	public void CheckOutMultipleAndInvalidItems() {
		cart.addItem("Apple");
		cart.addItem("Apple");
		cart.addItem("Banana");
		cart.addItem("Apple");
		assertEquals(cart.calculateBill(), 1.20, DELTA);
	}
}
