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
	  public void addClassroom(Classroom classroom){
	    student_classes.add(classroom);
	  }
	  public void removeClassroom(Classroom classroom){
	    student_classes.remove(classroom);
	  }
}
