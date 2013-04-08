package lab2;

/**
 * This class provides various services relating to name manipulation.
 * No output should be performed here.
 * 
 * @author  Jim Lombardo, jlombardo@wctc.edu
 * @version 1.00
 */
public class NameService {
    private static final int FIRST_NAME_IDX = 0;
    private static final int FIRST_NAME_IDX_COMA = 1;
    private static final int LAST_NAME_IDX = 1;
    private static final int LAST_NAME_IDX_COMA = 0;
    private static final int LAST_NAME_IDX_WITH_MIDDLE = 2;
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) throws IllegalArgumentException {
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
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) throws IllegalArgumentException {
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
            return nameParts[FIRST_NAME_IDX_COMA];
        } else if(nameParts.length == 2 || nameParts.length == 3) {
                return nameParts[FIRST_NAME_IDX];
        } else {
            throw new IllegalArgumentException("Invalid name");
        }
    }

    /**
     * Gets the length of a name.
     * 
     * @param name - any full name or part of a name.
     * @return the length of the name or part.
     */
    public int getNameLength(String name) throws IllegalArgumentException {
        if(name == null || name.length() == 0) {
            throw new IllegalArgumentException("Entry required");
        }
        return name.length();
    }
    
}
