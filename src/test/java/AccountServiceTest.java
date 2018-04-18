import static org.junit.Assert.assertEquals;

public class AccountServiceTest {

    private Account account = new Account("Saber", "Hamidi", 4333553);
    private AccountService service = new AccountService();

    @org.junit.Test
    public void addAccountTest() {
        assertEquals(true, service.addAccount(account));
    }

    @org.junit.Test
    public void getAccountByNameTest() {
        service.addAccount(account);
        assertEquals("Saber", service.getAccountByName("Saber").getFirstName());
    }
}