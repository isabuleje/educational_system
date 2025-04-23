package Javinha;

import java.util.ArrayList;

/* 📈 Relatório de Desempenho (PerformanceReport)

Calculado com base em todas as submissões do aluno em uma turma.
Mostra média ponderada, notas individuais e aproveitamento.
*/

// TO DO: tem que mexer nisso aqui ó

public class Performance {
	private Student student;
	private Course course;
	private ArrayList<Assessment> assessments = new ArrayList<>();
	private ArrayList<Submission> submissions = new ArrayList<>();
	private Float average;
	private Float aproveitamento;
	private ArrayList<Float> grade_list = new ArrayList<Float>();

	
	public Performance(Student student, Course course) {
		this.student = student;
		this.course = course;
	}

	public void addSubmission(Submission submission) {
		submissions.add(submission);
		assessments.add(submission.getAssessment());
		calculateMetrics();
	}
	public void removeSubmission(Submission submission) {
		submissions.remove(submission);
		assessments.remove(submission.getAssessment());
	}

	public Student getStudent() {
		return this.student;
	}

	public Course getClassroom() {
		return this.course;
	}

	public Float getAverage() {
		return this.average;
	}
	
	public ArrayList<Float> getGradeList() {
		return this.grade_list;
	}

	public Float getAproveitamento() {
		return this.aproveitamento;
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

	public void setAproveitamento(float aproveitamento) {
		this.aproveitamento = aproveitamento;
	}

	public void generateReport() {
		System.out.println("\n--- Relatório de Desempenho ---");
		System.out.println("Aluno: " + student.getName());
		System.out.println("Curso: " + course.getName());
		System.out.println("Avaliação: " + assessment.getType());

		System.out.println("\nNotas: " + grade_list);
		System.out.printf("Média: %.2f%n", average);
		System.out.printf("Aproveitamento: %.2f", aproveitamento);
		System.out.println("-----------------------------");
	}
}

