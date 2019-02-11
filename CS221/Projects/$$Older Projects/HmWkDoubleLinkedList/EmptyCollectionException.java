/**
 * EmptyCollectionException - when a collection has not elements in it. 
 *
 * @version fall 2015
 */
public class EmptyCollectionException extends RuntimeException
{
	private static final long serialVersionUID = 6343822576951798603L;

	/**
     * @param collection - String representing the collection that threw the exception 
     */
    public EmptyCollectionException (String collection)
    {
        super (collection + " is empty.");
    }
}