package Javinha;
import java.util.ArrayList;
// Professor
// Atributos: Nome, especialidade, ID.
// Um professor pode ministrar vários cursos (1:N).
// Cada curso deve ter exatamente um professor (1:1).

public class Teacher {
	private String name;
	private String ID;
	private String especiality;
	private ArrayList<Course> courses_list = new ArrayList<Course>();

	// Construtor sem parametros
	public Teacher() {}

	// Construtor com parametros
	public Teacher(String name, String ID, String especiality) {
		this.name = name;
		this.ID = ID;
		this.especiality = especiality;
	}

	// Getters and setters
	public void setName(String name){
	this.name = name;
	}
	public String getName(){
	return name;
	}
	public void setID(String ID){
	this.ID = ID;
	}
	public String getID(){
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
		course.setTeacher(this);
	}
	public void removeCourse(Course course){
		courses_list.remove(course);
		course.setTeacher(null);
	}
	public ArrayList<Course> getCourseList(){
		return courses_list;
	}
}

