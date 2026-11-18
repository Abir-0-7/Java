class  Person{
    private String Name,Email;
    private int Id;
    public String getName(){ return Name;}
    public void setName(String Name){ this.Name=Name;}
    public int getId(){return Id;}
    public void setId(int Id){this.Id=Id;}
    public String getEmail(){return Email;}
    public void setEmail(String Email){this.Email=Email;}
}
class Mentors extends Person{
    public void takeClass(){
        System.out.println(getName()+" is taking class.");
    }
}
class Administrative extends Person{
    public void hasOfficeWork(){
        System.out.println(getName()+" is doing office work");
    }
}
class Learners extends Person{
    private String course;
    public String getCourse() {return course;}
    public void setCourse(String course) { this.course=course;}
    public void hasCourse() {
        System.out.println(getName()+ " is enrolled in the "+getCourse()+ " course.");
    }
}
public class Main{
    public static void main(String[] args) {
        Learners x= new Learners();
        x.setName("TARIKA");
        x.setId(3208279);
        x.setEmail("Tarika07@gmail.com");
        x.setCourse("Artificial intelligence");
        Mentors mentor= new Mentors();
        mentor.setName("Andrew Ng");
        mentor.setId(328);
        mentor.setEmail("ang@cs.stanford.edu");
        Administrative y = new Administrative();
        y.setName("Abir");
        y.setId(277);
        y.setEmail("mdabdullahalmamun_cse32d@portcity.edu.bd");
        System.out.println("Mentor Info: Name - " + mentor.getName() + ", ID - " + mentor.getId()+", email: "+ mentor.getEmail());
        mentor.takeClass();    
        System.out.println("Learner Info: Name - " + x.getName() + ", ID - " + x.getId()+ ", Email- "+ x.getEmail());
        x.hasCourse();
        System.out.println("Admin Info: Name - " + y.getName() + ", ID - " + y.getId()+", Email - "+ y.getEmail());
        y.hasOfficeWork();

    }
}
