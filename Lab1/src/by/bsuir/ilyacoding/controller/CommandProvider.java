package by.bsuir.ilyacoding.controller;

import java.util.HashMap;
import java.util.Map;

import by.bsuir.ilyacoding.controller.command.Command;
import by.bsuir.ilyacoding.controller.command.impl.*;

class CommandProvider {
	private Map<String, Command> commands = new HashMap<>();

	CommandProvider() {
		commands.put("register", new RegisterCommand());
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());

		commands.put("add_book", new AddBookCommand());
		commands.put("delete_book", new DeleteBookCommand());
		commands.put("get_books", new GetAllBooksCommand());
		commands.put("get_book", new GetBookCommand());
		commands.put("find_by_author", new GetBookByAuthorCommand());
		commands.put("find_by_title", new GetBookByTitleCommand());
		commands.put("find_by_type", new GetBookByTypeCommand());
		commands.put("help", new HelpCommand());
	}

	Command getCommand(String commandName) {
		return commands.get(commandName);
	}
}
