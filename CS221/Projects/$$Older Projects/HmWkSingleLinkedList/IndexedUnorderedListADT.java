import java.util.ListIterator;

/**
 * Combines UnorderedListADT and IndexedListADT interfaces, for convenience
 * 
 * @author BSU CS221
 */
public interface IndexedUnorderedListADT<T> extends UnorderedListADT<T>, IndexedListADT<T> {
	//That's it. This interface includes all methods from UnorderedListADT,
	// IndexedListADT, and, by extension, ListADT.
}
