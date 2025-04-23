package Javinha;
import java.util.ArrayList;
/*
📝 Avaliação (Assessment)
    Tipo (prova, trabalho, projeto), nota máxima, peso.
    Uma avaliação está associada a uma turma (1:N).
    Cada avaliação possui múltiplas submissões de alunos (N:N).
*/

public class Assessment {
	private String type;
	private float maxScore;
	private float weight;

	private Classroom classroom;
	private ArrayList<Submission> submissions_list = new ArrayList<Submission>();

	// Construtor sem parametros
	public Assessment() {}

	// Construtor com parametros
	public Assessment(String type, float maxScore, float weight) {
	this.type = type;
	this.maxScore = maxScore;
	this.weight = weight;
	}

	// Getters and setters
	public void setType(String type){
	this.type = type;
	}
	public String getType(){
	return type;
	}
	public void setMaxScore(float maxScore){
	this.maxScore = maxScore;
	}
	public float getMaxScore(){
	return maxScore;
	}
	public void setWeight(float weight){
	this.weight = weight;
	}
	public float getWeight(){
	return weight;
	}

	// Methods
	public void setClassroom(Classroom classroom){
	this.classroom = classroom;
	}
	public void removeClassroom(){
	this.classroom = null;
	}
	public Classroom getClassroom(){
		if (this.classroom != null) {
			return this.classroom;
		}
		else {
			return null;
		}
	}
	public void addSubmission(Submission submission){
		submissions_list.add(submission);
		submission.setAssessment(this);
	}
	public void removeSubmission(Submission submission){
	submissions_list.remove(submission);
	}
	public ArrayList<Submission> getSubmissionList(){
	return submissions_list;
	}
}

