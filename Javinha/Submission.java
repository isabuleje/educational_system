package Javinha;
import java.util.ArrayList;
/*
📤 Submissão (Submission)
    Associa um aluno a uma avaliação específica.
    Registra nota, data de entrega, observações.Calculado com base em todas as submissões do aluno em uma turma.

    Mostra média ponderada, notas individuais e aproveitamento.
    Modela a conectividade N:N entre Student e Assessment.
*/

public class Submission {
	  private Student student;
	  private Assessment assessment;
	  private ArrayList<Assessment> assessment_list = new ArrayList<Assessment>();

	  private float score;
	  private String dateOfSubmission;
	  private String comments;

	  // Getters and setters
	  public void setScore(float score){
	    this.score = score;
	  }
	  public float getScore(){
	    return score;
	  }
	  public void setDateOfSubmission(String dateOfSubmission){
	    this.dateOfSubmission = dateOfSubmission;
	  }
	  public String getDateOfSubmission(){
	    return dateOfSubmission;
	  }
	  public void setComments(String comments){
	    this.comments = comments;
	  }
	  public String getComments(){
	    return comments;
	  }

	  // Methods
	  public void setStudent(Student student){
	    this.student = student;
	  }
	  public void removeStudent(){
	    this.student = null;
	  }
	  public Student getStudent(){
	    return student;
	  }
	  public void setAssessment(Assessment assessment){
	    this.assessment = assessment;
	  }
	  public void removeAssessment(){
	    this.assessment = null;
	  }
	  public Assessment getAssessment(){
	    return assessment;
	  }
	  
	  public void addAssessments(Assessment assessment) {
		  assessment_list.add(assessment);
	  }
}
