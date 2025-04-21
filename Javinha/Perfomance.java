package Javinha;

import java.util.ArrayList;

/* 📈 Relatório de Desempenho (PerformanceReport)

Calculado com base em todas as submissões do aluno em uma turma.
Mostra média ponderada, notas individuais e aproveitamento.
*/

public class Performance {
	private Student student;
	private Classroom classroom;
	private Float average;
	private ArrayList<Float> grade_list = new ArrayList<Float>();
	
	public Performance(Student student, Classroom classroom) {
		this.student = student;
		this.classroom = classroom;
	}
	
	public Student getStudent() {
		return this.student;
	}
	
	public Classroom getClassroom() {
		return this.classroom;
	}
	
	public Float getAverage() {
		return this.average;
	}
	
	public ArrayList<Float> getList() {
		return this.grade_list;
	}
	
	public void recalculateAverage() {
		Float tempvar = 0f;
		if (grade_list.size() == 0) {
			return;
		}
		
		for (int i = 0; i < grade_list.size(); i++) {
			tempvar += grade_list.get(i);
		}
		
		tempvar /= grade_list.size();
		this.average = tempvar;
	}
	
	public void addGrade(Float grade) {
		this.grade_list.add(grade);
		this.recalculateAverage();
		//pode ou não incluir o recalculate
		//meio que tanto faz se sempre lembrar de recalcular quando mudar algo
		//mas por via das duvidas fica bom recalcular media sempre que alterar a lista de notas
	}
	
	public void removeGrade(Float grade) {
		this.grade_list.remove(grade);
		this.recalculateAverage();
	}
}
