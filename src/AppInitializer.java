import java.util.Scanner;

public class AppInitializer{
    //DataBase Area
    static String [][] users=new String[3][2];
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);




        //program initialization
        String[] initializePageQuestions =
                {
                        "1) Do you want to login?",
                        "2) Are you new to here?",
                        "3)Do you want to exit the page?"
                };
        for (String question : initializePageQuestions) {
            System.out.println(question);

        }
        int UserInput = input.nextInt();
        switch (UserInput){
            case 1:if (login ()){
                openDashboard();}break ;

            case 2: if(register ()){
                openDashboard();}  break ;
            case 3: break;
            default:return;//exit

        }

    }
    //login process
    public static boolean login(){
        Scanner input = new Scanner(System.in);
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

        System.out.println("404 Not Found");
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






    }




}
