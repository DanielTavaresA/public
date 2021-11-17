class BankAccount {


    public BankAccount(CurrencyType currencyType, double amount) {
        this.currencyType = currencyType;
        this.amount = amount;
    }

    private CurrencyType currencyType;
    private double amount;
    private CurrencyConverter converter;




    public boolean add(CurrencyType addedType, double addedAmount) {
        double inCurrency = converter.convert(addedType, currencyType, addedAmount);
        amount += inCurrency;
        return true;
    }

    public boolean remove(CurrencyType removedType, double removedAmount) {
        double inCurrency = converter.convert(removedType, currencyType, removedAmount);
        amount -= inCurrency;
        return true;
    }

    public CurrencyType getCurrencyType() {
        return currencyType;
    }

    public double getAmount() {
        return amount;
    }
}

public class App {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(CurrencyType.EURO, 9001);
        account.add(CurrencyType.DOLLAR, 100);
        account.remove(CurrencyType.POUND, 10);
        System.out.println("Balance: " + account.getAmount());
    }
}
