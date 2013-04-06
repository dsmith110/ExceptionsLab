package lab0;

import java.util.Date;

/**
 * In this challenge you need to address the probability that at some
 * point the arguments to method parameters may not be valid. 
 * <p>
 * For example, String arguments may be null or empty; other objects may be 
 * null; or primitive numbers may be out of acceptable range.
 * <p>
 * You need to validate ALL method parameters to make sure any and all 
 * arguments are valid. The only exception is when any argument is acceptable 
 * based on requirements. Fix the code below using if logic to validate
 * method arguments and throw IllegalArgumentException or a custom
 * exception if the validation fails.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Employee {
    public static final int MAX_VACATION_DAYS = 28;
    public static final int MIN_VACATION_DAYS = 0;
    private String firstName;
    private String lastName;
    private String ssn;
    private Date hireDate;
    private int daysVacation;
    private static final String VACATION_ERROR = "Vacation days must be between"
            + MIN_VACATION_DAYS + " and " + MAX_VACATION_DAYS;

    public Employee() {
        firstName = "Unknown";
        lastName = "Unknown";
        ssn = "Unknown";
        hireDate = new Date();
        daysVacation = 0;
    }

    public Employee(String firstName, String lastName, String ssn, Date hireDate, int daysVacation) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
        this.hireDate = hireDate;
        this.daysVacation = daysVacation;
    }
    
    public int getDaysVacation() {
        return daysVacation;
    }

    public void setDaysVacation(int daysVacation) {
        if(daysVacation > MAX_VACATION_DAYS || daysVacation < MIN_VACATION_DAYS) {
            throw new IllegalArgumentException(VACATION_ERROR);
        }
        this.daysVacation = daysVacation;
    }

    public String getFirstName() {
        return firstName;
    }

    /**
     * Do not allow null or zero length. Ask about numeric first names.
     * Maybe allow numbers at the end only. Allow hyphens only or spaces.
     * Allow any letter case for the text and massage later in code depending 
     * on requirements.
     * 
     * @param firstName 
     */
    public void setFirstName(String firstName) { 
        if(firstName == null || firstName.length() == 0) {
            throw new IllegalArgumentException("Entry Required.");
        }
        
        char[] chars = firstName.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                throw new IllegalArgumentException("Name must contain letters");
            }
        }
        this.firstName = firstName;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null || lastName.length() == 0) {
            throw new IllegalArgumentException("Entry Required.");
        }
        
        char chars[] = lastName.toCharArray();
        for (char c : chars) {
            if(!Character.isLetter(c)) {
                throw new IllegalArgumentException("Name must contain letters");
            }
        }
        
        this.lastName = lastName;
    }

    public final String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    public static void main(String[] args) {
        Employee e = new Employee();
        e.setFirstName("D@n");
        System.out.println(e.getFirstName());
    }
}
