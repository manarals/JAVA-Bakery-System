public class Savoury extends BakeryItem
{
    private String toppings; //the toppings of the savoury
    private String flourKind; //the flour kind of the savoury

    public Savoury(String name, String itemKind, double kcal, double itemPrice, int quantityAvailable,String toppings,String flourKind)
    {
        super(name,itemKind,kcal,itemPrice,quantityAvailable);
        this.toppings = toppings;
        this.flourKind = flourKind;
    }
    void printItemDetails() {
        super.printItemDetails();
        System.out.println("Toppings:"+toppings);
        System.out.println("Flour Kind:"+flourKind);
    }
}
