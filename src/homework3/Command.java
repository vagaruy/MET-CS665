/*
Command Interface which is implemented in subclasses.
 */

package homework3;

/**
 *
 * @author Testing
 */
public interface Command {
    	public void execute();
	public void undo();
}

