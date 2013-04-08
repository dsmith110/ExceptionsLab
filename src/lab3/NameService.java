package lab3;

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
    private static final String INVALID_NAME_ERR_MSG = "Invalid name";
    private static final String INVALID_CHARACTER_ERR_MSG = "Invalid name";
    private static final String ENTRY_REQUIRED_ERR_MSG = "Entry required";
    
    /**
     * Finds and returns the last name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the last name
     */
    public String extractLastName(String fullName) throws IllegalArgumentException {
        
        if(fullName == null || fullName.length() == 0) {
            throw new IllegalArgumentException(ENTRY_REQUIRED_ERR_MSG);
        }
        
        char nameChars[] = fullName.toCharArray();
        for (char c : nameChars) {
            if(!Character.isLetter(c) && !(c == ' ') && !(c == ',')) {
                throw new IllegalArgumentException(INVALID_CHARACTER_ERR_MSG);
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
            throw new IllegalArgumentException(INVALID_NAME_ERR_MSG);
        }
    }
    
    /**
     * Finds and returns the first name from within a full name. Caution: 
     * No validation is performed.
     * 
     * @param fullName - a name containing a first name and a last name
     * @return the first name
     */
    public String extractFirstName(String fullName) 
            throws IllegalArgumentException, InvalidNameException {
        if(fullName == null || fullName.length() == 0) {
            throw new InvalidNameException();
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
    public int getNameLength(String name) throws InvalidNameException {
        if(name == null || name.length() == 0) {
            throw new InvalidNameException();
        }
        return name.length();
    }
    
}
