package nl.harmster.services;

import nl.harmster.Account;

public interface AccountService  
{  
     /**  
      * Gets the account details.  
      *  
      * @param accountNumber the account number  
      * @return the account details  
      */  
     public Account getAccountDetails(String accountNumber);  
} 