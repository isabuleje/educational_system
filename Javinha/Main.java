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
  2 professores com cursos distintos.
  2 cursos, cada um com ao menos 1 turma.
  5 alunos matriculados em turmas variadas.
  Pelo menos 3 avaliações por turma.
  Submissões cruzadas entre alunos e avaliações.
  Geração de relatório de desempenho por aluno.
*/

//adicionando comentario pra ver se funcionou abrir na ide e dar commit - apagar depois

public class Main {

	public static void main(String[] args) {
		// Criacao de dois professores
		Teacher teacher1 = new Teacher();
		Teacher teacher2 = new Teacher();
		teacher1.setName("Jurandir");
		teacher1.setID(123456);
		teacher1.setEspeciality("Lingua Portuguesa");
		teacher2.setName("Lucinda");
		teacher2.setID(7890123);
		teacher2.setEspeciality("Matematica");

		// Criacao de dois cursos
		Course course1 = new Course();
		Course course2 = new Course();
		course1.setName("Gramatica");
		course1.setCourseLoad(60);
		course1.setSyllabus("Coisas de gramatica");
		course2.setName("Matematica");
		course2.setCourseLoad(40);
		course2.setSyllabus("Coisas de matematica");

		// Relacao Curso-professor de um curso com um professor
		teacher1.addCourse(course1);
		teacher2.addCourse(course2);
		course1.setTeacher(teacher1);
		course2.setTeacher(teacher2);

		// Criacao de 2 salas de aula
		Classroom classroom1 = new Classroom();
		Classroom classroom2 = new Classroom();
		classroom1.setCode("MAT001");
		classroom1.setPeriod(1);
		classroom2.setCode("GRA002");
		classroom2.setPeriod(2);

		// Relacao sala-curso de uma sala com um curso
		classroom1.setCourse(course1);
		classroom2.setCourse(course1);
		course1.addClassroom(classroom1);
		course1.addClassroom(classroom2);

		// Criacao de cinco alunos
		Student student1 = new Student();
		Student student2 = new Student();
		Student student3 = new Student();
		Student student4 = new Student();
		Student student5 = new Student();

		student1.setName("Fulano");
		student2.setName("Ciclano");
		student3.setName("Beltrano");
		student4.setName("Fulano de Barros");
		student5.setName("Beltrano da Ciclano");
		student1.setRegistrationNumber(12343);
		student2.setRegistrationNumber(12344);
		student3.setRegistrationNumber(12345);
		student4.setRegistrationNumber(12346);
		student5.setRegistrationNumber(12347);
		student5.setEmail("<EMAIL1>");
		student4.setEmail("<EMAIL2>");
		student3.setEmail("<EMAIL3>");
		student2.setEmail("<EMAIL4>");
		student1.setEmail("<EMAIL5>");

		// Relacoes de aluno-sala associativa
		student1.addClassroom(classroom1);
		student2.addClassroom(classroom1);
		student3.addClassroom(classroom2);
		student4.addClassroom(classroom2);
		student5.addClassroom(classroom2);
		classroom1.addStudent(student1);
		classroom1.addStudent(student2);
		classroom2.addStudent(student3);
		classroom2.addStudent(student4);
		classroom2.addStudent(student5);

		// Criacao de 3 avaliacoes
		Assessment assessment1 = new Assessment();
		Assessment assessment2 = new Assessment();
		Assessment assessment3 = new Assessment();
		assessment1.setType("trabalho");
		assessment2.setType("prova");
		assessment3.setType("trabalho");
		assessment1.setMaxScore(10);
		assessment2.setMaxScore(10);
		assessment3.setMaxScore(10);
		assessment1.setWeight(0.3f);
		assessment2.setWeight(0.3f);
		assessment3.setWeight(0.4f);

		// Criacao de 3 submissoes
		Submission submission1 = new Submission();
		Submission submission2 = new Submission();
		Submission submission3 = new Submission();
		submission1.setScore(8);
		submission2.setScore(9);
		submission3.setScore(10);
		submission1.setDateOfSubmission("HOJE");
		submission2.setDateOfSubmission("AMANHA");
		submission3.setDateOfSubmission("DEPOIS DE AMANHA");
		submission1.setComments("PROVA DE MATEMATICA");
		submission2.setComments("TRABALHO DE LINGUAGEM");
		submission3.setComments("TRABALHO DE MATEMATICA");

		// relacao student-submissao
		submission1.setStudent(student1);
		submission2.setStudent(student2);
		submission3.setStudent(student1);
		submission1.setAssessment(assessment1);
		submission2.setAssessment(assessment2);
		submission3.setAssessment(assessment3);
		assessment1.addSubmission(submission1);
		assessment2.addSubmission(submission2);
		assessment3.addSubmission(submission3);

		System.out.println("=====" + "Tudo o que temos agora" + "========");
		System.out.println("Professores");

		System.out.print("1: "+teacher1.getName() + " ID: " + teacher1.getID() + " Especialidade: " + teacher1.getEspeciality() + ". Da aula em: ");
		for (int i = 0; i < teacher1.getCourseList().size(); i++) {
			System.out.print(teacher1.getCourseList().get(i).getName() + ", ");
		}
		System.out.println();
		System.out.print("2: "+teacher2.getName() + " ID: " + teacher2.getID() + " Especialidade: " + teacher2.getEspeciality() + ". Da aula em: ");
		for (int i = 0; i < teacher2.getCourseList().size(); i++) {
			System.out.print(teacher2.getCourseList().get(i).getName() + ", ");
		}

		System.out.println();
		System.out.println();

		System.out.println("Cursos");
		System.out.println("1: "+ course1.getName() + ". Carga horaria: " + course1.getCourseLoad() + "h. Ementa: " + course1.getSyllabus() + " Professor: " + course1.getTeacher().getName());
		System.out.println("2: "+course2.getName() + ". Carga horaria: " + course2.getCourseLoad() + "h. Ementa: " + course2.getSyllabus() + " Professor: " + course2.getTeacher().getName());

		System.out.println();

		System.out.println("Classrooms");
		System.out.print("1: "+classroom1.getCode() + ". Perido: " + classroom1.getPeriod() + ". Alunos matriculados: ");
		for (int i = 0; i < classroom1.getStudentList().size(); i++) {
			System.out.print(classroom1.getStudentList().get(i).getName() + ", ");
		}
		System.out.println();
		System.out.print("2: "+classroom2.getCode() + ". Perido: " + classroom2.getPeriod() + ". Alunos matriculados: ");
		for (int i = 0; i < classroom2.getStudentList().size(); i++){
			System.out.print(classroom2.getStudentList().get(i).getName() + ", ");
		}

		System.out.println();
		System.out.println();

		System.out.println("Alunos");
		System.out.print("1: "+student1.getName() + ". ID: "+ student1.getRegistrationNumber() + ". E-mail: " + student1.getEmail() + ". Matriculado em: ");
		for (int i=0; i < student1.getStudent_classes().size(); i++) {
			System.out.print(student1.getStudent_classes().get(i).getCode() + ", ");
		}
		System.out.println();
		System.out.print("2: "+student2.getName() + ". ID: "+ student2.getRegistrationNumber() + ". E-mail: " + student2.getEmail() + ". Matriculado em: ");
		for (int i=0; i < student2.getStudent_classes().size(); i++) {
			System.out.print(student2.getStudent_classes().get(i).getCode() + ", ");
		}
		System.out.println();
		System.out.print("3: "+student3.getName() + ". ID: "+ student3.getRegistrationNumber() + ". E-mail: " + student3.getEmail() + ". Matriculado em: ");
		for (int i=0; i < student3.getStudent_classes().size(); i++) {
			System.out.print(student3.getStudent_classes().get(i).getCode() + ", ");
		}
		System.out.println();
		System.out.print("4: "+student4.getName() + ". ID: "+ student4.getRegistrationNumber() + ". E-mail: " + student4.getEmail() + ". Matriculado em: ");
		for (int i=0; i < student4.getStudent_classes().size(); i++) {
			System.out.print(student4.getStudent_classes().get(i).getCode() + ", ");
		}
		System.out.println();
		System.out.print("5: "+student5.getName() + ". ID: "+ student5.getRegistrationNumber() + ". E-mail: " + student5.getEmail() + ". Matriculado em: ");
		for (int i=0; i < student5.getStudent_classes().size(); i++) {
			System.out.print(student5.getStudent_classes().get(i).getCode() + ", ");
		}
	}

}
