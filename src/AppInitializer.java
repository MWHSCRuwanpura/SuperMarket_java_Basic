import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppInitializer{
    //DataBase Area
    static String [][] users=new String[3][2];
    static String [][] customers=new String[100][4];
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
                    orderManagement();
                    break ;
                case 4:
                    
                    return ;
                default:
                    System.out.println("Wrong  input");
                    return;
            }
        }
    }

    private static void orderManagement() {
    }

    private static void itemManagement() {
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
                    if(customers[i][1].equals(nic)){
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
    }
    
    private static void updateCustomer() {

    }
    private static void deleteCustomer() {

    }
    private static void findAllCustomers() {
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
