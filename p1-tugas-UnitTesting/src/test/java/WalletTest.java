import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {

    // Test total coin method
    @Test
    void testTotalCoin() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // Check if total coin is 0:
        assertEquals(0, wallet_dwi.calculateTotalCoin());

        // Add 100 coin 3 times:
        wallet_dwi.addCoin(100);
        wallet_dwi.addCoin(100);
        wallet_dwi.addCoin(100);

        // Add 200 coin 1 time:
        wallet_dwi.addCoin(200);

        // Add 500 coin 2 times:
        wallet_dwi.addCoin(500);
        wallet_dwi.addCoin(500);

        // Check
        assertEquals(1500, wallet_dwi.calculateTotalCoin());
    }

    // Test total banknote method
    @Test
    void testTotalBanknote() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // Check if total banknote is 0:
        assertEquals(0, wallet_dwi.calculateTotalBanknote());

        // Add 1000 banknote 3 times:
        wallet_dwi.addBanknote(1000);
        wallet_dwi.addBanknote(1000);
        wallet_dwi.addBanknote(1000);

        // Add 2000 banknote 1 time:
        wallet_dwi.addBanknote(2000);

        // Add 5000 banknote 1 time:
        wallet_dwi.addBanknote(5000);

        // Add 10000 banknote 2 times:
        wallet_dwi.addBanknote(10000);
        wallet_dwi.addBanknote(10000);

        // Add 20000 banknote 1 time:
        wallet_dwi.addBanknote(20000);

        // Add 50000 banknote 1 time:
        wallet_dwi.addBanknote(50000);

        // Add 100000 banknote 2 time:
        wallet_dwi.addBanknote(100000);
        wallet_dwi.addBanknote(100000);

        // Check
        assertEquals(300000, wallet_dwi.calculateTotalBanknote());
    }

    @Test
    void testShowTotalMoney() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // Add 1000 banknote 3 times:
        wallet_dwi.addBanknote(1000);
        wallet_dwi.addBanknote(1000);
        wallet_dwi.addBanknote(1000);

        // Add 200 coin 1 time:
        wallet_dwi.addCoin(200);

        // Check
        assertEquals(3200, wallet_dwi.showTotalMoney());
    }

    // Test constructor
    @Test
    void testConstructor() {
        Wallet wallet_dwi = new Wallet("Dwi");
        assertEquals("Dwi", wallet_dwi.owner);
        assertEquals(0, wallet_dwi.showTotalMoney());
    }

    // Test addCard
    @Test
    void testAddCard() {
        Wallet wallet_dwi = new Wallet("Dwi");
        wallet_dwi.addCard("BCA", "1234567890");
        wallet_dwi.addCard("BNI", "0987654321");
        assertEquals(2, wallet_dwi.cards.size());
    }

    // Test getCard
    @Test
    void testGetCard() {
        Wallet wallet_dwi = new Wallet("Dwi");
        wallet_dwi.addCard("BCA", "1234567890");
        wallet_dwi.addCard("BNI", "0987654321");
        wallet_dwi.getCard(0);
        assertEquals(1, wallet_dwi.cards.size());
    }

    // Test tyoes of money
    @Test
    void testCheckTypesOfMoney_Coin() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // Check if 100 is a coin value:
        assertEquals(Wallet.MoneyType.COIN, wallet_dwi.checkTypesOfMoney(100));
        // Check if 200 is a coin value:
        assertEquals(Wallet.MoneyType.COIN, wallet_dwi.checkTypesOfMoney(200));
        // Check if 500 is a coin value:
        assertEquals(Wallet.MoneyType.COIN, wallet_dwi.checkTypesOfMoney(500));
    }

    @Test
    void testCheckTypesOfMoney_Banknote() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // Check if 1000 is a banknote value:
        assertEquals(Wallet.MoneyType.BANKNOTE, wallet_dwi.checkTypesOfMoney(1000));
        // Check if 2000 is a banknote value:
        assertEquals(Wallet.MoneyType.BANKNOTE, wallet_dwi.checkTypesOfMoney(2000));
        // Check if 5000 is a banknote value:
        assertEquals(Wallet.MoneyType.BANKNOTE, wallet_dwi.checkTypesOfMoney(5000));
        // Check if 10000 is a banknote value:
        assertEquals(Wallet.MoneyType.BANKNOTE, wallet_dwi.checkTypesOfMoney(10000));
        // Check if 20000 is a banknote value:
        assertEquals(Wallet.MoneyType.BANKNOTE, wallet_dwi.checkTypesOfMoney(20000));
        // Check if 50000 is a banknote value:
        assertEquals(Wallet.MoneyType.BANKNOTE, wallet_dwi.checkTypesOfMoney(50000));
        // Check if 100000 is a banknote value:
        assertEquals(Wallet.MoneyType.BANKNOTE, wallet_dwi.checkTypesOfMoney(100000));
    }

    @Test
    void testCheckTypesOfMoney_Invalid() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // Invalid money value should return null
        assertNull(wallet_dwi.checkTypesOfMoney(696969));
    }

    @Test
    void testAddCoin() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // Add 100 coin 4 times:
        wallet_dwi.addCoin(100);
        wallet_dwi.addCoin(100);
        wallet_dwi.addCoin(100);
        wallet_dwi.addCoin(100);

        //Add 200 coin 1 time:
        wallet_dwi.addCoin(200);

        // Add 500 coin 2 time:
        wallet_dwi.addCoin(500);
        wallet_dwi.addCoin(500);

        // Add invalid money value:
        wallet_dwi.addCoin(696969);

        // Check
        assertEquals(4, wallet_dwi.coinCount.get(100));
        assertEquals(1, wallet_dwi.coinCount.get(200));
        assertEquals(2, wallet_dwi.coinCount.get(500));

        // Check if invalid money value is not added:
        assertNull(wallet_dwi.coinCount.get(696969));
    }

    @Test
    void testAddBanknote() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // Add 1000 banknote 3 times:
        wallet_dwi.addBanknote(1000);
        wallet_dwi.addBanknote(1000);
        wallet_dwi.addBanknote(1000);

        // Add 2000 banknote 1 time:
        wallet_dwi.addBanknote(2000);

        // Add 5000 banknote 1 time:
        wallet_dwi.addBanknote(5000);

        // Add 10000 banknote 2 times:
        wallet_dwi.addBanknote(10000);
        wallet_dwi.addBanknote(10000);

        // Add 20000 banknote 1 time:
        wallet_dwi.addBanknote(20000);

        // Add 50000 banknote 1 time:
        wallet_dwi.addBanknote(50000);

        // Add 100000 banknote 2 time:
        wallet_dwi.addBanknote(100000);
        wallet_dwi.addBanknote(100000);

        // Add invalid money value:
        wallet_dwi.addBanknote(696969);

        // Check
        assertEquals(3, wallet_dwi.banknoteCount.get(1000));
        assertEquals(1, wallet_dwi.banknoteCount.get(2000));
        assertEquals(1, wallet_dwi.banknoteCount.get(5000));
        assertEquals(2, wallet_dwi.banknoteCount.get(10000));
        assertEquals(1, wallet_dwi.banknoteCount.get(20000));
        assertEquals(1, wallet_dwi.banknoteCount.get(50000));
        assertEquals(2, wallet_dwi.banknoteCount.get(100000));

        // Check if invalid money value is not added:
        assertNull(wallet_dwi.banknoteCount.get(696969));

    }


    @Test
    void testCheckAvailableMoney_True() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // First, add a few coin:
        wallet_dwi.addCoin(100);
        wallet_dwi.addCoin(200);

        // Then, check if 100 is available:
        assertTrue(wallet_dwi.checkAvailableMoney(100, Wallet.MoneyType.COIN));
        // And check if 200 is available:
        assertTrue(wallet_dwi.checkAvailableMoney(200, Wallet.MoneyType.COIN));

        // First, add a few banknote:
        wallet_dwi.addBanknote(1000);
        wallet_dwi.addBanknote(2000);

        // Then, check if 1000 is available:
        assertTrue(wallet_dwi.checkAvailableMoney(1000, Wallet.MoneyType.BANKNOTE));
        // And check if 2000 is available:
        assertTrue(wallet_dwi.checkAvailableMoney(2000, Wallet.MoneyType.BANKNOTE));
    }


    @Test
    void testCheckAvailableMoney_False() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // First, add a few coin :
        wallet_dwi.addCoin(100);
        wallet_dwi.addCoin(500);

        // Then, check if 100000 is available:
        assertFalse(wallet_dwi.checkAvailableMoney(200, Wallet.MoneyType.COIN));

        // First, add a few banknote: :
        wallet_dwi.addBanknote(10000);
        wallet_dwi.addBanknote(5000);

        // Then, check if 100000 is available:
        assertFalse(wallet_dwi.checkAvailableMoney(2000, Wallet.MoneyType.BANKNOTE));
        assertFalse(wallet_dwi.checkAvailableMoney(20000, Wallet.MoneyType.BANKNOTE));
    }

    @Test
    void testWithdrawCoin() {

        // walletDwiForTestingCoinAndBanknote has:
        Wallet wallet_dwi = new Wallet("Dwi");

        // First, add 100 coin 3 times:
        wallet_dwi.addCoin(100);
        wallet_dwi.addCoin(100);
        wallet_dwi.addCoin(100);

        // Add 200 coin 1 time:
        wallet_dwi.addCoin(200);

        // Add 500 coin 2 times:
        wallet_dwi.addCoin(500);
        wallet_dwi.addCoin(500);

        // Withdraw 100 coin 2 times from walletDwiForTestingCoinAndBanknote:
        wallet_dwi.withdrawCoin(100);
        wallet_dwi.withdrawCoin(100);
        // Then, withdraw 200 coin 1 time:
        wallet_dwi.withdrawCoin(200);
        // Then, withdraw 500 coin 1 time:
        wallet_dwi.withdrawCoin(500);

        // Check
        assertEquals(1, wallet_dwi.coinCount.get(100));
        assertEquals(0, wallet_dwi.coinCount.get(200));
        assertEquals(1, wallet_dwi.coinCount.get(500));

    }

    @Test
    void testWithdrawBanknote() {
        Wallet wallet_dwi = new Wallet("Dwi");

        // First, add 1000 banknote 3 times:
        wallet_dwi.addBanknote(1000);
        wallet_dwi.addBanknote(1000);
        wallet_dwi.addBanknote(1000);
        // Add 2000 banknote 1 time:
        wallet_dwi.addBanknote(2000);
        // Add 5000 banknote 1 time:
        wallet_dwi.addBanknote(5000);
        // Add 10000 banknote 2 times:
        wallet_dwi.addBanknote(10000);
        wallet_dwi.addBanknote(10000);
        // Add 20000 banknote 1 time:
        wallet_dwi.addBanknote(20000);
        // Add 50000 banknote 1 time:
        wallet_dwi.addBanknote(50000);
        // Add 100000 banknote 2 time:
        wallet_dwi.addBanknote(100000);
        wallet_dwi.addBanknote(100000);

        // Withdraw 1000 banknote 2 times from walletDwiForTestingCoinAndBanknote:
        wallet_dwi.withdrawBanknote(1000);
        wallet_dwi.withdrawBanknote(1000);
        // Then, withdraw 2000 banknote 1 time:
        wallet_dwi.withdrawBanknote(2000);
        // Then, withdraw 5000 banknote 1 time:
        wallet_dwi.withdrawBanknote(5000);
        // Then, withdraw 10000 banknote 1 time:
        wallet_dwi.withdrawBanknote(10000);
        // Then, withdraw 20000 banknote 1 time:
        wallet_dwi.withdrawBanknote(20000);
        // Then, withdraw 100000 banknote 1 time:
        wallet_dwi.withdrawBanknote(100000);

        // Check
        assertEquals(1, wallet_dwi.banknoteCount.get(1000));
        assertEquals(0, wallet_dwi.banknoteCount.get(2000));
        assertEquals(0, wallet_dwi.banknoteCount.get(5000));
        assertEquals(1, wallet_dwi.banknoteCount.get(10000));
        assertEquals(0, wallet_dwi.banknoteCount.get(20000));
        assertEquals(1, wallet_dwi.banknoteCount.get(50000));
        assertEquals(1, wallet_dwi.banknoteCount.get(100000));
    }
}