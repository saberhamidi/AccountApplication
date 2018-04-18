import com.google.gson.Gson;

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

    public boolean parseToJson(){
        Gson parser = new Gson();
        String parsedJson = parser.toJson(accounts);

        return true;
    }
}
