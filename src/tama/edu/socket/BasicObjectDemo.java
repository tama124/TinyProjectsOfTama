package tama.edu.socket;

import java.io.Serializable;

public class BasicObjectDemo implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String name;

	public BasicObjectDemo(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + "]";
	}
}
