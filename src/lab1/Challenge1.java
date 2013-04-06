package lab1;

import javax.swing.JOptionPane;

/**
 * The purpose of this challenge is to give you practice time using
 * Java Exception handling techniques.
 * <p>
 * Your challenge is to consider all the possible things that can go wrong
 * with this program and use exception handling where appropriate to prevent
 * the program from crashing. In addition you must display a friendly error
 * message in a JOptionPane and ask the user to try again.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class Challenge1 {
    private static final int LAST_NAME_IDX = 1;
    private static final int LAST_NAME_IDX_WITH_MIDDLE = 2;
    private static final int LAST_NAME_IDX_COMA = 0;

    public static void main(String[] args) {
        Challenge1 app = new Challenge1();
        
        String fullName = JOptionPane.showInputDialog("Enter full name:");
        String lastName = app.extractLastName(fullName);
        String msg = "Your last name is: " + lastName;
        JOptionPane.showMessageDialog(null, msg);
    }
    
    /**
     * Name cannot be zero or null. Name can be first and last or first, last,
     * and middle initial. Last name could be first.
     * @param fullName
     * @return 
     */
    public String extractLastName(String fullName) {
        if(fullName == null || fullName.length() == 0) {
            throw new IllegalArgumentException("Entry required.");
        }
        
        char nameChars[] = fullName.toCharArray();
        for (char c : nameChars) {
            if(!Character.isLetter(c) && !(c == ' ') && !(c == ',')) {
                throw new IllegalArgumentException("Invalid character found");
            }
        }
        
        String nameParts[] = fullName.split(" ");
        
        if(fullName.contains(", ")) {
            return nameParts[LAST_NAME_IDX_COMA].replace(",", "");
        } else if(nameParts.length == 2) {
                return nameParts[LAST_NAME_IDX];
        } else if(nameParts.length == 3) {
                return nameParts[LAST_NAME_IDX_WITH_MIDDLE];
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
        
    }

}
