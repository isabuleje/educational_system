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
		new Submission(student2, assessment1, 8.5, "01/01/2025", "Pode melhorar");
		new Submission(student2, assessment2, 7.5, "01/01/2025", "Pode melhorar");
		new Submission(student2, assessment3, 9.5, "01/01/2025", "Muito bom trabalho");

		new Submission(student3, assessment1, 8.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student3, assessment2, 7.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student3, assessment3, 9.5, "01/01/2025", "Muito bom trabalho");

		new Submission(student4, assessment1, 8.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student4, assessment2, 7.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student4, assessment3, 9.5, "01/01/2025", "Muito bom trabalho");

		// Circuitos Eletricos
		new Submission(student1, assessment4, 8.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student1, assessment5, 7.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student1, assessment6, 9.5, "01/01/2025", "Muito bom trabalho");

		new Submission(student4, assessment4, 8.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student4, assessment5, 7.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student4, assessment6, 9.5, "01/01/2025", "Muito bom trabalho");

		new Submission(student5, assessment4, 8.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student5, assessment5, 7.5, "01/01/2025", "Muito bom trabalho");
		new Submission(student5, assessment6, 9.5, "01/01/2025", "Muito bom trabalho");

		student1.addSubmission(assessment1, 8.5, "01/01/2025", "Bom trabalho");


		System.out.println("=== SIMULAÇÃO DO SISTEMA ===");

		//Performance performance = new Performance(student1, course1);
		//performance.generateReport();
		// isso aqui tava errado ^ mas fica de lembrança

		student1.getPerformanceReport(classroom1).generateReport();

		        // Testando a classe Teacher
        System.out.println("=== TESTES DA CLASSE TEACHER ===");

        // Verificando os cursos associados ao professor 1
        System.out.println("Cursos do professor " + teacher1.getName() + ":");
        for (Course course : teacher1.getCourseList()) {
            System.out.println("- " + course.getName());
        }

        // Verificando os cursos associados ao professor 2
        System.out.println("Cursos do professor " + teacher2.getName() + ":");
        for (Course course : teacher2.getCourseList()) {
            System.out.println("- " + course.getName());
        }

        // Adicionando um novo curso ao professor 1
        Course newCourse = new Course("Inteligência Artificial", 80, "Coisas de IA");
        teacher1.addCourse(newCourse);
        System.out.println("Novo curso adicionado ao professor " + teacher1.getName() + ": " + newCourse.getName());

        // Verificando novamente os cursos do professor 1
        System.out.println("Cursos atualizados do professor " + teacher1.getName() + ":");
        for (Course course : teacher1.getCourseList()) {
            System.out.println("- " + course.getName());
        }

        // Removendo um curso do professor 1
        teacher1.removeCourse(course1);
        System.out.println("Curso removido do professor " + teacher1.getName() + ": " + course1.getName());

        // Verificando novamente os cursos do professor 1 após a remoção
        System.out.println("Cursos atualizados do professor " + teacher1.getName() + " após remoção:");
        for (Course course : teacher1.getCourseList()) {
            System.out.println("- " + course.getName());
        }

        // Verificando se o curso removido ainda tem o professor associado
        System.out.println("Professor associado ao curso " + course1.getName() + ": " + (course1.getTeacher() != null ? course1.getTeacher().getName() : "Nenhum"));
	}
}

