
import java.util.*;

abstract class Display
{
    static Scanner sc = new Scanner(System.in);
    String header = "";
    ArrayList<Display> menu = new ArrayList<Display>();
    Display back = null;
    public static Inventory inventory;

    abstract void run();

    public Display getBack() 
    {
        return this.back;
    }
    
    public void setBack(Display back) 
    {
        this.back = back;
    }
    
    public void addMenuOption(Display option) 
    {
        this.menu.add(option);
    }

    static Integer isInt() 
    {
        Integer i;
        while (true) 
	{
            try 
	    {
                i = Integer.parseInt(sc.next());
                return i;
            }
            catch (NumberFormatException e) 
	    {
                System.out.println("Please enter an integer.");
                continue;
            }
        }
    }
    
    static Double isDouble() 
    {
        Double d;
        while (true) 
	{
            try 
	    {
                d = Double.parseDouble(sc.next());
                return d;
            }
            catch (NumberFormatException e) 
	    {
                System.out.println("Please enter a double.");
                continue;
            }  
        }
    }

    static Customer getValidCustomer() 
    {
        Customer customer;
        while (true) 
	{
	    System.out.println("Enter customer ID: ");
            Integer id = isInt();
            customer = inventory.getCustomer(id);
            if (customer == null) 
	    {
                System.out.println("Customer does not exist.");
                continue;
            }
            else
                break;
        }
        return customer;
    }

    static Item getValidItem() 
    {
        Item item;
        while (true) 
	{
	    System.out.println("Enter an item ID: ");
            Integer id = isInt();
            item = inventory.getItem(id);
            if (item == null) 
	    {
                System.out.println("Item does not exist.");
                continue;
            }
            else 
                break;
        }
        return item;
    }

    public void checkOption(String op) 
    {
        Integer menuNumber = 0;
        try 
	{
            menuNumber = Integer.parseInt(op);
        }
        catch (NumberFormatException e) 
	{
            System.out.println("Invalid Menu Item");
            this.run();
            return;
        }
        this.menu.get(menuNumber - 1).run();
    }

    public String toString() 
    {
        String result = this.header + "\n";
        for (Display s: this.menu) 
	{
            result = result + (menu.indexOf(s) + 1) + ") " + s.header + "\n";
        }
        result = result + "\n";
        return result;
    }
}


class AddCustomer extends Display 
{
    public AddCustomer() 
    {
        this.header = "Add a Customer";
    }

    void run() 
    {
	Integer id = inventory.newCustomerId();
        System.out.println(this.toString());
        System.out.print("Enter customer's name: ");
        String name = sc.next();
        System.out.print("Enter customer's address: ");
        sc = new Scanner(System.in);
        String address = sc.next();
        System.out.print("Enter customer's postcode: ");
        sc = new Scanner(System.in);
        String postCode = sc.next();
        inventory.addCustomer(new Customer(id, name, address, postCode));
	System.out.println("Successfully added customer with ID " + id);

        this.back.run();
    }
}

class AddItem extends Display 
{
    public AddItem() 
    {
        this.header = "Add an Item";
    }
    
    void run() 
    {
	Integer id = inventory.newItemId();
        System.out.println(this.toString());
        System.out.println("Enter item name: ");
        String name = sc.next();
        System.out.println("Enter item category: ");
        sc = new Scanner(System.in);
        String category = sc.next();
	System.out.println("Enter item price: ");
        Double price = isDouble();
	System.out.println("Enter item quantity: ");
        Integer quantity = isInt();
        inventory.addItem(new Item(id, name, category, price, quantity));
	System.out.println("Successfully added item with ID " + id);

        this.back.run();
    }
}


class AddOrder extends Display 
{
    public AddOrder() 
    {
        this.header = "Add an Order";
    }

    void run() 
    {
        System.out.println(this.toString());

        Customer customer = getValidCustomer();
        HashMap<Item, Integer> items = new HashMap<Item, Integer>();
        while (true) 
	{
            Item item = getValidItem();
            Integer qty;
	
	    System.out.println("How many?");
            qty = isInt();
            items.put(item, qty);
            System.out.print("Add more items? [Y/N]: ");
            sc = new Scanner(System.in);
            if (sc.next().equalsIgnoreCase("Y"))
                continue;
            else
                break;
        }

        System.out.println("Enter the order date: ");
        sc = new Scanner(System.in);
        String orderDate = sc.next();

        Order o = new Order(customer, inventory.newOrderId(), items);
        inventory.addOrder(o);
        System.out.println(o.toString() + "Date: " + orderDate);

        this.back.run();
    }
}


class ViewMenu extends Display 
{
    public ViewMenu() 
    {
        this.header = "View Food Menu";
    }

    void run() 
    {
        System.out.println(inventory.getMenu());
        System.out.println("Press any key to go back");
        String str = sc.next();
        this.back.run();
    }
}


class MainMenu extends Display 
{
    public MainMenu() 
    {
        this.header = "Main Menu";
    }

    public void run() 
    {
        System.out.println(this.toString());
        while (true) 
        {
            try 
	    {
                System.out.println("Choose an option: ");
		Scanner scan = new Scanner(System.in);
                String str = scan.next();
                this.checkOption(str);
                break;
            }
            catch (RuntimeException e) 
	    {
                System.out.println("Please select from one of the given options.");
            }
        }
    }
}
