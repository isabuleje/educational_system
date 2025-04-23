package Javinha;
import java.util.ArrayList;

/*
📘 Curso (Course)
    Nome, carga horária, ementa.
    Cada curso é ministrado por um professor (1:1).
    Pode ter várias turmas associadas (1:N).
*/

public class Course {
    private String name;
    private int courseLoad;
    private String syllabus;

    private Teacher teacher;
    private ArrayList<Classroom> classrooms_list = new ArrayList<Classroom>();

    // Construtor sem parametros
    public Course() {}

    // Construtor com parametros
    public Course(String name, int courseLoad, String syllabus) {
        this.name = name;
        this.courseLoad = courseLoad;
        this.syllabus = syllabus;
    }

    // Getters and setters
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setCourseLoad(int courseLoad){
        this.courseLoad = courseLoad;
    }
    public int getCourseLoad(){
        return courseLoad;
    }
    public void setSyllabus(String syllabus){
        this.syllabus = syllabus;
    }
    public String getSyllabus(){
        return syllabus;
    }

    // Methods
    public void addClassroom(Classroom classroom){
        classrooms_list.add(classroom);
        classroom.setCourse(this);
    }
    public void removeClassroom(Classroom classroom){
        classrooms_list.remove(classroom);
        classroom.setCourse(null);
    }
    public ArrayList<Classroom> getClassroomList(){
        return classrooms_list;
    }

    public void setTeacher(Teacher teacher){
        if (this.teacher != teacher) {
            // Remove este curso do professor atual
            if (this.teacher != null && teacher != null) {
                this.teacher.removeCourse(this);
            }

            // Atualiza a referência
            this.teacher = teacher;

            // Adiciona ao novo professor (se não for nulo)
            if (teacher != null) {
                teacher.addCourse(this);
            }
        }
    }
    public void removeTeacher(){
        this.teacher = null;
        teacher.removeCourse(this);
    }
    public Teacher getTeacher(){
        return teacher;
    }
}


