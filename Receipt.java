import java.util.ArrayList;

public class Receipt
{
    private int receiptID;
    private static int totalReceiptCount =1;
    public  Order allItemsOrdered[];
    public int totalOrders;
    Customer customer;

    public Receipt()
    {
        allItemsOrdered = new Order[8];

        receiptID = totalReceiptCount;
        totalReceiptCount++;

        customer = null;
        totalOrders =0;
    }

    public double calculateTotalCost()
    {
        double totalCost =0;
        for(Order order:allItemsOrdered)
        {
            if(order!=null)
            totalCost+=order.calculateTotalCost();
        }
        return totalCost;
    }

    public void printReceiptDetails()
    {
        System.out.println("ReceiptID:"+receiptID+"\n");
        for(Order order:allItemsOrdered)
        {
            if(order != null) {
                order.printOrderDetails();
                System.out.println();
            }
        }
        System.out.println("\n\tTotal Bill:"+calculateTotalCost()+" $");
    }
}
