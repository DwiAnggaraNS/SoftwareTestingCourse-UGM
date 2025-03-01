import java.util.ArrayList;
import java.util.HashMap;

public class Wallet {

    // Inner class Card:
    public class Card{
        private String cardName;
        private String cardNumber;

        public Card(String cardName, String cardNumber){
            this.cardName = cardName;
            this.cardNumber = cardNumber;
        }

        public String getCardName(){
            return cardName;
        }

        public String getCardNumber(){
            return cardNumber;
        }
    }

    String owner;
    ArrayList<Card> cards = new ArrayList<Card>();

    // List coin values in IDR:
    int[] coinValues = {100, 200, 500};
    // HashMap of coin count in wallet:
    HashMap<Integer, Integer> coinCount = new HashMap<Integer, Integer>();

    // List banknote (uang lembaran) values in IDR:
    int[] banknoteValues = {1000, 2000, 5000, 10000, 20000, 50000, 100000};
    // HashMap of coin count in wallet:
    HashMap<Integer, Integer> banknoteCount = new HashMap<Integer, Integer>();

    // Enum for money type:
    public enum MoneyType {
        COIN,
        BANKNOTE
    }

    // Constructor (fungsi untuk set data owner wallet):
    public Wallet(String owner) {
        this.owner = owner;

        // Initialize coin count in wallet:
        for (int coinValue : coinValues) {
            coinCount.put(coinValue, 0);
        }

        // Initialize banknote count in wallet:
        for (int banknoteValue : banknoteValues) {
            banknoteCount.put(banknoteValue, 0);
        }
    }

    // --METHODS--
    // Add card to wallet:
    public void addCard(String cardName, String cardNumber) {
        Card card = new Card(cardName, cardNumber);
        cards.add(card);
    }

    // Get card from wallet:
    public void getCard(int index) {
        cards.remove(index);
    }

    // Function to check types of money that will be added to wallet:
    public MoneyType checkTypesOfMoney(int moneyValue) {
        // Loop through coin values:
        for (int coinValue : coinValues) {
            // Check if moneyValue is a coin value:
            if (moneyValue == coinValue) {
                return MoneyType.COIN;
            }
        }

        // Loop through banknote values:
        for (int banknoteValue : banknoteValues) {
            // Check if moneyValue is a banknote value:
            if (moneyValue == banknoteValue) {
                return MoneyType.BANKNOTE;
            }
        }

        // If moneyValue is not a coin or banknote value:
        return null;
    }

    // Add coin to wallet:
    public void addCoin(int coinValue) {
        // Check if coinValue is a coin value:
        if (checkTypesOfMoney(coinValue) == MoneyType.COIN) {
            coinCount.put(coinValue, coinCount.get(coinValue) + 1);
        } else if (checkTypesOfMoney(coinValue) == MoneyType.BANKNOTE) {
            System.out.println("Banknote cannot be added as coin!");
        } else {
            System.out.println("Invalid money value!");
        }
    }

    // Add banknote to wallet:
    public void addBanknote(int banknoteValue) {
        // Check if banknoteValue is a banknote value:
        if (checkTypesOfMoney(banknoteValue) == MoneyType.BANKNOTE) {
            banknoteCount.put(banknoteValue, banknoteCount.get(banknoteValue) + 1);
        } else if (checkTypesOfMoney(banknoteValue) == MoneyType.COIN) {
            System.out.println("Coin cannot be added as banknote!");
        } else {
            System.out.println("Invalid money value!");

        }
    }



    // Check available coin & banknote in wallet:
    public boolean checkAvailableMoney(int moneyValue, MoneyType moneyType) {
        // Check if moneyValue is a coin value:
        if (moneyType.equals(MoneyType.COIN) ) {
            // count total coin from wallet that will be withdrawn:
            for (int coinValue : coinValues) {
                if (coinValue == moneyValue) {
                    return coinCount.get(coinValue) > 0;
                }
            }
            System.out.println("Coin value is not available in wallet!");
            return false;
        }

        // Check if moneyValue is a banknote value:
        else if (moneyType.equals(MoneyType.BANKNOTE)) {
            // count total coin from wallet that will be withdrawn:
            for (int banknoteValue : banknoteValues) {
                if (banknoteValue == moneyValue) {
                    return banknoteCount.get(banknoteValue) > 0;
                }
            }
            System.out.println("Banknote value is not available in wallet!");
            return false;
        }

        // If moneyValue is not a coin or banknote value:
        System.out.println("Invalid money value!");
        return false;
    }

    // Withdraw coin from wallet:
    public void withdrawCoin(int coinValue) {
        // Check if coinValue is a coin value:
        if (checkTypesOfMoney(coinValue) == MoneyType.COIN) {
            // Check if coinValue is available in wallet:
            if (checkAvailableMoney(coinValue, MoneyType.COIN)) {
                coinCount.put(coinValue, coinCount.get(coinValue) - 1);
            } else {
                System.out.println("Coin value is not available in wallet!");
            }
        } else if (checkTypesOfMoney(coinValue) == MoneyType.BANKNOTE) {
            System.out.println("Banknote cannot be withdrawn as coin!");
        } else {
            System.out.println("Invalid money value!");
        }
    }

    // Withdraw banknote from wallet:
    public void withdrawBanknote(int banknoteValue) {
        // Check if banknoteValue is a banknote value:
        if (checkTypesOfMoney(banknoteValue) == MoneyType.BANKNOTE) {
            // Check if banknoteValue is available in wallet:
            if (checkAvailableMoney(banknoteValue, MoneyType.BANKNOTE)) {
                banknoteCount.put(banknoteValue, banknoteCount.get(banknoteValue) - 1);
            } else {
                System.out.println("Banknote value is not available in wallet!");
            }
        } else if (checkTypesOfMoney(banknoteValue) == MoneyType.COIN) {
            System.out.println("Coin cannot be withdrawn as banknote!");
        } else {
            System.out.println("Invalid money value!");
        }
    }

    // Count total coin in wallet:
    public int calculateTotalCoin() {
        int totalCoin = 0;
        // Calculate total money from coins:
        for (int coinValue : coinValues) {
            totalCoin += coinValue * coinCount.get(coinValue);
        }
        return totalCoin;
    }

    // Count total banknote in wallet:
    public int calculateTotalBanknote() {
        int totalBanknote = 0;
        // Calculate total money from banknotes:
        for (int banknoteValue : banknoteValues) {
            totalBanknote += banknoteValue * banknoteCount.get(banknoteValue);
        }
        return totalBanknote;
    }

    // Show total money in wallet:
    public int showTotalMoney() {
        // Inform total money in wallet:
        return calculateTotalCoin() + calculateTotalBanknote();
    }

    // clear all attribute in wallet:
    public void clearWallet(){
        cards.clear();
        for (int coinValue : coinValues) {
            coinCount.put(coinValue, 0);
        }
        for (int banknoteValue : banknoteValues) {
            banknoteCount.put(banknoteValue, 0);
        }
    }
}

