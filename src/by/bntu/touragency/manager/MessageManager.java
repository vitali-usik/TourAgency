package by.bntu.touragency.manager;

import java.util.ResourceBundle;

/**
 * A utility class that retrieves from the property file necessary information
 * for the functioning of the application command
 */
public class MessageManager {

	private static MessageManager instance;
	private ResourceBundle resourceBundle;
	//  class retrieves information from a messages.properties
	private static final String BUNDLE_NAME = "resource/messages";
	public static final String LOGIN_ERROR_MESSAGE = "LOGIN_ERROR_MESSAGE";
	public static final String SERVLET_EXCEPTION_ERROR_MESSAGE = 
			"SERVLET_EXCEPTION_ERROR_MESSAGE";
	public static final String IO_EXCEPTION_ERROR_MESSAGE =
			"IO_EXCEPTION_ERROR_MESSAGE";
	
	public static MessageManager getInstance() {
		
		if (instance == null) {
			instance = new MessageManager();
			instance.resourceBundle = ResourceBundle.getBundle(BUNDLE_NAME);
		}
		return instance;
	}
	
	public String getProperty(String key) {
		return (String)resourceBundle.getObject(key);
	}
}