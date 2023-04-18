public class Drink extends BakeryItem
{
    private boolean temp; //the temperature of drink hot or cold
    private String syrup; //the type of the syrup
    private int shotNum; //the number of coffee shots.

    public Drink(String name,String itemKind, double kcal, double itemPrice, int quantityAvailable,boolean temp, String syrup, int shotNum) {
        super(name, itemKind, kcal, itemPrice, quantityAvailable);
        this.temp = temp;
        this.syrup = syrup;
        this.shotNum = shotNum;
    }
    void printItemDetails()
    {
        super.printItemDetails();
        System.out.print("Temperature:");
        if(temp == true)
        {
            System.out.println("Hot");
        }
        else
            System.out.println("Cold");
        System.out.println("Syrup:"+syrup);
        System.out.println("Coffee Shots:"+shotNum);
    }

}
