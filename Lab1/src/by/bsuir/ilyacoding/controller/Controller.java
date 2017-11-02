package by.bsuir.ilyacoding.controller;

import by.bsuir.ilyacoding.controller.command.Command;

public class Controller {
	
	private final CommandProvider provider = new CommandProvider();
	
	public String doAction(String request) {

		String commandName;
		String params;

		String[] commandParams = request.split("\\|");
		commandName = commandParams[0];

		if (commandParams.length == 2) {
			params = commandParams[1];
		} else {
			params = "";
		}

		Command command = provider.getCommand(commandName);

		if (command == null) {
			return "Unknown command";
		}
		
		return command.execute(params);
	}

}
