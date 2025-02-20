public class Student {
    String name;
    int semester;
    Boolean isActive;

    public Student(String name, int semester, Boolean isActive) {
        this.name = name;
        this.semester = semester;
        this.isActive = isActive;
    }

    public boolean isDoingMBKM(){
        if (semester >= 6 && isActive == true){
            return true;
        } else {
            return false;
        }
    }
}
