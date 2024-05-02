public class Student {
    private String name;
    private int id;
    private double gpa;
  
    public Student(String name, int id, double gpa) {
        this.name= name;
        this.id= id;
        this.gpa= gpa;
    }
  
    public String toString() {
        return "Name: " + name + ", ID: " + id + ", GPA: " + gpa;
    }
  
    public double getGPA() {
        return gpa;
    }
  
    public void setGPA(double gpa) {
        this.gpa= gpa;
    }
  
    public int getID() {
        return id;
    }
  
    public void setID(int id) {
        this.id= id;
    }
  
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name= name;
    }
}
