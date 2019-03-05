import com.subham.assessment.models.Employee;
import com.subham.assessment.models.EmployeeRole;
import com.subham.assessment.models.EmployeeType;
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
}
