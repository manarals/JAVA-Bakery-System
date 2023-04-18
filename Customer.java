import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Customer extends Person
{
    private int customerID;
    private static int customerCount =1;
    Receipt receipt;

    public Customer(String name , String phoneNumber , String address)
    {
        super(name,phoneNumber,address);
        customerID = customerCount;
        customerCount++;
        receipt = new Receipt();
    }
    public int getCustomerID()
    {
        return customerID;
    }
 public boolean addInCart(BakeryItem item, int quantity)
 {
     if(quantity<= 8)
     {
         boolean alreadyPresent = false;

         for (Order order : receipt.allItemsOrdered)
         {
             if (order != null) {
                 if (order.item.equals(item)) {
                     alreadyPresent = true;
                     if(order.quantity+quantity<=8)
                     {

                         if(item.quantityAvailable>=quantity)
                         {
                             order.quantity += quantity;
                             item.quantityAvailable-=quantity;
                             return true;
                         }
                         else {
                             System.out.println("Sorry, there is not enough quantity of the item desired available!\n");
                             return false;
                         }

                     }
                     else
                     {
                         System.out.println("You already have " + order.quantity + " number of this item in your cart. You can only have " + (8 - order.quantity) + " more of this item");
                         return false;
                     }
                 }
             }
         }

         if (alreadyPresent == false) {
             if (receipt.totalOrders < 8)
             {
                 if(item.quantityAvailable>=quantity)
                 {
                     Order order = new Order(item, quantity);
                     receipt.allItemsOrdered[receipt.totalOrders] = order;
                     receipt.totalOrders++;
                     return true;
                 }
                 else
                 {
                     System.out.println("Sorry, there is not enough quantity of the item desired available!\n");
                     return false;
                 }


             }
             else {
                 System.out.println("Sorry, you cannot have more than 8 orders in your receipt!\n");
                 return false;
             }
         }
     }
     else
     {
         System.out.println("You cannot have more than 8 quantity of any bakery item!");
         return false;
     }

     return false;
 }
 public boolean deleteFromCart(int OrderID)
 {
     int index = -1;
    for(int i=0;i<receipt.totalOrders;i++)
    {
        if(receipt.allItemsOrdered[i].getOrderID() == OrderID)
        {
            index = i;
            receipt.allItemsOrdered[i] = null;
        }
    }
    if(index!= -1)
    {
        for(int i=index;i<receipt.totalOrders-1;i++)
        {
            receipt.allItemsOrdered[i] = receipt.allItemsOrdered[i+1];
            receipt.allItemsOrdered[i+1] = null;
        }
        receipt.totalOrders--;
        return true;
    }
     return false;
 }
 public void printPersonInfo()
 {
     super.printPersonInfo();
     System.out.println("Customer ID: "+customerID);
 }
 public void displayReceipt()
 {
     receipt.printReceiptDetails();
 }

}
