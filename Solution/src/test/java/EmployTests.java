import com.subham.assessment.models.*;
import com.subham.assessment.services.EmployeeCreator;
import com.subham.assessment.utils.ValidityChecker;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.junit.Assert;
import org.junit.Test;

public class EmployTests {
    @Test
    public void emailChecker1(){
        String email = new String("abc@gmail.com");
        ValidityChecker validityChecker = new ValidityChecker();
        Assert.assertEquals(true, validityChecker.isEmailValid(email));
    }

    @Test
    public void emailChecker2(){
        String email = new String("@gmail.com");
        ValidityChecker validityChecker = new ValidityChecker();
        Assert.assertEquals(false, validityChecker.isEmailValid(email));
    }

    @Test
    public void emailChecker3(){
        String email = new String("abcgmail.com");
        ValidityChecker validityChecker = new ValidityChecker();
        Assert.assertEquals(false, validityChecker.isEmailValid(email));
    }

    @Test
    public void emailChecker4(){
        String email = new String("abcgmail.com");
        ValidityChecker validityChecker = new ValidityChecker();
        Assert.assertEquals(false, validityChecker.isEmailValid(email));
    }

    @Test
    public void emailChecker5(){
        String email = new String("abcgmail.");
        ValidityChecker validityChecker = new ValidityChecker();
        Assert.assertEquals(false, validityChecker.isEmailValid(email));
    }

    @Test
    public void nameChecker1(){
        String name = new String("Hashmap");
        ValidityChecker validityChecker = new ValidityChecker();
        Assert.assertEquals(true, validityChecker.isNameValid(name));
    }

    @Test
    public void nameChecker2(){
        String name = new String("HashmapHashmapHashmapHashmapHashmapHashmapHashmapHashmapHashmap");
        ValidityChecker validityChecker = new ValidityChecker();
        Assert.assertEquals(false, validityChecker.isNameValid(name));
    }

    @Test
    public void validEmployee1(){
        EmployeeCreator employeeCreator= new EmployeeCreator();
        Employee employee = employeeCreator.createEmployee("Ram", "ram@gmail.com", "01/03/2018", EmployeeType.PROBATION, EmployeeRole.ADMIN);
        Assert.assertNotEquals(null, employee);
    }

    @Test
    public void invalidEmployee2(){
        EmployeeCreator employeeCreator= new EmployeeCreator();
        Employee employee = employeeCreator.createEmployee("Ram", "@gmail.com", "01/03/2018", EmployeeType.PROBATION, EmployeeRole.ADMIN);
        Assert.assertEquals(null, employee);
    }

    @Test
    public void leavetest1(){
        EmployeeCreator employeeCreator= new EmployeeCreator();
        Employee employee = employeeCreator.createEmployee("Ram", "abc@gmail.com", "01/03/2018", EmployeeType.PROBATION, EmployeeRole.ADMIN);
        Assert.assertEquals(0, employee.getleave(LeaveType.SICKLEAVE));
    }

    @Test
    public void leavetest2(){
        EmployeeCreator employeeCreator= new EmployeeCreator();
        Employee employee = employeeCreator.createEmployee("Ram", "abc@gmail.com", "01/03/2018", EmployeeType.PERMANENT, EmployeeRole.ADMIN);
        Assert.assertEquals(5, employee.getleave(LeaveType.SICKLEAVE));

    }

    @Test
    public void leavetest3(){
        EmployeeCreator employeeCreator= new EmployeeCreator();
        Employee employee = employeeCreator.createEmployee("Ram", "abc@gmail.com", "01/03/2018", EmployeeType.PERMANENT, EmployeeRole.ADMIN);
        Assert.assertEquals(5, employee.getleave(LeaveType.CASUALLEAVE));

    }

    @Test
    public void leavetest4(){
        EmployeeCreator employeeCreator= new EmployeeCreator();
        Employee employee = employeeCreator.createEmployee("Ram", "abc@gmail.com", "01/03/2018", EmployeeType.PERMANENT, EmployeeRole.ADMIN);
        Assert.assertEquals(15, employee.getleave(LeaveType.PRIVILEGELEAVE));
    }

    @Test
    public void holidayexiststest(){
        EmployeeCreator employeeCreator= new EmployeeCreator();
        Employee employee = employeeCreator.createEmployee("Ram", "abc@gmail.com", "01/03/2018", EmployeeType.PERMANENT, EmployeeRole.ADMIN);
        Holidays holidays = Employee.getHolidays();
        Assert.assertEquals(true, holidays.isHoliday("26/01/2019"));
    }
}
