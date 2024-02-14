package Feb_13_Assignment;



import java.util.*;

abstract class person
{
    private int id;//id of person
    private String name ;//name
    private int age;// age
    public person(int id , String name,int age)
    {
      this.id = id;
      this.name = name ;
      this.age = age;
    }
   abstract void getDetails(); // display the details of the person

    public int getId()
    {
        return id;
    }

    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
}
class student extends person
{
    Scanner sc = new Scanner(System.in);
    private int s_id;
   // private String s_course;
     public List<String>stucourses = new ArrayList<>();

    public student(int id , String name , int age  ,int s_id  )
    {
        super(id,name ,age );
        this.s_id = s_id;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int id)
    {
        this.s_id = s_id;
    }

    public void enrollInCourse(course newCourse) {
        if (!stucourses.contains(newCourse.getCourse_name())) {
            stucourses.add(newCourse.getCourse_name());
            System.out.println("Student enrolled in course successfully");
        } else {
            System.out.println("Student is already enrolled in this course");
        }
    }

    public void getDetails()
    {
        System.out.println(" ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Age: " + getAge());
        System.out.println("Stu_id: " + getS_id());
    }


    public String toString()// override the function for print the object
    {
        return ("id :" +" "+  getId() +" "+ "name :" +" " + getName()+ " " + "Age :" + " " + getAge()+" "+ " "+ "S_id:"+ " "+ getS_id() );
    }
    }


class faculty extends person
{
    private int emp_id ;
    private String emp_department ;
    public faculty(int id , String name , int age ,int emp_id , String emp_department)
    {
        super(id,name,age);
        this.emp_id = emp_id;
        this.emp_department = emp_department;
    }

    public int getEmp_id()
    {
        return emp_id;
    }
    public String getEmp_department()
    {
        return emp_department;
    }

    public void setEmp_id(int emp_id)
    {
        this.emp_id = emp_id;
    }

    public void setEmp_department(String emp_department)
    {
        this.emp_department = emp_department;
    }
    public void getDetails()
    {
        System.out.println(" ID   : " + getId());
        System.out.println(" Name : " + getName());
        System.out.println(" AGE  : " + getAge());
        System.out.println(" Emp_ID : " + getEmp_id());
        System.out.println(" Emp_Department : " + getEmp_department());
    }
}
class course
{
    private List<course>enrollCourses = new ArrayList<>();
    private int course_code;
    private String course_name ;
    private double course_hours ;//credit hours for the course
    public course(int course_code , String course_name,double course_hours)
    {
        this.course_code = course_code;
        this.course_name = course_name;
        this.course_hours = course_hours;
    }

    public int getCourse_code()
    {
        return course_code;
    }
    public String getCourse_name()
    {
        return course_name;
    }
    public double getCourse_hours()
    {
        return course_hours;
    }

    public void setCourse_code(int course_code)
    {
        this.course_code = course_code;
    }

    public void setCourse_name(String course_name)
    {
        this.course_name = course_name;
    }

    public void setCourse_hours(double course_hours)
    {
        this.course_hours = course_hours;
    }
    public String toString()// override the function for print object
    {
        return ("course code :" +"  " + getCourse_code() +"  "+ "course name :" +" " + getCourse_name()+ "  "+"course hour:"+
                 "   " + getCourse_hours());
    }
}
class universityClass
{
    public List<student>studentList = new ArrayList<>();// student list
    private List<faculty>facultyList = new ArrayList<>();// faculty list
    List<course>courseList = new ArrayList<>();

    public void addcourse(course newCourse)// for added course
        {
            courseList.add(newCourse);
            System.out.println(" course added successfully ");

        }
        public void displayCourse()// display courses
        {
            for(course course:courseList){
                System.out.println(course);
            }

        }
//        public void addStudent(int id , String name , int age , int s_id , String s_course)
//        {
//            studentList.add(new student(id, name, age, s_id, s_course));
//            System.out.println("student added successfully");
//        }
    public void addstudent(student Students)// add student
    {
        studentList.add(Students);
        System.out.println("student added");
    }
        public void displayStudent()// display student
        {
            for (student student: studentList)
            {
                System.out.println(student);
            }
        }
        public void addfaculty(faculty Faculties)// add faculty
        {
        facultyList.add(Faculties);
            System.out.println("faculty added successfully");

        }
        public void displayfaculty()// for display faculty
        {
            for(faculty faculties : facultyList)
            {
                System.out.println(faculties);
            }
        }
        public void RemoveStudent(int s_id)// function for remove student
        {
         student studenttoRemove = null;
         for(student student : studentList)
         {
             if(s_id == student.getS_id())
             {
                 studenttoRemove = student;
                 break;
             }
             else{
                 System.out.println("student is not enrolled");
             }
        }
         studentList.remove(studenttoRemove);
            System.out.println("student is removed");
        }
        public void RemoveCourse(int course_id)// function for remove courses
        {
          course coursetoRemove = null;
          for(course course:courseList)
          {
              if(course_id == course.getCourse_code())
              {
                  coursetoRemove = course;
                  break;
              }else
              {
                  System.out.println("course is not enrolled");
              }
          }
          courseList.remove(coursetoRemove);
            System.out.println("course is reemoved successfuly");
        }
        public void removeFaculty(int emp_id) // function for remove faculty
        {
          faculty facultytoRemove = null;
          for(faculty faculty : facultyList)
          {
              if(emp_id == faculty.getEmp_id())
              {
                  facultytoRemove = faculty;
                  break;
              }
              else
              {
                  System.out.println("faculty is not enrolled");
              }
          }
          facultyList.remove(facultytoRemove);
            System.out.println("faculty is removed successfully");
        }
        public void Availablecourses()// function for all available courses
        {
        for(course course: courseList)
        {
            System.out.println(course);
        }
        }

//


    }
    public class University_Management_System
    {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)
    {

        universityClass uc = new universityClass();
        System.out.println("welcome in university management system ");
        while (true)
        {
            System.out.println("Select an option");
            System.out.println(" 0. Exit ");
            System.out.println(" 1. Add student ");
            System.out.println(" 2. Remove student ");
            System.out.println(" 3. Add course ");
            System.out.println(" 4. Remove course ");
            System.out.println(" 5 .Add faculty ");
            System.out.println(" 6 .Remove faculty ");
            System.out.println(" 7 . Enrolled course ");
            System.out.println(" 8 .Enrolled Student ");
            System.out.println(" 9 .faculty Member ");
            System.out.println(" 10.Available course ");


            int n = sc.nextInt();
            if(n==0)
            {
                System.out.println("exit");
                break;
            }
            switch (n){// add student
                case 1:
                {
                    student newstudent = addstudent();
                    uc.addstudent(newstudent);
                    break;
                }
                case 2:// remove student
                {
                    System.out.println("enter the id of student that you want to remove");
                    int id = sc.nextInt();
                    uc.RemoveStudent(id);
                    break;
                }
                case 3:// add course
                {
                    course newcourse = addcourse();
                    uc.addcourse(newcourse);
                    //uc.displayCourse();
                    break;
                }
                case 4: // remove course
                {
                    System.out.println("enter the course code of course that you want to remove");
                    int c_id = sc.nextInt();
                    uc.RemoveCourse(c_id);
                }
                case 5:// add faculty
                {
                    faculty newfaculty = addfaculty();
                    uc.addfaculty(newfaculty);
                    break;
                }
                case 6: // to remove faculty
                {
                    System.out.println("enter the id of faculty to remove");
                    int emp_id = sc.nextInt();
                    uc.removeFaculty(emp_id);
                    break;

                }
                case 7: // for enroll courses
                {

                        Scanner sc = new Scanner(System.in);
                        System.out.println("enroll course");
                        System.out.println("enter student id ");
                        int s_id = sc.nextInt();
                        System.out.println("availabe courses ");
                        for(course course : uc.courseList)
                        {
                            System.out.println("course code :" + course.getCourse_code());
                            System.out.println("course name :" + course.getCourse_name());
                            System.out.println("course credits hours :" + course.getCourse_hours());
                            sc.nextLine();
                            System.out.println("select course code :" );
                            int coursecode = sc.nextInt();
                            course cou = null;
                            for (course cours : uc.courseList)
                            {
                                if(course.getCourse_code()==(coursecode)){
                                    cou = cours;
                                    break;

                                }
                            }
                            if(cou!=null){
                                for(student std : uc.studentList)
                                {
                                    if(std.getS_id()==s_id){
                                        std.enrollInCourse(cou);
                                        break;
                                    }
                                }
                                System.out.println("coursse enrolled successfully :");
                            }else {
                                System.out.println("course is not present");
                                break;
                            }


                        }

                    }

                case 8://for display all student
                {
                    uc.displayStudent();
                    break;
                }
                case 9:
                {
                    uc.displayfaculty();//display all faculty
                    break;
                }
                case 10:// available courses
                {
                    uc.Availablecourses();
                    break;
                }
                default:{
                    System.out.println("enter a valid option");
                }
            }
        }


    }
    public static course addcourse() // function for add course
    {
        System.out.println("enter course id");
        int c_id = sc.nextInt();
        System.out.println("enter course name");
        String c_name = sc.next();
        System.out.println("enter course credits hours");
        int c_hourse = sc.nextInt();
        course newcourse = new course(c_id , c_name ,c_hourse);
        return newcourse;

    }
    public static student addstudent()// function for add student
    {
        System.out.println("Enter  id ");
        int id = sc.nextInt();
        System.out.println("Enter  name ");
        String name = sc.next();
        System.out.println("Enter  age ");
        int age = sc.nextInt();
        System.out.println("Enter student id ");
        int s_id = sc.nextInt();
        System.out.println("Enter student  course ");
        String course  = sc.next();
        student st = new student(id ,name,age,s_id);
        return st ;

    }
    public static faculty addfaculty()//function for add faculty
    {
        System.out.println("Enter  id ");
        int id = sc.nextInt();
        System.out.println("Enter  name ");
        String name = sc.next();
        System.out.println("Enter  age ");
        int age = sc.nextInt();
        System.out.println("Enter employee id ");
        int emp_id = sc.nextInt();
        System.out.println("Enter employee dipartment ");
        String emp_dep  = sc.next();
        faculty fac = new faculty(id ,name,age,emp_id,emp_dep);
        return fac ;

    }


}
