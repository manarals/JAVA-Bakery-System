public class Sweet extends BakeryItem
{
    private String frostingColor; //the kind of the frosting color
    private String fruitUsed; //the type of the fruit
    private String flavour; //the flavour of the sweet if its sweet, salty, sour,bitter, or umami
    public Sweet(String name, String itemKind, double kcal, double itemPrice, int quantityAvailable,String frostingColor,String fruitUsed,String flavour)
    {
        super(name, itemKind, kcal, itemPrice, quantityAvailable);
        this.frostingColor = frostingColor;
        this.fruitUsed = fruitUsed;
        this.flavour = flavour;
    }
    void printItemDetails()
    {
        super.printItemDetails();
        System.out.println("Frosting Colour:"+frostingColor);
        System.out.println("Fruit Used:"+fruitUsed);
        System.out.println("Flavour"+flavour);
    }
}
