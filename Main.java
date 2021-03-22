
import java.io.*;

public class Main
{
    public static void main(String[] args) 
    {
        File itemList = new File("itemList.txt");
        Inventory inventory = new Inventory();
	inventory.itemList(itemList);

        MainMenu mainMenu = new MainMenu();

        Display addOrder = new AddOrder();
        Display addCustomer = new AddCustomer();
        Display addItem = new AddItem();
        Display viewMenu = new ViewMenu();

        mainMenu.addMenuOption(addOrder);
        mainMenu.addMenuOption(addCustomer);
        mainMenu.addMenuOption(addItem);
        mainMenu.addMenuOption(viewMenu);

        addOrder.setBack(mainMenu);
        addCustomer.setBack(mainMenu);
        addItem.setBack(mainMenu);
        viewMenu.setBack(mainMenu);
       
        Display.inventory = inventory;
        mainMenu.run();
    }
}
