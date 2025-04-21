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
	  private int idNumber;
	  private String email;
	  private ArrayList<Classroom> student_classes = new ArrayList<Classroom>();
	  private ArrayList<Performance> student_performance_history = new ArrayList<Performance>();
	  // Getters and setters
	  public void setName(String name){
	    this.name = name;
	  }
	  public String getName(){
	    return name;
	  }
	  public void setRegistrationNumber(int registrationNumber){
	    this.idNumber = registrationNumber;
	  }
	  public int getRegistrationNumber(){
	    return idNumber;
	  }
	  public void setEmail(String email){
	    this.email = email;
	  }
	  public String getEmail(){
	    return email;
	  }

	  // Methods
	  
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
	  
	  public void addClassroom(Classroom classroom){
	    student_classes.add(classroom);
		addPerformance(classroom.getCourse());
	  }

	  public void removeClassroom(Classroom classroom){
	    student_classes.remove(classroom);
		removePerformance(classroom.getCourse());
	  }
}
