package by.bsuir.ilyacoding.domain;

import java.io.Serializable;

public class Book implements Serializable {
	private static final long serialVersionUID = 4232432473924732L;

	private String title;
	private String author;
	private Type type;

	public enum Type { ELECTRONIC, PAPER }

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
