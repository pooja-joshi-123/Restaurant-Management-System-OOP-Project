
import java.util.*;
import java.io.*;
import java.util.Map.Entry;

public class Inventory 
{
    HashMap<Integer, Item> items = new HashMap<Integer, Item>();
    HashMap<Integer, Order> orders = new HashMap<Integer, Order>();
    HashMap<Integer, Customer> customers = new HashMap<Integer, Customer>();
    Integer customerId = 1, orderId = 101, itemId = 13;

    public HashMap<Integer, Item> getItems() 
    {
        return this.items;
    }

    public HashMap<Integer, Order> getOrders() 
    {
        return this.orders;
    }

    public HashMap<Integer, Customer> getCustomers() 
    {
        return this.customers;
    }

    public Customer getCustomer(int id) 
    {
        return this.customers.get(id);
    }

    public void addCustomer(Customer c) 
    {
        this.customers.put(c.getID(), c);
    }

    public void addOrder(Order o) 
    {
        this.orders.put(o.getID(), o);
    }

    public Item getItem(int id) 
    {
        return this.items.get(id);
    }

    public void addItem(Item i) 
    {
        this.items.put(i.getID(), i);

    }

    public void itemList(File itemList) 
    {
        try 
	{
            Scanner scan = new Scanner(itemList);
            scan.nextLine();
            while (scan.hasNextLine()) 
	    {
                String s = scan.nextLine();
                String[] fields = s.split("\t");
                Item items = new Item(Integer.parseInt(fields[0]), fields[1], fields[2], Double.parseDouble(fields[3]), 1);
                this.addItem(items);
            }
        } 
        catch (FileNotFoundException e) 
	{
            e.printStackTrace();
        }
    }

    public String getMenu() 
    {
        HashMap<String, ArrayList<Item>> menu = new HashMap<String, ArrayList<Item>>();
        String output = "";

        for (Entry<Integer, Item> entry : this.items.entrySet()) 
	{
            String category = entry.getValue().getCategory();

            if (menu.containsKey(entry.getValue().getCategory())) 
	    {
                ArrayList<Item> newList = menu.get(category);

                newList.add(entry.getValue());
                menu.put(category, newList);
            }

            else 
	    {
                ArrayList<Item> newList = new ArrayList<Item>();
                newList.add(entry.getValue());
                menu.put(category, newList);
            }
        }

        for (String category : menu.keySet()) 
	{
            output = output + category + ": \n";
            for (Item i : menu.get(category)) 
	    {
                output = output + i.getName() + "\n";
            }
            output = output + "\n";
        }
        return output;
    }

    public Integer newCustomerId() 
    {
	return customerId++;
    }

    public Integer newOrderId() 
    {
	return orderId++;
    }

    public Integer newItemId() 
    {
        return itemId++;
    }
}
