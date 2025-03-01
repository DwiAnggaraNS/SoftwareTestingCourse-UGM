import org.junit.jupiter.api.*;
import org.junit.platform.commons.annotation.Testable;

import static org.junit.jupiter.api.Assertions.*;

class TransactionSystemTest {

    private static TransactionSystem transactionSystem;

    @BeforeAll
    static void setUpClass(){
        TransactionSystem.openConnection();

        transactionSystem = new TransactionSystem(500000);
    }

    @BeforeEach
    void setUpMethod(){
        transactionSystem.resetBalance(100000);
    }

    @Test
    void testDeposit(){
        transactionSystem.deposit(100000);
        assertEquals(200000, transactionSystem.getBalance(),
                "Saldo seharusnya bertambah 100000 setelah deposit 100000");
    }

    @Test
    void testWithdraw(){
        transactionSystem.withdraw(50000);
        assertEquals(50000, transactionSystem.getBalance(),
                "Saldo seharusnya berkurang 50000 setelah withdraw 50000");
    }

    @AfterEach
    void tearDownMethod(){
        System.out.println("Saldo akhir setelah test: " + transactionSystem.getBalance());
    }

    @AfterAll
    static void cleanUp(){
        TransactionSystem.closeConnection();
    }


}