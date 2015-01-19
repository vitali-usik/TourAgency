package by.bntu.touragency.helper;

import java.util.*;

import javax.servlet.http.HttpServletRequest;

import by.bntu.touragency.command.BookCommand;
import by.bntu.touragency.command.Command;
import by.bntu.touragency.command.ConfirmBookCommand;
import by.bntu.touragency.command.HomeCommand;
import by.bntu.touragency.command.LoginCommand;
import by.bntu.touragency.command.NoCommand;
import by.bntu.touragency.command.ViewAllUsersCommand;
import by.bntu.touragency.command.ViewMyToursCommand;

/**
 * Class which contain commands
 */
public class RequestHelper {

	private static RequestHelper instance = null;
	private HashMap<String, Command> commands = new HashMap<String, Command>();
	
	private RequestHelper() {
		// fill the table with commands
		commands.put("home", new HomeCommand());
		commands.put("login", new LoginCommand());
		commands.put("book", new BookCommand());
		commands.put("confirmBook", new ConfirmBookCommand());
		commands.put("viewMyTours", new ViewMyToursCommand());
		commands.put("viewAllUsers", new ViewAllUsersCommand());
	}
	
	/**
	 * Recovery command from the query
	 * @param request
	 * @return command
	 */
	public Command getCommand(HttpServletRequest request) {	
		// recovery command from the query
		String action = request.getParameter("command");
		// obtaining the object corresponding to the command
		Command command = commands.get(action);
		
		if (command == null) {
			// if the command does not exist in the current object
			command = new NoCommand();
		}
		return command;
	}
	
	/** 
	 * the creation of a single object from a Singleton pattern
	 */
	public static RequestHelper getInstance() {
		if (instance == null) {
			instance = new RequestHelper();
		}
		return instance;
	}
}
