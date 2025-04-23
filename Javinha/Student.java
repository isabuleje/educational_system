package Javinha;
import java.util.ArrayList;
/*
🎓 Aluno (Student)
    Nome, matrícula, email.
    Um aluno pode se matricular em múltiplas turmas (N:N).
    Cada aluno possui um histórico de desempenho por turma.
*/

public class Student {
	private String name;
	private String idNumber;
	private String email;
	private ArrayList<Classroom> student_classes = new ArrayList<Classroom>();
	private ArrayList<Performance> student_performance_history = new ArrayList<Performance>();

	// Construtor sem parametros
	public Student() {}

	// Construtor com parametros
	public Student(String name, String registrationNumber, String email) {
	    this.name = name;
	    this.idNumber = registrationNumber;
	    this.email = email;
	}

	  // Getters and setters
	public void setName(String name){
	this.name = name;
	}
	public String getName(){
	return name;
	}
	public void setRegistrationNumber(String registrationNumber){
	this.idNumber = registrationNumber;
	}
	public String getRegistrationNumber(){
	return idNumber;
	}
	public void setEmail(String email){
	this.email = email;
	}
	public String getEmail(){
	return email;
	}

	public ArrayList<Classroom> getStudent_classes() {
		return student_classes;
	}
	public ArrayList<Performance> getStudent_performance_history() {
		return student_performance_history;
	}


	// Methods
	public void registerStudentToClassroom(Classroom classroom){
		this.addClassroom(classroom);
		classroom.addStudent(this);
	}
	public void unregisterStudentFromClassroom(Classroom classroom){
		this.removeClassroom(classroom);
		classroom.removeStudent(this);
	}

	public void addSubmission(Submission submission){
		Classroom classroom = submission.getAssessment().getClassroom();
		for (int i = 0; i < this.student_performance_history.size(); i++) {
			if (this.student_performance_history.get(i).getClassroom().equals(classroom)) {
				this.student_performance_history.get(i).addSubmission(submission);
				break;
			}
		}

	}

	public Performance getPerformanceReport(Classroom classroom) {
		for (int i = 0; i < this.student_performance_history.size(); i++) {
			if (student_performance_history.get(i).getClassroom().equals(classroom)) {
				return student_performance_history.get(i);
			}
		}
		return null;
	}

	private void addPerformance(Course course) {
	  this.student_performance_history.add(new Performance(this, course));
	}
	  
	private void removePerformance(Course course) {
		for (int i = 0; i < this.student_performance_history.size(); i++) {
			if (this.student_performance_history.get(i).getClassroom().equals(course)) {
				this.student_performance_history.remove(i);
				break;
			}
		}
	}

	private void addClassroom(Classroom classroom){
		student_classes.add(classroom);
		addPerformance(classroom.getCourse());
	}

	private void removeClassroom(Classroom classroom){
	    student_classes.remove(classroom);
		removePerformance(classroom.getCourse());
	}


}
