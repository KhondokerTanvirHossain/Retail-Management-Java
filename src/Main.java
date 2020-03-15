import retail.*;
import java.util.ArrayList;
import java.util.Scanner;
import static java.util.Objects.isNull;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Customer> customerList = new ArrayList<Customer>();
        ArrayList<Product> productList = new ArrayList<Product>();
        ArrayList<Order> orderList = new ArrayList<Order>();
        while (true){
            System.out.println("Are you a .....? \n 0.exit \n 1.Admin \n 2.Customer");
            int user = sc.nextInt();
            if(user == 0)
                break;
            if (user == 1){
                Admin admin = loginAsAdmin();
                if (isNull(admin))
                    continue;
                while (true){
                    System.out.println("Choose a section: \n 0. Back \n 1.Customer \n 2.Product \n 3.Order");
                    int section = sc.nextInt();
                    if (section == 0)
                        break;
                    while (true){
                        System.out.println("Choose a Task: \n 0. Back \n 1.Add \n 2.Edit \n 3.Delete \n 4.View \n 5.Search");
                        int task = sc.nextInt();
                        if (task == 0)
                            break;
                        if (section == 1){
                            if (task == 1){
                                addNewCustomer(admin, customerList);
                            }
                            else if (task == 2){
                                editOldCustomer(admin, customerList);
                            }
                            else if (task == 3){
                                deleteOldCustomer(admin, customerList);
                            }
                            else if (task == 4){
                                viewOldCustomer(admin, customerList);
                            }
                            else if (task == 5){
                                searchOldCustomer(admin, customerList);
                            }
                        }
                        else if (section == 2){
                            if (task == 1){
                                addNewProduct(admin, productList);
                            }
                            else if (task == 2){
                                editOldProduct(admin, productList);
                            }
                            else if (task == 3){
                                deleteOldProduct(admin, productList);
                            }
                            else if (task == 4){
                                viewOldProduct(admin, productList);
                            }
                            else if (task == 5){
                                searchOldProduct(admin, productList);
                            }
                        }
                        else if (section == 3){
                            if (task == 1){
                                addNewOrder(admin, orderList, productList);
                            }
                            else if (task == 2){
                                editOldOrder(admin, orderList);
                            }
                            else if (task == 3){
                                deleteOldOrder(admin, orderList);
                            }
                            else if (task == 4){
                                viewOldOrder(admin, orderList, productList);
                            }
                            else if (task == 5){
                                searchOldOrder(admin, orderList);
                            }
                        }
                    }
                }
            }
            if (user == 2){
                Customer customer = loginAsCustomer(customerList);
                if (isNull(customer))
                    continue;
                while (true){
                    System.out.println("Choose a Task: \n 0. Back \n 1.Order");
                    int task = sc.nextInt();
                    if (task == 0)
                        break;
                    if (task == 1){
                        placeOrder(customer, orderList, productList);
                    }
                }
            }
        }

    }
    static Admin loginAsAdmin(){
        System.out.print("NAME : ");
        String name = sc.next();
        System.out.print("PASSWORD : ");
        String password = sc.next();
        Admin admin = new Admin(name, password);
        if (admin.isLoginSuccessful(name, password))
            return admin;
        else{
            System.out.println("WRONG ADMIN NAME OR PASSWORD !");
            return null;
        }
    }
    static Customer loginAsCustomer(ArrayList<Customer> customers){
        System.out.print("NAME : ");
        String name = sc.next();
        System.out.print("PASSWORD : ");
        String password = sc.next();
        for (Customer customer : customers){
            if (customer.isLoginSuccessful(name, password))
                return customer;
        }
        System.out.println("WRONG CUSTOMER NAME OR PASSWORD !");
        return null;
    }
    static void addNewCustomer(Admin admin, ArrayList<Customer> customerList){
        System.out.print("Customer id : ");
        String stringId = sc.next();
        System.out.print("Customer name : ");
        String stringName = sc.next();
        System.out.print("Customer password : ");
        String stringPassword = sc.next();
        System.out.print("Customer Address : ");
        String stringAddress = sc.next();
        System.out.print("Customer contact : ");
        String stringContact = sc.next();
        Boolean b = admin.addCustomer(customerList, new Customer(stringId, stringName, stringPassword, stringAddress, stringContact));
        if (b)
            System.out.println("Successful !");
        else
            System.out.println("Failed, May be customer ID is already taken !!!");
    }
    static void editOldCustomer(Admin admin, ArrayList<Customer> customerList){
        System.out.print("Customer id : ");
        String stringId = sc.next();
        System.out.print("Customer name : ");
        String stringName = sc.next();
        System.out.print("Customer password : ");
        String stringPassword = sc.next();
        System.out.print("Customer Address : ");
        String stringAddress = sc.next();
        System.out.print("Customer contact : ");
        String stringContact = sc.next();
        Boolean b = admin.editCustomer(customerList, new Customer(stringId, stringName, stringPassword, stringAddress, stringContact));
        if (b)
            System.out.println("Successful !");
        else
            System.out.println("Failed, May be wrong Customer ID !!!");
    }
    static void deleteOldCustomer(Admin admin, ArrayList<Customer> customers){
        System.out.print("Customer ID : ");
        String customerId = sc.next();
        Boolean b = admin.deleteCustomer(customers, customerId);
        if (b) {
            System.out.println("Successful !");
            return;
        }
        else
            System.out.println("Failed, May be Customer wrong ID !!!");
    }
    static void viewOldCustomer(Admin admin, ArrayList<Customer> customers){
        Boolean b = admin.viewCustomer(customers);
        if (b) {
            System.out.println("Successful !");
            return;
        }
        else
            System.out.println("Failed, May be Customer list is empty !!!");
    }
    static void searchOldCustomer(Admin admin, ArrayList<Customer> customers){
        System.out.print("Customer ID : ");
        String customerId = sc.next();
        Customer customer = admin.searchCustomer(customers, customerId);
        if (customer != null)
            System.out.println(" Name : " + customer.getName() + " Address : " + customer.getAddress() + " Contact : " + customer.getContactNumber());
        else
            System.out.println("Failed, May be Wrong Customer ID !!!");
    }
    static void addNewProduct(Admin admin, ArrayList<Product> products){
        System.out.print("Product id : ");
        String stringId = sc.next();
        System.out.print("Product name : ");
        String stringName = sc.next();
        System.out.print("Product Rate : ");
        Double doubleRate = sc.nextDouble();
        System.out.print("Fragile(Y/N) : ");
        String fragile = sc.next();
        boolean bF = true;
        if (fragile.equals("Y") || fragile.equals("y"))
            bF = true;
        else
            bF = false;
        Boolean b = admin.addProduct(products, new Product(stringId, stringName, doubleRate, bF));
        if (b)
            System.out.println("Successful !");
        else
            System.out.println("Failed, May be customer ID is already taken !!!");
    }
    static void editOldProduct(Admin admin, ArrayList<Product> products){
        System.out.print("Product id : ");
        String stringId = sc.next();
        System.out.print("Product name : ");
        String stringName = sc.next();
        System.out.print("Product rate : ");
        Double doubleRate = sc.nextDouble();
        System.out.print("Fragile(Y/N) : ");
        String fragile = sc.next();
        boolean bF = true;
        if (fragile.equals("Y") || fragile.equals("y"))
            bF = true;
        else
            bF = false;
        Boolean b = admin.editProduct(products, new Product(stringId, stringName, doubleRate, bF));
        if (b)
            System.out.println("Successful !");
        else
            System.out.println("Failed, May be wrong Customer ID !!!");
    }
    static void deleteOldProduct(Admin admin, ArrayList<Product> products){
        System.out.print("Product ID : ");
        String productId = sc.next();
        Boolean b = admin.deleteProduct(products, productId);
        if (b) {
            System.out.println("Successful !");
            return;
        }
        else
            System.out.println("Failed, May be Product wrong ID !!!");
    }
    static void viewOldProduct(Admin admin, ArrayList<Product> products){
        Boolean b = admin.viewProduct(products);
        if (b) {
            System.out.println("Successful !");
            return;
        }
        else
            System.out.println("Failed, May be Product list is empty !!!");
    }
    static void searchOldProduct(Admin admin, ArrayList<Product> products){
        System.out.print("Product ID : ");
        String productId = sc.next();
        Product product = admin.searchProduct(products, productId);
        if (product != null)
            System.out.println(" Name : " + product.getName() + " Rate : " + product.getRate());
        else
            System.out.println("Failed, May be Wrong Customer ID !!!");
    }
    static void addNewOrder(Admin admin, ArrayList<Order> orders, ArrayList<Product> products){
        System.out.print("Order id : ");
        String stringId = sc.next();
        System.out.print("Customer id : ");
        String stringCustomerId = sc.next();
        System.out.print("Number of Orders: ");
        int intOrderNumber = sc.nextInt();
        ArrayList<Product> newProducts = new ArrayList<Product>();
        System.out.println("You choose to buy " + intOrderNumber + " products");
        sc = new Scanner(System.in);
        for (int i = 0; i < intOrderNumber; i++){
            System.out.println("Which product do you want to buy next?");
            String s = sc.next();
            int count = 0;
            for (Product p : products){
                if (p.getName().equals(s)) {
                    newProducts.add(p);
                    break;
                }
                count++;
            }
            if (count == intOrderNumber){
                System.out.println("You gave incorrect product name, Try Again!");
                --i;
            }
        }
        Boolean b = admin.addOrder(orders, new Order(stringId, stringCustomerId, intOrderNumber), newProducts);
        if (b)
            System.out.println("Successful !");
        else
            System.out.println("Failed, May be order ID is already taken !!!");
    }
    static void editOldOrder(Admin admin, ArrayList<Order> orders){
        System.out.print("Order id : ");
        String stringId = sc.next();
        System.out.print("Customer id : ");
        String stringCustomerId = sc.next();
        System.out.print("Number of order : ");
        int orderNumber = sc.nextInt();

        Boolean b = admin.editOrder(orders, new Order(stringId, stringCustomerId, orderNumber));
        if (b)
            System.out.println("Successful !");
        else
            System.out.println("Failed, May be wrong Order ID !!!");
    }
    static void deleteOldOrder(Admin admin, ArrayList<Order> orders){
        System.out.print("Order ID : ");
        String orderId = sc.next();
        Boolean b = admin.deleteOrder(orders, orderId);
        if (b) {
            System.out.println("Successful !");
            return;
        }
        else
            System.out.println("Failed, May be Order wrong ID !!!");
    }
    static void viewOldOrder(Admin admin, ArrayList<Order> orders, ArrayList<Product> products){
        Boolean b = admin.viewOrder(orders, products);
        if (b) {
            System.out.println("Successful !");
            return;
        }
        else
            System.out.println("Failed, May be Order list is empty !!!");
    }
    static void searchOldOrder(Admin admin, ArrayList<Order> orders){
        System.out.print("Order ID : ");
        String orderId = sc.next();
        Order order = admin.searchOrder(orders, orderId);
        if (order != null)
            System.out.println(" Customer ID : " + order.getCustomerId() + " Number of Orders : " + order.getItemNumber());
        else
            System.out.println("Failed, May be Wrong Customer ID !!!");
    }
    static void placeOrder(Customer customer, ArrayList<Order> orders, ArrayList<Product> products){
        System.out.print("Order id : ");
        String stringId = sc.next();
        System.out.print("Customer id : ");
        String stringCustomerId = sc.next();
        System.out.print("Number of Orders: ");
        int intOrderNumber = sc.nextInt();
        ArrayList<Product> newProducts = new ArrayList<Product>();
        System.out.println("You choose to buy " + intOrderNumber + " products");
        sc = new Scanner(System.in);
        for (int i = 0; i < intOrderNumber; i++){
            System.out.println("Which product do you want to buy next?");
            String s = sc.next();
            int count = 0;
            for (Product p : products){
                if (p.getName().equals(s)) {
                    newProducts.add(p);
                    break;
                }
                count++;
            }
            if (count == intOrderNumber){
                System.out.println("You gave incorrect product name, Try Again!");
                --i;
            }
        }
        Boolean b = customer.addOrder(orders, new Order(stringId, stringCustomerId, intOrderNumber), newProducts);
        if (b)
            System.out.println("Successful !");
        else
            System.out.println("Failed, May be order ID is already taken !!!");
    }
}
