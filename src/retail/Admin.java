package retail;
import java.util.ArrayList;
public class Admin implements Login {
    private String name;
    private String password;
    public Admin() {
    }
    public Admin(String name, String password) {
        this.name = name;
        this.password = password;
    }
    @Override
    public boolean isLoginSuccessful(String name, String password) {
        if (!name.equals("Admin"))
            return false;
        if (!password.equals("Admin"))
            return false;
        return true;
    }
    public boolean addCustomer(ArrayList<Customer> list, Customer customer){
        GenericAction<Customer> ga = new GenericAction<>();
        boolean b = ga.add(list, customer);
        return b;
    }
    public boolean editCustomer(ArrayList<Customer> list, Customer customer){
        GenericAction<Customer> ga = new GenericAction<>();
        boolean b = ga.edit(list, customer);
        return b;
    }
    public boolean deleteCustomer(ArrayList<Customer> list, String customerId){
        GenericAction<Customer> ga = new GenericAction<>();
        boolean b = ga.delete(list, customerId);
        return b;
    }

    public Customer searchCustomer(ArrayList<Customer> list, String customerId){
        GenericAction<Customer> ga = new GenericAction<>();
        Customer c = ga.search(list, customerId);
        return c;
    }
    public boolean viewCustomer(ArrayList<Customer> list){
        GenericAction<Customer> ga = new GenericAction<>();
        Boolean b = ga.view(list, new Customer());
        return b;
    }
    public boolean addProduct(ArrayList<Product> list, Product product){
        GenericAction<Product> ga = new GenericAction<>();
        boolean b = ga.add(list, product);
        return b;
    }
    public boolean editProduct(ArrayList<Product> list, Product product){
        GenericAction<Product> ga = new GenericAction<>();
        boolean b = ga.edit(list, product);
        return b;
    }
    public boolean deleteProduct(ArrayList<Product> list, String productId){
        GenericAction<Product> ga = new GenericAction<>();
        boolean b = ga.delete(list, productId);
        return b;
    }
    public Product searchProduct(ArrayList<Product> list, String productId){
        GenericAction<Product> ga = new GenericAction<>();
        Product p = ga.search(list, productId);
        return p;
    }
    public boolean viewProduct(ArrayList<Product> list){
        GenericAction<Product> ga = new GenericAction<>();
        Boolean b = ga.view(list, new Product());
        return b;
    }
    public boolean addOrder(ArrayList<Order> list, Order order, ArrayList<Product> products){
        GenericAction<Order> ga = new GenericAction<>();
        boolean b = ga.add(list, order);
        order.addItems(products);
        double total = ga.cost(products);
        order.setCost(total);
        return b;
    }
    public boolean editOrder(ArrayList<Order> list, Order order){
        GenericAction<Order> ga = new GenericAction<>();
        boolean b = ga.edit(list, order);
        return b;
    }
    public boolean deleteOrder(ArrayList<Order> list, String orderId){
        GenericAction<Order> ga = new GenericAction<>();
        boolean b = ga.delete(list, orderId);
        return b;
    }
    public Order searchOrder(ArrayList<Order> list, String orderId){
        GenericAction<Order> ga = new GenericAction<>();
        Order o = ga.search(list, orderId);
        return o;
    }
    public boolean viewOrder(ArrayList<Order> list, ArrayList<Product> products) {
        GenericAction<Order> ga = new GenericAction<>();
        boolean b = ga.view(list, products);
        return b;
    }
}
