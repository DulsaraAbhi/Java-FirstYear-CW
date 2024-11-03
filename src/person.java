public class person{
    String Name;
    String Surname;
    String email;

    //constructor
    public  person(String Name,String Surname,String email){
        this.Name=Name;
        this.Surname=Surname;
        this.email=email;
    }

    //getters

    public String getName(){
        return Name;
    }

    public String getSurname(){
        return Surname;
    }
    public String getEmail(){
        return email;
    }

    // setters


    public void setName(String name) {
        this.Name = name;
    }

    public void setSurname(String surname) {
        this.Surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void printdetails(){//printing details
        System.out.println("Name:"+Name);
        System.out.println("Surname:"+Surname);
        System.out.println("Email:"+email);
    }
}

