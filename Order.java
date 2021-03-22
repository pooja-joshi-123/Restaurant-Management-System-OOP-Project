
import java.util.*;
import java.util.Map.Entry;

public class Order 
{
    Customer customer;
    HashMap<Item, Integer> items;
    Integer id;

    public Order(Customer customer, Integer id, HashMap<Item, Integer> items) 
    {
        this.customer = customer;
        this.id = id;
        this.items = items;
    }

    public Integer getID() 
    {
        return this.id;
    }

    public void setID(Integer id) 
    {
        this.id = id;
    }

    public Customer getCustomer() 
    {
        return this.customer;
    }

    public void setCustomer(Customer customer) 
    {
        this.customer = customer;
    }

    public HashMap<Item, Integer> getItems() 
    {
        return this.items;
    }

    public void setItems(HashMap<Item, Integer> items) 
    {
        this.items = items;
    }

    public double amount() 
    {
        double amount = 0;
        for (Entry<Item, Integer> e: this.items.entrySet()) 
        {
            amount += e.getValue() * e.getKey().getPrice();
        }
        return amount;   
    }

    String displayItems() 
    {
        String res = "";
        for (Entry<Item, Integer> e: this.items.entrySet()) 
        {
            res = res + e.getKey().getName() + " \t\t\t\t " + e.getValue().toString() + " * ₹" + e.getKey().getPrice().toString() +  "\n";   
        }
        return res;
    }

    public String toString() 
    {
        return "Customer: " + customer.getName() + "\n" + "Order ID: " + this.id.toString() + "\n" + "Items Ordered: \n" + this.displayItems() + "\n" + "Total Amount: ₹" + this.amount() + "\n";
    }
}
