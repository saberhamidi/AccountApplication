import com.infosys.domain.Account;
import com.infosys.service.AccountService;
import com.infosys.util.JsonUtil;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class AccountServiceTest {

    private AccountService accountService;
    private Account myAccount;
    private Account baharAccount;
    private JsonUtil jsonUtil;


    @org.junit.Before
    public void init(){
        accountService = new AccountService();
        myAccount = new Account("Saber", "Hamidi", 35352345);
        baharAccount = new Account("Bahar", "Hamidi", 7754345);
        jsonUtil = new JsonUtil();
    }

    @org.junit.Test
    public void addAccountTest() {
        accountService.addAccount(myAccount);
        assertEquals(1, accountService.getAccounts().size());
        accountService.addAccount(baharAccount);
        assertEquals(2, accountService.getAccounts().size());
    }

    @org.junit.Test
    public void removeAccountTest() {
        accountService.addAccount(myAccount);
        accountService.addAccount(baharAccount);
        accountService.removeAccount("Saber");
        assertEquals(1, accountService.getAccounts().size());
        accountService.removeAccount("Bahar");
        assertEquals(0, accountService.getAccounts().size());
    }

    @org.junit.Test
    public void getAccountByNameTest() {
        assertEquals(null, accountService.getAccountByName("Saber"));
        accountService.addAccount(myAccount);
        assertEquals("Saber", accountService.getAccountByName("Saber").getFirstName());
    }


    @org.junit.Test
    public void JavaToJsonTest() {
        String emptyMapJson = jsonUtil.JavaToJson(accountService.getAccounts());
        assertEquals("{}", emptyMapJson);
        accountService.addAccount(myAccount);

        String accountsInJsonFormat = "{\"Saber\":{\"firstName\":\"Saber\",\"lastName\":\"Hamidi\",\"accountNumber\":35352345}}";
        accountService.addAccount(myAccount);
        assertEquals(accountsInJsonFormat, jsonUtil.JavaToJson(accountService.getAccounts()));
    }

    @org.junit.Test
    public void JsonToJavaTest() {
        accountService.addAccount(myAccount);
        Map<String, Account> testAccounts = jsonUtil.JsonToJava("{\"Saber\":{\"firstName\":\"Saber\",\"lastName\":\"Hamidi\",\"accountNumber\":35352345}}", HashMap.class);
        assertEquals(1, testAccounts.size());
    }

}