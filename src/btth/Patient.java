package btth;

public class Patient {
    private String ID;
    private String Name;
    private int age;
    private String sex;
    private String sickduck;

    public Patient(String ID, String name, int age, String sex, String sickduck) {
        this.ID = ID;
        Name = name;
        this.age = age;
        this.sex = sex;
        this.sickduck = sickduck;
    }

    public String getID() {
        return ID;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public String getSickduck() {
        return sickduck;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setSickduck(String sickduck) {
        this.sickduck = sickduck;
    }
}
