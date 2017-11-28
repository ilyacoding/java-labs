package by.bsuir.ilyacoding.Server.controller.command;


import by.bsuir.ilyacoding.Server.controller.command.impl.*;
import java.util.HashMap;
import java.util.Map;

public class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();

	public CommandProvider() {
		commands.put("register", new RegisterCommand());
		commands.put("login", new LogInCommand());
		commands.put("logout", new LogOutCommand());

		commands.put("add", new AddAffairCommand());
		commands.put("get", new GetAffairByIdCommand());
		commands.put("delete", new DeleteAffairCommand());
		commands.put("update", new UpdateAffairCommand());
		commands.put("all", new GetAllAffairsCommand());
	}

	public Command getCommand(String commandName) {
		Command command;
		command = commands.get(commandName);
		return command;

	}

}
