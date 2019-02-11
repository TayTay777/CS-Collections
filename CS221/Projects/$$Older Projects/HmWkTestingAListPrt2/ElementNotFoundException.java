/**
 * ElementNotFoundException - when an element is not found in a collection
 *
 * @version fall 2015
 */
public class ElementNotFoundException extends RuntimeException
{
    private static final long serialVersionUID = 6949716950385988835L;

     /**
      * @param collection - String representing collection that threw the exception
      */
    public ElementNotFoundException (String collection)
    {
	    super ("Element not found in " + collection);
    }
}