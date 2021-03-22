
public class Customer 
{
    int id;
    String name, address, postCode;
    
    public Customer(int id, String name, String address, String postCode) 
    {
        this.id = id;
        this.name = name;
        this.address = address;
        this. postCode = postCode;
    }

    public int getID() 
    {
        return this.id;
    }
    
    public String getName() 
    {
        return this.name;
    }

    public void setName(String newName) 
    {
        this.name = newName;
    }

    public String getAddress() 
    {
        return this.address;
    }

    public void setAddress(String newAddress) 
    {
        this.address = newAddress;
    }
    
    public String getPostcode() 
    {
        return this.postCode;
    }

    public void setPostcode(String newPostcode) 
    {
        this.postCode = newPostcode;
    }
}
