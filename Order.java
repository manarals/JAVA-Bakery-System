public class Order
{
    private int orderID;
    private static int totalOrders =1;
    public int quantity;
    public BakeryItem item;

    Order()
    {

    }
    Order ( BakeryItem item,int quantity )
    {
        this.item = item;
        this.quantity = quantity;


        orderID = totalOrders;
        totalOrders++;
    }

    public int getOrderID()
    {
        return orderID;
    }

    public double calculateTotalCost()
    {
        return (item.itemPrice*quantity);
    }

    public void printOrderDetails()
    {
        System.out.println("Order ID:"+orderID);
        item.printItemDetails(true);
        System.out.println("Quantity: "+quantity);
        System.out.println("Price:" +quantity+"*"+item.itemPrice +"= "+calculateTotalCost()+ "$");
    }
}
