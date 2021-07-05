import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Employee {
    private String name;
    private Integer salary;
    public Date workStart;
    private Calendar workStartDate;

    public Employee(String name, Integer salary, Date workStart) {
        this.name = name;
        this.salary = salary;
        this.workStart = workStart;
        this.workStartDate = new GregorianCalendar();
        this.workStartDate.setTime(workStart);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return this.salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Date getWorkStart() {
        return this.workStart;
    }

    public int getWorkStartYear() {
        return this.workStartDate.get(1);
    }

    public String getDate() {
        return (new SimpleDateFormat("dd.MM.yyyy")).format(this.workStart);
    }

    public void setWorkStart(Date workStart) {
        this.workStart = workStart;
    }

    public String toString() {
        String var10000 = this.name;
        return var10000 + " - " + this.salary + " - " + (new SimpleDateFormat("dd.MM.yyyy")).format(this.workStart);
    }
}
