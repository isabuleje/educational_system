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
	private Assessment assessment;
	private double average;
	private double aproveitamento;
	private ArrayList<Submission> exam_list;

	
	public Performance(Student student, Course course) {
		this.student = student;
		exam_list = new ArrayList<Submission>();
		this.course = course;
	}

	public void addSubmission(Submission submission) {
		this.exam_list.add(submission);
	}
	public boolean removeSubmission(Submission submission) {
		if (this.exam_list.contains(submission)) {
			this.exam_list.remove(submission);
			return true;
		} else {
			return false;
		}
	}

	public Student getStudent() {
		return this.student;
	}

	public Course getCourse() {
		return this.course;
	}

	public double getAverage() {
		recalculateAverage();
		return this.average;
	}
	
	public ArrayList<Double> getGradeList() {
		ArrayList<Double> returnedlist = new ArrayList<Double>();
		for (int i = 0; i < exam_list.size(); i++) {
			returnedlist.add(exam_list.get(i).getScore());
		}
		return returnedlist;
	}

	public double getAproveitamento() {
		return this.aproveitamento;
	}

	public void recalculateAverage() {
		if (exam_list.size() == 0) {
			return;
		}
		double divisor = 0f;
		double dividendo = 0f;
		for (int i = 0; i < exam_list.size(); i++) {
			for (int j = 0; j < exam_list.get(i).getAssessment().getWeight(); j++) {
				dividendo += exam_list.get(i).getScore();
				divisor++;
			}
		}

		this.average = dividendo/divisor;
	}

	public void setAproveitamento(float aproveitamento) {
		this.aproveitamento = aproveitamento;
	}

	public void generateReport() {
		System.out.println("\n--- Relatório de Desempenho ---");
		System.out.println("Aluno: " + student.getName());
		System.out.println("Curso: " + course.getName());

		String notas = "Notas: ";
		for (int i = 0; i < exam_list.size(); i++) {
			notas += exam_list.get(i).getScore() + " ";
		}
		System.out.println(notas);
		this.recalculateAverage();
		System.out.printf("Média: %.2f%n", average);
		System.out.printf("Aproveitamento: %.2f", aproveitamento);
		System.out.println("\n-----------------------------");
	}
}

