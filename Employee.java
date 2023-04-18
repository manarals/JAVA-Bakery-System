import java.util.ArrayList;
import java.util.Scanner;

public class Employee extends Person{
    public static int employeeCount =1;
    private int employeeID;
private double salary;
 Employee(String name ,String phoneNumber ,String address, double salary)
 {
     super(name,phoneNumber,address);
     this.employeeID = employeeCount;
     employeeCount++;
     this.salary = salary;
 }
 Employee()
 {
     this.employeeID = employeeCount;
     employeeCount++;
 }


public void setEmployeeID(int employeeID )
{
    this.employeeID = employeeID;
}
public void setSalary(double salary  )
{
    this.salary = salary;
}
public int getEmployeeID()
{
    return employeeID;
}
public double getSalary()
{
    return salary;
}

public void printPersonInfo()
{
  super.printPersonInfo();
  System.out.println("Employee ID:"+employeeID);
  System.out.println("Salary: "+salary+"$");
}
    public void addBakeryItem(ArrayList<BakeryItem> items )
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter item name");
        String name = input.nextLine();
        String type = " ";
        while(!type.equals("Savoury") && !type.equals("Sweet") && !type.equals("Drink")  && !type.equals("savoury") && !type.equals("sweet") && !type.equals("drink"))  {
            System.out.println("Enter type (Savoury,Sweet or Drink)");
            type = input.nextLine();
            if(!type.equals("Savoury") && !type.equals("savoury") && !type.equals("Sweet") && !type.equals("sweet") && !type.equals("Drink") && !type.equals("drink"))
            {
                System.out.println("Choose type amongst Savoury, Sweet, or Drink ONLY!");
            }
        }
        System.out.println("Enter kcal");
        double kcal = input.nextDouble();
        System.out.println("Enter total quantity available");
        int quantity = input.nextInt();
        System.out.println("Enter item price");
        double price= input.nextDouble();

        if(type.equals("Savoury") || type.equals("savoury")  )
        {
            System.out.println("Enter toppings");
            String toppings = input.next();
            System.out.println("Enter flour kind");
            String flourKind = input.next();

            BakeryItem item = new Savoury(name,type,kcal,price,quantity,toppings,flourKind);
            items.add(item);
        }
        else if(type.equals("Sweet") || type.equals("sweet"))
        {
            System.out.println("Enter frosting color");
            String frostingColor = input.next();
            System.out.println("Enter fruit used");
            String fruitUsed = input.next();
            System.out.println("Enter flavour");
            String flavour = input.next();
            BakeryItem item = new Sweet(name,type,kcal,price,quantity,frostingColor,fruitUsed,flavour);
            items.add(item);
        }
        else if(type.equals("Drink") || type.equals("drink"))
        {
            System.out.println("Is drink hot? (Type true or false only!)");
            boolean temp = input.nextBoolean();
            System.out.println("Enter syrup");
            String syrup = input.next();
            System.out.println("Enter shot numbers (number only!)");
            int shotNum = input.nextInt();

            BakeryItem item = new Drink(name,type,kcal,price,quantity,temp,syrup,shotNum);
            items.add(item);
        }

        System.out.println("Item added successfully");

    }

    public void updateBakeryItem(int itemID, BakeryManager manager)
    {
        BakeryItem itemFound = manager.searchItem(itemID);
        if(itemFound != null )
        {
            System.out.println("What do you wish to update?\n1-Name\n2-Kcal\n3-Quantity");
            Scanner input = new Scanner(System.in);

            int choice = input.nextInt();
            if(choice==1)
            {
                System.out.println("Enter new name");
                input.nextLine();
                itemFound.name= input.nextLine();

                System.out.println("The item name has been successfully updated!\n");
            }
            else if(choice == 2)
            {
                System.out.println("Enter new Kcal");
                input.nextLine();
                itemFound.kcal = input.nextDouble();

                System.out.println("The item kcal has been successfully updated!\n");
            }
            else if(choice ==3)
            {
                System.out.println("Enter new quantity");
                input.nextLine();
                itemFound.quantityAvailable = input.nextInt();

                System.out.println("The item quantity has been successfully updated!\n");
            }
        }
        else
        {
            System.out.println("No item found in the system by this ID!");
        }
    }

    public void deleteBakeryItem(int itemID,BakeryManager manager)
    {
        BakeryItem itemFound = manager.searchItem(itemID);
        if(itemFound != null) {
            manager.allItems.remove((itemFound));
            System.out.println(itemFound.name+" has been successfully deleted!\n");
        }
        else {
            System.out.println("No such item found!\n");
        }
    }

}
