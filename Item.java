
public class Item 
{
    Integer id, quantity;
    String name, category;
    Double price;
    
    public Item(Integer id, String name, String category, Double price, Integer quantity)
    {
        this.id = id;
        this.name = name;
        this.category = category;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getID() 
    {
        return this.id;
    }
    
    public void setID(Integer id) 
    {
        this.id = id;
    }
    
    public Double getPrice() 
    {
        return this.price;
    }
    
    public void setPrice(Double price) 
    {
        this.price = price;
    }
    
    public String getCategory() 
    {
        return this.category;
    }
    
    public void setCategory(String category) 
    {
        this.category = category;
    }
    
    public String getName() 
    {
        return this.name;
    }
    
    public void setName(String name) 
    {
        this.name = name;
    }
    
    public Integer getQuantity() 
    {
        return this.quantity;
    }
    
    public void setQuantity(Integer quantity) 
    {
        this.quantity = quantity;
    }
}
