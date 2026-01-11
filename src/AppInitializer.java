import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppInitializer{
    //DataBase Area
    static String [][] users=new String[3][2];
    static String [][] customers=new String[100][4];
    static String [][] items=new String[100][4];
    static String [][] orders=new String[100][5];



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean exitState=false;



        //program initialization
        String[] initializePageQuestions =
                {
                        "1) Do you want to login?",
                        "2) Are you new to here?",
                        "3)Do you want to exit the page?"
                };
        while (!exitState){

            for (String question : initializePageQuestions) {
                System.out.println(question);

            }
            int UserInput = input.nextInt();
            switch (UserInput){
                case 1:
                    users[0][0]="sajitha@gmail.com";
                    users[0][1]="123";
                    if (login ()){
                    printUi("Dashboard");
                    openDashboard();
                }{
                    printUi("Application");
                }break ;

                case 2: if(register ()){
                    openDashboard();}  break ;
                case 3: System.out.println("Goodbye!");
                    return ;
                default: System.out.println("Wrong  input");
                    return;
            }

        }


    }
    //login process
    public static boolean login(){
        Scanner input = new Scanner(System.in);
        printUi("Login ");
        System.out.println("Please enter your email:");
        String email=input.nextLine();
        System.out.println("Please enter your password:");
        String password=input.nextLine();

        for (int i = 0; i < users.length ; i++) {
            if(users[i][0]!=null && users[i][0].equals(email)  ){
                if(users[i][1].equals(password)){

                    System.out.println("Welcome again!");
                    return true;
                }else{
                    System.out.println("Wrong password");
                    return false;
                }

            }
        }

        System.out.println("404 email Not Found");
        return false;

    }
    //registration process
    public static boolean register(){
        Scanner input = new Scanner(System.in);

        if(users[users.length-1] [0]==null){
            System.out.println("User database is full");
            return false;
        }

        System.out.println("Insert your email:");
        String email=input.nextLine();
        System.out.println("Insert your password:");
        String password=input.nextLine();

        for (int i = 0; i < users.length ; i++) {
            if(users[i][0]==null){
                users[i][0]=email;
                users[i][1]=password;
                System.out.println("Registration successful");
                return true;
            }else {
                if (users[i][0].equalsIgnoreCase(email)){
                    System.out.println("This email is already registered");
                    return false;
                }
            }

        }
        return false;

    }

    //dashboard process
    public static void openDashboard(){
        Scanner input = new Scanner(System.in);
        String dashBoardOptions[]={
                "1) Customer Management",
                "2) Item Management",
                "3) Order Management",
                "4) Logout"
        };
        while (true){
            for (String option : dashBoardOptions) {
                System.out.println(option);

            }
            int UserInput = input.nextInt();

            switch (UserInput){
                case 1:
                    customerManagement();
                    break ;
                case 2:
                    itemManagement();
                    break ;
                case 3:
                    placeNewOrder();
                    break ;
                case 4:
                    
                    return ;
                default:
                    System.out.println("Wrong  input");
                    return;
            }
        }
    }


    //Item Management process
    private static void itemManagement() {
        Scanner input = new Scanner(System.in);
        String itemManagementOptions[]={
                "1) Save Item",
                "2) Find Item",
                "3) Update Item",
                "4) Delete Item",
                "5) Find All Items",
                "6) Back to Dashboard"
        };
        while (true){
            for (String option : itemManagementOptions) {
                System.out.println(option);
            }
            int UserInput = input.nextInt();
            switch (UserInput){
                case 1:
                    saveItem();
                    break;
                case 2:
                    findItem();
                    break;
                case 3:
                    updateItem();
                    break;
                case 4:
                    deleteItem();
                    break;
                case 5:
                    findAllItems();
                    break;
                case 6:
                    return;
                default:
                    return;
            }
        }
    }
    private static void saveItem() {
        //store item data
        Scanner input = new Scanner(System.in);
        while (true){
            String code, description;
            int qtyOnHand;
            double unitPrice;

            System.out.println("Enter Item Code:");
            code=input.nextLine();
            System.out.println("Enter Item Description:");
            description=input.nextLine();
            System.out.println("Enter Quantity On Hand:");
            qtyOnHand=input.nextInt();
            System.out.println("Enter Unit Price:");
            unitPrice=input.nextDouble();

            itemForLoop:
            for (int i = 0; i < items.length ; i++) {
                if(items[i][0]!=null){
                    if(items[i][0].equals(code)){
                        System.out.println("Item already exists");
                        break;
                    }
                }else {
                    items[i][0]=code;
                    items[i][1]=description;
                    items[i][2]=String.valueOf(qtyOnHand);
                    items[i][3]=String.valueOf(unitPrice);
                    System.out.println("Item saved successfully!\n");
                    System.out.println("1)Do you want to add another item? (yes/no)");
                    System.out.println("2)Back to Main Menu");
                    int option=input.nextInt();
                    input.nextLine(); // Consume newline
                    switch (option){
                        case 1:
                            break itemForLoop;
                        case 2:
                            return;
                        default:
                            System.out.println("Invalid option. Returning to Main Menu.");
                            return;
                    }
                }
            }
        }
    }

    private static void findItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Item Code to find:");
        String code=input.nextLine();
        for (int i = 0; i < items.length ; i++) {
            if(items[i][0]!=null && items[i][0].equals(code)) {

                System.out.println("Item Found:");
                System.out.println("==================Item Details==================");
                System.out.println("Code: " + items[i][0]);
                System.out.println("Description: " + items[i][1]);
                System.out.println("Quantity On Hand: " + items[i][2]);
                System.out.println("Unit Price: " + items[i][3]);
                System.out.println("=================================================");
                return;
            }

        }
        System.out.println("Item not found.");
    }

    private static void updateItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Item Code to update:");
        String code=input.nextLine();
        for (int i = 0; i < items.length ; i++) {
            if(items[i][0]!=null && items[i][0].equals(code)) {

                System.out.println("Enter new Description:");
                String description=input.nextLine();
                System.out.println("Enter new Quantity On Hand:");
                int qtyOnHand=input.nextInt();
                System.out.println("Enter new Unit Price:");
                double unitPrice=input.nextDouble();

                items[i][1]=description;
                items[i][2]=String.valueOf(qtyOnHand);
                items[i][3]=String.valueOf(unitPrice);

                System.out.println("Item updated successfully!");
                return;
            }
        }
        System.out.println("Item not found.");
    }

    private static void deleteItem() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Item Code to delete:");
        String code=input.nextLine();
        for (int i = 0; i < items.length ; i++) {
            if(items[i][0]!=null && items[i][0].equals(code)) {

                items[i][0]=null;
                items[i][1]=null;
                items[i][2]=null;
                items[i][3]=null;

                System.out.println("Item deleted successfully.");
                return;
            }

        }
        System.out.println("Item not found.");
    }

    private static void findAllItems() {
        System.out.println("All Items:");
        System.out.println("====================================================");
        for (int i = 0; i < items.length ; i++) {
            if(items[i][0]!=null) {

                System.out.println("Code: " + items[i][0]+"\tDescription: " + items[i][1]+"\tQty On Hand: " + items[i][2]+"\tUnit Price: " + items[i][3]);
            }else {
                return;
            }

        }
        System.out.println("====================================================");
    }


    //Customer Management process
public static void customerManagement(){
        Scanner input = new Scanner(System.in);
        String customerManagementOptions[]={
                "1) Save Customer",
                "2) Find Customers",
                "3) Update Customer",
                "4) Delete Customer",
                "5) Find All Customers",
                "6) Back to Dashboard"
        };
        while (true){
            for (String option : customerManagementOptions) {
                System.out.println(option);

            }
            int UserInput = input.nextInt();
            switch (UserInput){
                case 1:
                   saveCustomer();
                    break ;
                case 2:
                   findCustomer();
                    break ;
                case 3:
                    updateCustomer();
                    break ;
                case 4:
                    deleteCustomer();
                    break ;
                case 5:
                    findAllCustomers();
                    break ;
                case 6:

                    return ;
                default:
                    return;
            }
        }
}
    private static void saveCustomer() {
             //store customer data
        Scanner input = new Scanner(System.in);
        while (true){
            String nic,name,address;
            double salary;
            System.out.println("Enter Customer NIC:");
            nic=input.nextLine();
            System.out.println("Enter Customer Name:");
            name=input.nextLine();
            System.out.println("Enter Customer Address:");
            address=input.nextLine();
            System.out.println("Enter Customer Salary:");
            salary=input.nextDouble();

            customerFoorLoop:
            for (int i = 0; i < customers.length ; i++) {
                if(customers[i][0]!=null){
                    if(customers[i][0].equals(nic)){
                        System.out.println("Customer already exists");
                        break;
                    }
                }else {
                    customers[i][0]=nic;
                    customers[i][1]=name;
                    customers[i][2]=address;
                    customers[i][3]=String.valueOf(salary);
                    System.out.println("Customer saved successfully!\n");
                    System.out.println("1)Do you want to add another customer? (yes/no)");
                    System.out.println("2)Back to Main Menu");
                    int option=input.nextInt();
                    switch (option){
                        case 1:
                            // Consume newline
                            break customerFoorLoop;
                        case 2:
                            return;
                        default:
                            System.out.println("Invalid option. Returning to Main Menu.");
                            return;
                    }
                }
            }
        }
    }

    private static void findCustomer() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer NIC to find:");
        String nic=input.nextLine();
        for (int i = 0; i < customers.length ; i++) {
            if(customers[i][0]!=null && customers[i][0].equals(nic)) {

                System.out.println("Customer Found:");
                System.out.println("==================Customer Details==================");
                System.out.println("NIC: " + customers[i][0]);
                System.out.println("Name: " + customers[i][1]);
                System.out.println("Address: " + customers[i][2]);
                System.out.println("Salary: " + customers[i][3]);
                System.out.println("====================================================");
                return;
            }

        }
        System.out.println("Customer not found.");
    }

    private static void updateCustomer() {
      Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer NIC to update:");
        String nic=input.nextLine();
        for (int i = 0; i < customers.length ; i++) {
            if(customers[i][0]!=null && customers[i][0].equals(nic)) {


                System.out.println("Enter new Name:");
                String name=input.nextLine();
                System.out.println("Enter new Address:");
                String address=input.nextLine();
                System.out.println("Enter new Salary:");
                double salary=input.nextDouble();

                customers[i][1]=name;
                customers[i][2]=address;
                customers[i][3]=String.valueOf(salary);

                System.out.println("Customer updated successfully!");
                return;
            }
        }

    }

    private static void deleteCustomer() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Customer NIC to find:");
        String nic=input.nextLine();
        for (int i = 0; i < customers.length ; i++) {
            if(customers[i][0]!=null && customers[i][0].equals(nic)) {

                customers[i][0]=null;
                customers[i][1]=null;
                customers[i][2]=null;
                customers[i][3]=null;

                System.out.println("Customer deleted successfully.");
                return;
            }

        }
        System.out.println("Customer not found.");

    }

    private static void findAllCustomers() {
        System.out.println("All Customers:");
        System.out.println("====================================================");
        for (int i = 0; i < customers.length ; i++) {
            if(customers[i][0]!=null) {

                System.out.println("NIC: " + customers[i][0]+"\tName: " + customers[i][1]+"\tAddress: " + customers[i][2]+"\tSalary: " + customers[i][3]);
            }else {
                return;
            }

        }
        System.out.println("====================================================");
    }

    //Order  process
    public static void placeNewOrder(){
        Scanner input = new Scanner(System.in);
        System.out.println("Insert Customer NIC:");
        String nic=input.nextLine();

        String name,address;
        double salary;
        boolean customerFound = false;
        // =====Customer find process=====
        for (int i = 0; i < customers.length ; i++) {
            if (customers[i][0] != null && customers[i][0].equals(nic)) {
                name= customers[i][1];
                address = customers[i][2];
                salary =Double.parseDouble(customers[i][3]);
                customerFound = true;
                break;
            }
        }

        if(!customerFound){
            System.out.println("Customer not found!");
            return;
        }
        // =====Customer find process=====

        // =====Item find process=====
        System.out.println("Insert Item Code:");
        String code=input.nextLine();

        String description;
        int qtyOnHand;
        double unitPrice = 0;
        boolean itemFound = false;
        for (int i = 0; i < items.length ; i++) {
            if (items[i][0] != null && items[i][0].equals(code)) {
                description = items[i][1];
                qtyOnHand = Integer.parseInt(items[i][2]);
                unitPrice =Double.parseDouble(items[i][3]);
                itemFound = true;
                break;
            }
        }

        if(!itemFound){
            System.out.println("Item not found!");
            return;
        }
        // =====Item find process=====

        System.out.println("Insert Order code:");
        String orderId=input.nextLine();

        // Check for duplicate order ID and find empty slot
        for (int i = 0; i < orders.length; i++) {
            if(orders[i][0]!=null){
                if(orders[i][0].equals(orderId)){
                    System.out.println("Order Id already exists");
                    return;
                }
            }else {
                // Found empty slot, save the order
                Date date = new Date();
                SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String simpleDate = dateFormat.format(date);
                orders[i][0]=orderId;
                orders[i][1]=nic;
                orders[i][2]=code;
                orders[i][3]= simpleDate;
                orders[i][4]=String.valueOf(unitPrice);
                System.out.println("Order placed successfully!");
                return;
            }
        }

        System.out.println("Order database is full!");
    }
    public static void printUi(String position){

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        String simpleDate = dateFormat.format(date);
        String simpleTime = timeFormat.format(date);
        System.out.println("==========="+simpleDate+"==========="+simpleTime+"======>"+position);


    }


}
