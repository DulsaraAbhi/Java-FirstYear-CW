
import java.io.IOException;
import java.io.FileWriter;

public class Ticket{
    private String row;
    private int seat;
    private int  price;
    person person;//calling person


    public Ticket(String row,int seat,int price,person person){
        this.row=row;
        this.seat=seat;
        this.price=price;
        this.person = person;

    }

    //getters


    public String getRow() {
        return row;
    }
    public int getSeat(){
        return seat;
    }
    public int getprice(){
        return price;
    }

    //setters


    public void setRow(String row) {
        this.row = row;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void ticketdetails(){
        person.printdetails();
        price=w2051887_PlaneManagement.rowprice(seat);
        System.out.println("Row:"+row);
        System.out.println("Seat:"+seat);
        System.out.println("Price:$"+price);

    }

    public static void save(Ticket[][] Ticketinfo,int row_index,int seat_index){
        //print name of file getting row number and index number and for the details
        String nameoffile =Ticketinfo[row_index][seat_index].row+Ticketinfo[row_index][seat_index].seat;
        try {
            FileWriter file=new FileWriter(nameoffile+".txt");//file
            String list="Seat :"+nameoffile+"\nName :"+Ticketinfo[row_index][seat_index].person.Name+
                    "\nSurname:"+Ticketinfo[row_index][seat_index].person.Surname+
                    "\nEmail: "+Ticketinfo[row_index][seat_index].person.email+
                    "\nPrice:$ "+Ticketinfo[row_index][seat_index].price;
            file.write(list);
            file.close();
        }catch (IOException e){
            System.out.println("Error while writing a file");
            e.printStackTrace();
        }


        }
    }

