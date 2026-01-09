import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class AppInitializer{
    //DataBase Area
    static String [][] users=new String[3][2];
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
                    users[0][0]="sajithachamod13579@gmail.com";
                    users[0][1]="sajitha123";
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
                    printUi("Customer Management");
                    break ;
                case 2:
                    printUi( "Item Management");
                    break ;
                case 3:
                    printUi( "Order Management");
                    break ;
                case 4:
                    printUi( "Logout");
                    return ;
                default:
                    System.out.println("Wrong  input");
                    return;
            }
        }
    }

    //Customer Management process
public static void customerManagement(){

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
