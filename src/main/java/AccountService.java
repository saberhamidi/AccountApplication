import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<String, Account> accounts = new HashMap<String, Account>();

    public boolean addAccount(Account ac){
        accounts.put(ac.getFirstName(), ac);
        return true;
    }

    public Account getAccountByName(String name){

        return accounts.get(name);
    }
}
