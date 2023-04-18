import java.util.ArrayList;
import java.util.Scanner;

public class BakeryManager
{
    ArrayList<BakeryItem> allItems;
    ArrayList<Receipt> allReceipts;
    static int choice =0;

    Person currentUser = null;

    public BakeryManager()
    {
        allItems = new ArrayList<>();
        allReceipts = new ArrayList<>();
    }
    public BakeryItem searchItem(int ItemID) {
        for (BakeryItem item : allItems) {
            if (item.getItemID() == ItemID) {
                return item;
            }
        }
        return null;
    }



    private boolean checkForAllLetters(String input)
    {
      for(int i=0;i<input.length();i++)
      {
          if(Character.isWhitespace(input.charAt(i)) == false)
          {
              if (Character.isLetter(input.charAt(i)) == false) {
                  return false;
              }
          }
      }

      return true;
    }

    private boolean checkForAllDigits(String input)
    {
        for(int i=0;i<input.length();i++)
        {
            if(Character.isDigit(input.charAt(i)) == false)
            {
                return false;
            }
        }

        return true;
    }

    public void menu()
    {
        int choice =0;

        boolean employee = false;
        Scanner input = new Scanner(System.in);

        while(choice !=3)
        {
            while (currentUser == null)
            {
                System.out.println("1-Login as Customer\n2-Login as Employee\n3-Quit\n\n");
                choice= input.nextInt();
                if (choice== 1)
                {
                    boolean flag = false;
                    input.nextLine();
                    String name ="";
                    while(flag == false) {
                        System.out.println("Enter your name");
                        name = input.nextLine();
                        flag = checkForAllLetters(name);
                        if(flag == false)
                        {
                            System.out.println("The name cannot contain any symbol or digit. Try again!\n");
                        }
                    }

                    String phoneNumber= "";
                    flag = false;
                    while(flag == false)
                    {
                        System.out.println("Enter phone number (10 digits only)");
                        phoneNumber = input.next();
                        if(phoneNumber.length() == 10) {
                            flag = checkForAllDigits(phoneNumber);
                            if(flag == false)
                            {
                                System.out.println("You may only enter DIGITS for phone number!");
                            }
                        }
                        else
                        {
                            flag = false;
                            System.out.println("The length of the phone number should be 10 only!");
                        }
                    }

                    System.out.println("Enter address");
                    input.nextLine();
                    String address = input.nextLine();
                    currentUser = new Customer(name,phoneNumber,address);
                } else if (choice== 2)
                {
                    employee =loginAsEmployee();
                    if(employee == true)
                    {
                        currentUser = new Employee("Abdullah","03219531992","Wellington Street",15000);
                    }
                } else if (choice== 3)
                {
                    return;
                }

                else
                {
                    System.out.println("Incorrect input. Try again!");
                }
            }

            choice =0;

            if (employee) //employee login
            {
                int employeeChoice =0;
                while(employeeChoice!=6)
                {
                    System.out.println("\n");
                    currentUser.printPersonInfo();
                    System.out.println("\n");

                    System.out.println("\n1-Add Item\n2-Update Item\n3-Delete Item\n4-See All Receipts Generated\n5-See Menu\n6-Logout");
                    employeeChoice = input.nextInt();

                    if(employeeChoice == 1)
                    {
                        ((Employee)currentUser).addBakeryItem(allItems);
                    }
                    else if(employeeChoice ==2)
                    {

                        viewAllItems();
                        System.out.println("\n\n");
                        System.out.println("\nEnter Item ID");
                        int itemID = input.nextInt();
                        ((Employee)currentUser).updateBakeryItem(itemID,this);
                    }
                    else if(employeeChoice ==3)
                    {
                        viewAllItems();
                        System.out.println("\n\n");
                        System.out.println("\nEnter Item ID");
                        int itemID = input.nextInt();
                        ((Employee)currentUser).deleteBakeryItem(itemID,this);
                    }
                    else if(employeeChoice ==4)
                    {
                        for(Receipt receipt:allReceipts)
                        {
                            receipt.customer.printPersonInfo();
                            receipt.printReceiptDetails();
                            System.out.println("\n\n");
                        }
                    }
                    else if(employeeChoice == 5)
                    {
                        viewAllItems();
                    }
                    else if(employeeChoice ==6)
                    {
                        logOut();
                        employee = false;
                    }
                }

            }
            else
            {
                int customerChoice=0;
                while(customerChoice != 4)
                {
                    System.out.println("\n");
                    currentUser.printPersonInfo();
                    System.out.println("\n");
                    System.out.println("1-Order a Bakery Item by seeing Menu\n2-View your receipt\n3-Remove Item from Receipt\n4-Logout");
                    customerChoice =input.nextInt();

                    if(customerChoice ==1)
                    {
                                viewAllItems();
                        System.out.println("\n\n");
                                int itemChoice =0;
                                while (itemChoice != 2)
                                {
                                    System.out.println("1-Order Bakery Item\n2-Go Back");
                                    itemChoice = input.nextInt();
                                    if (itemChoice == 1)
                                    {
                                        orderBakeryItem();
                                    }
                                    else if (itemChoice == 2)
                                    {
                                    }
                                    else
                                    {
                                        System.out.println("Incorrect choice! Try again");
                                    }
                                }
                    }
                    else if(customerChoice == 2)
                    {

                        ((Customer)currentUser).displayReceipt();
                        System.out.println("\n\n");
                    }
                    else if(customerChoice == 3)
                    {
                        ((Customer)currentUser).displayReceipt();
                        System.out.println("\n\n");

                        System.out.println("Enter OrderID to remove it from your receipt");
                        int OrderID = input.nextInt();
                       if(((Customer)currentUser).deleteFromCart(OrderID) == true)
                       {
                           System.out.println("Item removed successfully!");
                       }
                       else
                       {
                           System.out.println("Item with the provided ItemID not found!");
                       }
                    }
                    else if(customerChoice == 4)
                    {
                        ((Customer)currentUser).receipt.customer = (Customer)currentUser;
                        allReceipts.add(((Customer)currentUser).receipt);
                        logOut();
                    }
                    else
                    {
                        System.out.println("Incorrect option entered!");
                    }

                }
            }
        }
    }
    public boolean loginAsEmployee()
    {
        System.out.println("Enter the special employee password to login");
        String password;
        Scanner scanner = new Scanner(System.in);
        password = scanner.next();

        if(password.equals("admin1234"))
        {
            currentUser = new Employee();
            return true;
        }
        else
        {
            System.out.println("Authorization failed! Employee privileges DENIED!\n");
            return false;
        }

    }
    public void logOut()
    {
        currentUser = null;
    }

    public void viewAllItems()
    {
        for(BakeryItem item:allItems)
        {
            item.printItemDetails();
            System.out.println();
        }
    }
    public void orderBakeryItem()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ItemID of the Bakery Item you want to order");
        int itemID = input.nextInt();

        BakeryItem itemFound = searchItem(itemID);
        if(itemFound!=null)
        {
            System.out.println("Enter the required quantity");
            int quantity = input.nextInt();

                boolean add = ((Customer)currentUser).addInCart(itemFound,quantity);
                if(add)
                System.out.println("\n"+quantity+" quantity of "+itemFound.name+" have been successfully added to your receipt!\n");
        }
        else
        {
            System.out.println("\nSorry, no item found against this ID!\n");
        }
    }

    public void loadData()
    {
        allItems.add(new Savoury("Gol Gappay","Savoury",0.35,2,100,"Chanay","Wheat"));
        allItems.add(new Savoury("Dahi Bhallay","Savoury",0.4,1,150,"Salad","Barley"));
        allItems.add(new Drink("Mint Margarita","Drink",0.2,5,200,false,"Mint Syrup",0));
        allItems.add(new Drink("Hot Coffee","Drink",0.3,3,250,true,"Chocolate",3));
        allItems.add(new Sweet("Chocolate","Sweet",0.5,10,325,"Black","Blueberry","Sweet"));
        allItems.add(new Sweet("Cheese Cake","Sweet",0.6,20,50,"White","None","Sweet"));

        BakeryManager.choice =1;
    }

    public static void main(String[]args)
    {
        BakeryManager bakery = new BakeryManager();
        bakery.loadData();
        if(BakeryManager.choice ==1)
        bakery.menu();
    }

}
