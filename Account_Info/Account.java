package Account_Info;

public class Account {

    private String customer_name,mobile_number,pin_number;
    private int balance;

    //User's information has been initialized without setting pin number
    public Account(String customer_name, String mobile_number)
    {
         this.customer_name=customer_name;
         this.mobile_number=mobile_number;
         this.pin_number="";
    }

    //User's information has been initialized with setting pin number
    public Account(String customer_name, String mobile_number,String pin_number)
    {
        this.customer_name=customer_name;
        this.mobile_number=mobile_number;
        this.pin_number=pin_number;
    }

    @Override
    //Showing the information of user
    public String toString() {
        return "Account{" +
                "customer_name: " + customer_name+
                ", mobile_number: " + mobile_number+
                ", balance: " + balance +
                '}';
    }

    //User adding a certain amount of money to their account
    public void add_money(int amount,String customer_name) {
        this.balance+=amount;
        System.out.println(amount+"tk has been added in "+customer_name+"'s account.");
    }

    //If user's pin number has not set then they have to set pin number first in order to cash out.
    //Also user can't cash out money if their balance is low.
    public void cash_out(int amount,String pin_number) {
        if(this.pin_number.length()==0)
        {
            System.out.println("Your pin number has not been set yet! Set your pin number first.");
        }
        else if(this.pin_number!=pin_number){
            System.out.println("Pin doesn't match. Try again.");
        }
        else {
            if(this.balance>=amount){
                this.balance-=amount;
                System.out.println("Cash out amount: "+amount+"tk");
            }
            else{
                System.out.println("Cash out is not possible due to low balance!");
            }
            System.out.println("Your balance is("+this.customer_name+"): "+this.balance+"tk");
        }
    }

    //to check if user's pin number has been set yet.
    public boolean is_pin_set()
    {
        if(this.pin_number.length()==0)
            return false;
        else
            return true;
    }

    //if user's pin number has not set, then this function will set pin number.
    //It can also update pin number
    public String setPin_number(String new_pin_number,String what_have_done){
        this.pin_number=new_pin_number;
        System.out.println("Your pin number has been "+what_have_done+" successfully. New pin number("+this.customer_name+"):"+new_pin_number);
        return this.pin_number;
    }

    // if user submit the wrong pin number then updating pin number is not possible
    public boolean is_pin_update_possible(String old_pin){
        if(this.pin_number!=old_pin){
            System.out.println("Sorry, upadate is not possible due to wrong pin number. Enter the correct pin number.");
            return false;
        }
        else
            return true;
    }

    //to show the user's name without risking private information
    public String getCustomer_name() {
        return customer_name;
    }
}
