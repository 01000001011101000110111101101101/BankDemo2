import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Customer> customers = new ArrayList<>(5000);

    public Bank(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }

    private Customer getCustomer(String customerName) {
      for (var customer : customers) {
          if (customer.name().equalsIgnoreCase(customerName)) {
              return customer;
          }
      }
        System.out.printf("(%s) Not found...", customerName);
        return null;
    }
    public void addNewCustomer(String customerName, double initialDepositAmount){
        if (getCustomer(customerName) == null) {
            Customer customer = new Customer(customerName, initialDepositAmount);
            customers.add(customer);
            System.out.println("New customer added. " + customer);
        }
    }
    public void addTransaction(String name, double  transactionAmount) {
        Customer customer = getCustomer(name);
        if (customer != null) {
            customer.transactions().add(transactionAmount);
        }
    }
    public void printStatement(String customerName){
        Customer customer = getCustomer(customerName);
        if (customer == null) {
            return;
        }
        System.out.println("-".repeat(20));
        System.out.println("Customer name: " + customer.name());
        System.out.println("Transactions:");
        for (double d : customer.transactions()) {
            System.out.printf("$%10.2f (%s)%n", d, d < 0 ? "debit" : "credit");
        }
    }
}