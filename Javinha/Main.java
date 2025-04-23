package Javinha;
/*
Todos os atributos devem ser privados, com acesso controlado por métodos públicos (encapsulamento).

> Course e Teacher: 1:1 (agregação).
> Student e Classroom: N:N (modelar com classe associativa, se necessário).
> Classroom e Assessment: 1:N.
> Assessment e Student: N:N, via Submission.
> Student e Submission: composição reversa (se um aluno for excluído, todas as submissões dele devem ser removidas).
> PerformanceReport pode ser um objeto calculado dinamicamente, com métodos para gerar e exportar dados.

*/

/*
Implemente um main com os seguintes objetos:
  2 professores com cursos distintos. //OK
  2 cursos, cada um com ao menos 1 turma.
  5 alunos matriculados em turmas variadas. //OK
  Pelo menos 3 avaliações por turma.
  Submissões cruzadas entre alunos e avaliações.
  Geração de relatório de desempenho por aluno.
*/


public class Main {

	public static void main(String[] args) {
		// Criacao de dois professores
		Teacher teacher1 = new Teacher("Dr. Silva", "T001", "Banco de Dados");
		Teacher teacher2 = new Teacher("Dra. Oliveira", "T002", "Circuitos Eletricos");


		// Criacao de dois cursos
		Course course1 = new Course("Banco de Dados", 60, "Coisas de banco de dados");
		Course course2 = new Course("Circuitos Eletricos", 40, "Coisas de circuitos eletricos");

		// Associando professores aos cursos
		teacher1.addCourse(course1);
		course2.setTeacher(teacher2);

		// Criacao de duas turmas
		Classroom classroom1 = new Classroom("BD.2025.OO1", "2025/1");
		Classroom classroom2 = new Classroom("CE.2025.002", "2025/2");

		// Associando turmas ao curso
		course1.addClassroom(classroom1);
		course1.addClassroom(classroom2);

		// Criacao de cinco alunos
		Student student1 = new Student("Ana", "A001", "ana@gmail.com");
		Student student2 = new Student("Bruno", "A002", "bruno@hotmail.com");
		Student student3 = new Student("Carlos", "A003", "carlos@outlook.com");
		Student student4 = new Student("Daniela", "A004", "daniela@yahoo.com");
		Student student5 = new Student("Eduardo", "A005", "eduardo@aol.com");

		// Matriculando os alunos nas turmas
		student1.registerStudentToClassroom(classroom1);
		student2.registerStudentToClassroom(classroom1);
		student3.registerStudentToClassroom(classroom1);
		student4.registerStudentToClassroom(classroom2);
		student5.registerStudentToClassroom(classroom2);

		// Adicionando dois estudantes em duas turmas diferentes
		student1.registerStudentToClassroom(classroom2);
		student4.registerStudentToClassroom(classroom1);

		// Criacao de 3 avaliacoes
		Assessment assessment1 = new Assessment("Prova 1", 10, 0.5f);
		Assessment assessment2 = new Assessment("Juiz online", 10, 0.5f);
		Assessment assessment3 = new Assessment("Defesa de codigo", 10, 0.5f);

		Assessment assessment4 = new Assessment("Prova 1", 10, 0.5f);
		Assessment assessment5 = new Assessment("Lista de exercicios", 10, 0.5f);
		Assessment assessment6 = new Assessment("Prova 2", 10, 0.5f);

		// Associando as avaliacoes aos cursos
		classroom1.addAssessment(assessment1);
		classroom1.addAssessment(assessment2);
		classroom1.addAssessment(assessment3);

		classroom2.addAssessment(assessment4);
		classroom2.addAssessment(assessment5);
		classroom2.addAssessment(assessment6);

		// Criando submissoes para as avaliacoes
		// Banco de Dados

		//Submission submission1 = new Submission(student1, assessment1, 8.5, "01/01/2025", "Bom trabalho");
		new Submission(student1, assessment2, 7.5, "01/01/2025", "Pode melhorar");
		new Submission(student1, assessment3, 9.5, "01/01/2025", "Muito bom trabalho");
		//student1.addSubmission(submission1);
		Submission submission4 = new Submission(student2, assessment1, 8.5, "01/01/2025", "Pode melhorar");
		Submission submission5 = new Submission(student2, assessment2, 7.5, "01/01/2025", "Pode melhorar");
		Submission submission6 = new Submission(student2, assessment3, 9.5, "01/01/2025", "Muito bom trabalho");

		Submission submission7 = new Submission(student3, assessment1, 8.5, "01/01/2025", "Muito bom trabalho");
		Submission submission8 = new Submission(student3, assessment2, 7.5, "01/01/2025", "Muito bom trabalho");
		Submission submission9 = new Submission(student3, assessment3, 9.5, "01/01/2025", "Muito bom trabalho");

		Submission submission10 = new Submission(student4, assessment1, 8.5, "01/01/2025", "Muito bom trabalho");
		Submission submission11 = new Submission(student4, assessment2, 7.5, "01/01/2025", "Muito bom trabalho");
		Submission submission12 = new Submission(student4, assessment3, 9.5, "01/01/2025", "Muito bom trabalho");

		// Circuitos Eletricos
		Submission submission13 = new Submission(student1, assessment4, 8.5, "01/01/2025", "Muito bom trabalho");
		Submission submission14 = new Submission(student1, assessment5, 7.5, "01/01/2025", "Muito bom trabalho");
		Submission submission15 = new Submission(student1, assessment6, 9.5, "01/01/2025", "Muito bom trabalho");

		Submission submission16 = new Submission(student4, assessment4, 8.5, "01/01/2025", "Muito bom trabalho");
		Submission submission17 = new Submission(student4, assessment5, 7.5, "01/01/2025", "Muito bom trabalho");
		Submission submission18 = new Submission(student4, assessment6, 9.5, "01/01/2025", "Muito bom trabalho");

		Submission submission19 = new Submission(student5, assessment4, 8.5, "01/01/2025", "Muito bom trabalho");
		Submission submission20 = new Submission(student5, assessment5, 7.5, "01/01/2025", "Muito bom trabalho");
		Submission submission21 = new Submission(student5, assessment6, 9.5, "01/01/2025", "Muito bom trabalho");

		System.out.println("=== SIMULAÇÃO DO SISTEMA ===");
		// Fazer um metodo no Peformance que mostre algo como
		/*

		Nome, Classroom, curso, todas as avaliacoes com nota e peso.
		Todas as submissoes
		Media ponderada e aproveitamento.
		 */

		/*

		ta com esse erro, cansada demais pra debugar kkk
		provavelmente foi pq eu tava usando o arraylist e parei e n mudei tudo ou sla.


		Exception in thread "main" java.lang.StackOverflowError
			at Javinha.Course.setTeacher(Course.java:64)
			at Javinha.Teacher.addCourse(Teacher.java:47)
			at Javinha.Course.setTeacher(Course.java:64)
			at Javinha.Teacher.addCourse(Teacher.java:47)
			at Javinha.Course.setTeacher(Course.java:64)
			at Javinha.Teacher.addCourse(Teacher.java:47)
			at Javinha.Course.setTeacher(Course.java:64)
			at Javinha.Teacher.addCourse(Teacher.java:47)

		 */
		Performance performance = new Performance(student1, course1);
		performance.generateReport();
	}
}

