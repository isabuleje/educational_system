package Javinha;
import java.util.ArrayList;
/*
🏫 Turma (Classroom)
Código, período, lista de alunos.
    Cada turma está ligada a um curso específico (1:1).
    Cada turma possui múltiplas avaliações (1:N).
    Cada turma possui vários alunos (N:N).
*/

public class Classroom {
	private String code;
	private String period;
	private Course course;
	private ArrayList<Student> students_list = new ArrayList<Student>();
	private ArrayList<Assessment> assessments_list = new ArrayList<Assessment>();

	// Construtor sem parametros
	public Classroom() {}

	// Construtor com parametros
	public Classroom(String code, String period) {
		this.code = code;
		this.period = period;
	}

	// Getters and setters
	public void setCode(String code){
	this.code = code;
	}
	public String getCode(){
	return code;
	}
	public void setPeriod(String period){
	this.period = period;
	}
	public String getPeriod(){
	return period;
	}

	// Methods
	public void setCourse(Course course){
		this.course = course;
		course.addClassroom(this);
	}
	public void removeCourse(){
		this.course = null;
		course.removeClassroom(this);
	}
	public Course getCourse(){
		return course;
	}

	public void addAssessment(Assessment assessment){
		assessments_list.add(assessment);
		assessment.setClassroom(this);
	}
	public void removeAssessment(Assessment assessment){
		assessments_list.remove(assessment);
		assessment.setClassroom(null);
	}

	public void addStudent(Student student){
	students_list.add(student);
	}
	public void removeStudent(Student student){
	students_list.remove(student);
	}
	public ArrayList<Student> getStudentList(){
	return students_list;
	}
}

