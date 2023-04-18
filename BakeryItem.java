public class BakeryItem
{
    private int  itemID;
    public static int totalItems =1;

    public String name;
    public String  itemKind;  //the item kind of the bakery
    public double kcal ;//the calories of the food
    public double itemPrice; //the item price
    public int quantityAvailable; //the number of items available

    public BakeryItem(String name,String itemKind, double kcal ,double itemPrice, int quantityAvailable)
    {
        this.name = name;
        this.itemKind = itemKind;
        this.kcal = kcal;
        this.itemPrice = itemPrice;
        this.quantityAvailable = quantityAvailable;

        itemID = totalItems;
        totalItems++;
    }
    public int getItemID()
    {
        return itemID;
    }

    void printItemDetails()
    {
        System.out.println("Item ID:"+itemID);
        System.out.println("Name:"+name);
        System.out.println("Type:"+itemKind);
        System.out.println("Kcal:"+kcal);
        System.out.println("Price:"+itemPrice+"$");
        System.out.println("Quantity Available:"+quantityAvailable);
    }

    void printItemDetails(boolean brief)
    {
        System.out.println("Name:"+name);
        System.out.println("Type:"+itemKind);
        System.out.println("Price:"+itemPrice);
    }

}
