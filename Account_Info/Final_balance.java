package Account_Info;

public class Final_balance {

   public void calculate_final_balance()
   {
        String raisa_pin="",anika_pin="1234",horizontal_line="-------------------------------------------------------------";

        //Make account without setting pin number
        Account Raisa=new Account("Raisa Islam","014xxxxxxxxx");
        // make account with setting pin number
        Account Anika=new Account("Anika Ahmed","017xxxxxxxxx",anika_pin);

        System.out.println(Raisa);
        System.out.println(Anika);
        System.out.println(horizontal_line);

        Raisa.add_money(3000,Raisa.getCustomer_name());
        Anika.add_money(2540,Anika.getCustomer_name());
        System.out.println(horizontal_line);

        //to see what will happen if user want to cash out money without setting pin number
        Raisa.cash_out(2000,"1233");
        //if user's pin number has not been set, then here we will set pin number for user
        raisa_pin=Raisa.is_pin_set()?raisa_pin:Raisa.setPin_number("1223","set");
        System.out.println(horizontal_line);

        Anika.cash_out(2000,anika_pin);
        anika_pin=Raisa.is_pin_set()?anika_pin:Anika.setPin_number("1234","set");
        System.out.println(horizontal_line);

        Raisa.cash_out(2500,raisa_pin);
        System.out.println(horizontal_line);

        Anika.cash_out(2000,"1225");
        System.out.println(horizontal_line);

        //to see what will happen if user has submitted wrong pin number to update pin number
        anika_pin= Anika.is_pin_update_possible("1134") ? Anika.setPin_number("1123","updated"): anika_pin;
        System.out.println(horizontal_line);

        anika_pin= Anika.is_pin_update_possible(anika_pin) ? Anika.setPin_number("1123","updated"): anika_pin;
        System.out.println(horizontal_line);

        //to see what will happen if user's balance is low while he/she is trying to cash out money
        Anika.cash_out(2000,anika_pin);
        System.out.println(horizontal_line);

        System.out.println("Balance after transaction:");
        System.out.println(Raisa);
        System.out.println(Anika);
   }
}
