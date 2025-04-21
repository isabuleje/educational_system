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


public class Main {

	public static void main(String[] args) {
		System.out.println("Hello World");


	}

}
