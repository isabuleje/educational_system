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
    }
    public void removeClassroom(Classroom classroom){
        classrooms_list.remove(classroom);
    }
    public ArrayList<Classroom> getClassroomList(){
        return classrooms_list;
    }

    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public void removeTeacher(){
        this.teacher = null;
    }
    public Teacher getTeacher(){
        return teacher;
    }
}
