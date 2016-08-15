/**
 * <h1>Shopping Cart!</h1>
 * The ShoppingCart implements a checkout system for a shop which only sells apples and oranges
 * that displays the total cost of the items on the standard output
 * 
 * @author Jyoti Chawla
 * @since 15/08/2016
 * @version 1.0
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShoppingCart {

	private static List<String> items;
	private static double applePrice = .6;
	private static double orangePrice = .25;

	public ShoppingCart() {
		items = new ArrayList<String>();
	}

	/**
	 * This method is used to add items to the shopping cart.
	 * 
	 * @param item
	 *            This is the item to be added the shopping cart
	 */
	public void addItem(String item) {
		if ((item.toLowerCase().equals("orange"))
				|| ((item.toLowerCase().equals("apple"))))
			items.add(item);
	}

	public int getTotalItems() {
		return items.size();
	}

	/**
	 * This method is used to calculate the total cost of the items in the
	 * shopping cart.
	 * 
	 */
	public double calculateBill() {

		double bill = 0;

		for (String item : items) {
			if (item.toLowerCase().contains("orange"))
				bill += orangePrice;
			else if (item.toLowerCase().contains("apple"))
				bill += applePrice;
		}

		return bill;
	}

	/**
	 * This is the main method which makes use of addNum method.
	 * 
	 * @param args
	 *            Unused.
	 * @return Nothing.
	 * @exception IOException
	 *                On input error.
	 * @see IOException
	 */
	public static void main(String[] args) {

		ShoppingCart myCart = new ShoppingCart();

		System.out.println("\n Please enter your shopping list ");
		Scanner scanner = new Scanner(System.in);
		Scanner scan = new Scanner(System.in);
		String keepShopping = "y";
		double finalBill = 0;
		// Input from command line
		do {
			while (scanner.hasNext()) {
				String temp = scanner.nextLine();
				// Replace all spaces in the input with commas
				temp = temp.replaceAll(" ", ",");
				// Split at input delimited by comma
				String[] inputItems = temp.split(",");
				for (String inputItem : inputItems) {
					myCart.addItem(inputItem.trim());
				}

				finalBill = myCart.calculateBill();
				System.out.println("\n Your bill is £"
						+ String.format("%.2f", finalBill));
				System.out.print("Do you want to continue shopping (y/n)? ");
				keepShopping = scan.next();
				if (keepShopping.equalsIgnoreCase("y")) {
					System.out.println("\n Enter Items ");
				} else if (!keepShopping.equalsIgnoreCase("y")) {
					System.out.println("\n Thank you for shopping with us :) ");
					System.exit(0);
				}
			}

		} while (keepShopping.equals("y"));
	}
}
