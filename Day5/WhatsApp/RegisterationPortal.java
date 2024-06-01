public class RegisterationPortal {
    public void registerAccount(String name,long phoneNo,String password){
        if(Account.allWhatsappAccounts.containsKey(phoneNo)){
            System.out.println("Account already exists");
            return;
        }
        if(String.valueOf(phoneNo).length()!=10){
            System.out.println("Please enter valid 10 digit number!");
            return;
        }
        Account account=new Account(phoneNo,name);
        account.password=password;
        Account.allWhatsappAccounts.put(phoneNo,account);
        System.out.println("Successfully registered");
    }
}
