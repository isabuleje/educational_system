package Javinha;
import java.util.ArrayList;
// Professor
// Atributos: Nome, especialidade, ID.
// Um professor pode ministrar vários cursos (1:N).
// Cada curso deve ter exatamente um professor (1:1).

public class Teacher {
	private String name;
	  private int ID;
	  private String especiality;
	  private ArrayList<Course> courses_list = new ArrayList<Course>();

	  // Getters and setters
	  public void setName(String name){
	    this.name = name;
	  }
	  public String getName(){
	    return name;
	  }
	  public void setID(int ID){
	    this.ID = ID;
	  }
	  public int getID(){
	    return ID;
	  }
	  public void setEspeciality(String especiality){
	    this.especiality = especiality;
	  }
	  public String getEspeciality(){
	    return especiality;
	  }

	  // Methods
	  public void addCourse(Course course){
	    courses_list.add(course);
	  }
	  public void removeCourse(Course course){
	    courses_list.remove(course);
	  }
	  public ArrayList<Course> getCourseList(){
	    return courses_list;
	  }
}
