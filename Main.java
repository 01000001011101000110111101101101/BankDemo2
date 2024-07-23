import java.util.ArrayList;

record Customer(String name, ArrayList<Double> transactions ){
    public Customer(String name, double initialDeposit) {
        this(name.toLowerCase(), new ArrayList<Double>(500));
        transactions.add(initialDeposit);
    }
}

public class Main {
    public static void main(String[] args) {
        Customer tom = new Customer("Tom F", 1000.0);
        System.out.println(tom);

        Bank bank = new Bank("Chase");
        bank.addNewCustomer("Jane B", 500.0);
        System.out.println(bank);

        bank.addTransaction("Jane B", -10.25);
        bank.addTransaction("Jane B", -75.01);
        bank.printStatement("Jane b");

        bank.addNewCustomer("tom f", 25);
        bank.addTransaction("Tom F", 100);
        bank.printStatement("Tom F");
    }
}