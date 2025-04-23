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
	private ArrayList<Performance> student_performance_history;
	// Construtor sem parametros
	public Student() {}

	// Construtor com parametros
	public Student(String name, String registrationNumber, String email) {
	    this.name = name;
	    this.idNumber = registrationNumber;
	    this.email = email;
		student_performance_history = new ArrayList<Performance>();
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

	public void addSubmission(Assessment assessment, double score, String dataOfSubmission, String comments){
		Submission submission = new Submission(this, assessment, score, dataOfSubmission, comments);
		Classroom classroom = submission.getAssessment().getClassroom();
		boolean found = false;
		for (int i = 0; i < this.student_performance_history.size(); i++) {
			if (this.student_performance_history.get(i).getCourse().equals(classroom.getCourse())) {
				System.out.println("Existe historico do aluno "+ this.getName() + " na turma " + classroom.getCode() + " do curso " + classroom.getCourse().getName() + ". adicionando submissao ao historico.");
				this.student_performance_history.get(i).addSubmission(submission);
				found = true;
				System.out.println(this.student_performance_history.get(i).getGradeList());
				System.out.println("Nova média: " + this.student_performance_history.get(i).getAverage());
				System.out.println("tamanho da lista: " + this.getPerformanceReport(classroom).getGradeList().size());
				break;
			}
		}
		if (found == false) {
			//se o aluno ainda nao tinha historico nessa turma
			System.out.println("Adicionando historico de desempenho do aluno " + this.getName() + " na turma " + classroom.getCode() + " do curso " + classroom.getCourse().getName());
			this.student_performance_history.add(new Performance(this, classroom.getCourse()));
			//historico pra essa turma adicionado na lista de historicos
			this.student_performance_history.get(this.student_performance_history.size()-1).addSubmission(submission);
			//submissao adicionada no historico no final da lista de historicos (ultimo adicionado)
			System.out.println(this.student_performance_history.get(this.student_performance_history.size()-1).getGradeList());
		}

	}

	public Performance getPerformanceReport(Classroom classroom) {
		for (int i = 0; i < this.student_performance_history.size(); i++) {
			if (this.getStudent_performance_history().get(i).getCourse().equals(classroom.getCourse())) {
				return this.getStudent_performance_history().get(i);
			}
		}
		return null;
	}

	private void addPerformance(Course course) {
	  this.student_performance_history.add(new Performance(this, course));
	}
	  
	private void removePerformance(Course course) {
		for (int i = 0; i < this.student_performance_history.size(); i++) {
			if (this.student_performance_history.get(i).getCourse().equals(course)) {
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
