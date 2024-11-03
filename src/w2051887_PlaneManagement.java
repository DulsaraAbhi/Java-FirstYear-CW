import java.util.InputMismatchException;
import java.util.Scanner;
public class w2051887_PlaneManagement {
    public static String x;//getting row letter input as a public variable
    public static int y;//getting seat number input as a public variable
    public static Ticket[][] Ticketinfo=new Ticket[4][14];//creating ticket array
    public static int total;//getting price total variable as a public
    public static int price;//getting price as a public variable

    public static void main(String[] args){


        //creating seats 2d array
        int [][] seats={{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0,0,0,0,0,0,0}};


        //Making menu
        System.out.println("Welcome to the Plane Management application");

        int option = 0;
        Scanner opt=new Scanner(System.in);

        do{


        starline();
        System.out.println("\n*                MENU OPTIONS                   *");
        starline();
        System.out.println("\n\t1)Buy a seat\n\t2)Cancel a seat\n\t3)Find first available seat" +
                "\n\t4)Show seating plans" + "\n\t5)Print tickets information and total sales" +
                "\n\t6)Search tickets\n\t0)Quit");
        starline();

        //option input validation
        boolean a=true;
        while(a) {
            try {
                System.out.print("\nPlease enter an option:");
                option = opt.nextInt();
                a=false;
            } catch (InputMismatchException e) {

                System.out.println("Invalid input");
                a=true;
                opt.nextLine();

            }
        }

            //calling method after user input method
            switch(option){
                case 0:
                    break;
                case 1:
                    buy_seat(seats,opt);
                    break;
                case 2:
                    cancel_seat(seats,opt);
                    break;
                case 3:
                    find_first_available(seats);
                    break;
                case 4:
                    show_seating_plan(seats);
                    break;
                case 5:
                    print_tickets_info();
                    break;
                case 6:
                    search_tickets(opt);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }

        }while(option!=0);//program will stop after user input 0


    }
    public static void starline(){
        for(int i=1;i<50;i++){     //print stars for the menu
            System.out.print("*");
        }
    }

    public static void buy_seat(int[][]seats,Scanner opt){

        int []array=new int[2];
        input(opt,array);        //calling input method and array
        int row_index=array[0];
        int seat_index=array[1];

        if(seats[row_index][seat_index]== 0) { //if element="O" convert it to "X"

            seats[row_index][seat_index] = 1;



            Scanner input = new Scanner(System.in);
            System.out.print("Enter Name:");
            String Name = input.next();
            System.out.print("Enter Surname:"); //getting user details
            String Surname = input.next();
            System.out.print("Enter Email:");
            String email = input.next();
            person person = new person(Name,Surname,email);//connecting person class




            Ticketinfo[row_index][seat_index] = new Ticket(x, y, price,person);//input details to "Ticketinfo" array
            System.out.println("\nTicket Details");
            System.out.println();
            Ticketinfo[row_index][seat_index].ticketdetails();//print ticket details

            Ticket.save(Ticketinfo,row_index,seat_index);//calling file saving method from Ticket class

            total=total+price;//Adding price for the total
        }
        else if(seats[row_index][seat_index]==1){//if element=="X" it will print "This seat is already booked"
            System.out.println("This seat is already booked");
        }

    }

    public static void cancel_seat(int[][]seats,Scanner opt){
        //int price=0;

        int []array=new int[2];
        input(opt,array); //calling method and array from input method
        int row_index=array[0];
        int seat_index=array[1];


        if(seats[row_index][seat_index] ==1){//if element equals to 1 covert it to "0"
            seats[row_index][seat_index]=0;
            System.out.println("Successfully canceled");
        }
        else if(seats[row_index][seat_index]==0){//if element equals to 0 print "This is not booked"
            System.out.println("This seat is not booked");
        }
        Ticketinfo[row_index][seat_index]=null;//removing ticket details from the array
        total=total-price;//subtracting price from the total

    }

    public static void find_first_available(int[][]seats){
        String found="";//define string variable to stop printing 4 times
        for(int i=0;i<4;i++){//checking row
            for(int x=0;x<seats[i].length;x++){//checking seat number
                if(seats[i][x]==0) {//element should be "O" for available
                    if (seats[0][x]==0) {//row index ==0 means row A
                        System.out.println("Row A" + " Seat Number is " + (x + 1));
                        found="yes";
                        break;
                    }
                    else if (seats[1][x]==0) {//row index ==1 means row B
                        System.out.println("Row B" + " Seat Number is " + (x + 1));
                        found="yes";
                        break;
                    }
                    else if (seats[2][x]==0) {//row index ==2 means row C
                        System.out.println("Row C" + " Seat Number is " + (x + 1));
                        found="yes";
                        break;
                    }
                    else if (seats[3][x]==0) {//row index ==3 means row D
                        System.out.println("Row D" + " Seat Number is " + (x + 1));
                        found="yes";
                        break;
                    }
                }
            }
            if(found.equals("yes")){//using string variable to stop repeat
                break;
            }

        }
        if (found.isEmpty()){
            System.out.println("All seat are booked");
        }
    }


    public static void show_seating_plan(int[][]seats){//printing all buy or available seats in the plain
        for(int i=0;i<4;i++){
            for(int x=0;x<seats[i].length;x++){
                if(seats[i][x]==0){
                    System.out.print("O ");
                }
                else{
                    System.out.print("X ");
                }
            }
            System.out.println();//to get  row space
        }

    }

    public static int[] input(Scanner opt,int []array){//to get user input
        int raw_index;//defining row index

        while(true) {
            System.out.print("Enter a row letter:");
            x = opt.next();
            switch (x) {//converting row input to index
                case ("A"):
                    raw_index = 0;
                    break;
                case ("B"):
                    raw_index = 1;
                    break;
                case ("C"):
                    raw_index = 2;
                    break;
                case ("D"):
                    raw_index = 3;
                    break;
                default:
                    System.out.println("Invalid input");
                    continue;


            }
            boolean b=true;//seat number validation
            while (b) {
                try {
                    System.out.print("Enter seat number:");
                    y = opt.nextInt();
                    if(y>0&&y<=14){
                        b=false;
                    }
                    else {
                        System.out.println("Out of range");
                    }

                    if(x.equals("B")&&(y>12&&y<=14)){
                        System.out.println("Out of range");
                        b=true;
                    }
                    if(x.equals("C") &&(y>12&&y<=14)){
                        System.out.println("Out of range");
                        b=true;
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Invalid Input");
                    opt.nextLine();

                }
            }
            int seat_index = y - 1;//seat number - 1 = seat index
            array[0] = raw_index;//assigning row index into array
            array[1] = seat_index;//assigning seat index into array
            return array;
        }
    }
    public static int rowprice(int j){//distribute row price according to seat number
        //int price = 0;
        if (j>0&&j<=5) {
            price=200;
        }
        if(j>5&&j<=9){
            price=150;
        }
        if(j>9&&j<=14){
            price=180;
        }
        return price;
    }

    public static void print_tickets_info(){//print all bought tickets info after user input 5

        for (Ticket[] p : Ticketinfo) {
            for (Ticket r : p) {
                if (r != null) {
                    r.ticketdetails();
                    System.out.println();
                }
            }
        }
        System.out.println("Total is $"+total);//printing total after ticket info
    }

    public static void search_tickets(Scanner opt){
        int []array=new int[2];
        input(opt,array);          //calling method and array from the input
        int row_index=array[0];
        int seat_index=array[1];

        if(Ticketinfo[row_index][seat_index]!=null){//print details only element are not null
            Ticketinfo[row_index][seat_index].ticketdetails();
        }
        else{
            System.out.println("This seat is available");//if anyone did not buy a ticket it will print this is available
        }

    }
}

