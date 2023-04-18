public class Person
{
    public String name; //the name of person
    private String phoneNumber; //the phone number of the person
    private String address; //the address of the person

    public Person()
    {

    }
    public Person(String name, String phoneNumber ,String address)
    {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    public  void setAddress(String address)
    {
         this.address = address;
    }
 public  String getPhoneNumber()
 {
     return phoneNumber;
 }
 public String getAddress()
 {
     return address;
 }

 void printPersonInfo()
 {
     System.out.println("Name: "+name);
     System.out.println("Phone Number: "+phoneNumber);
     System.out.println("Address: "+address);
 }
}
