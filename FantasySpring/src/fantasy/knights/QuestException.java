package fantasy.knights;

public class QuestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Parameterless Constructor
    public QuestException() {}

    //Constructor that accepts a message
    public QuestException(String message)
    {
       super(message);
    }
}
