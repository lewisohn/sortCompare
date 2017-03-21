package sortcompare.logic;

public abstract class Select {

	abstract void options();
	
	abstract void preview();
	
	abstract void reset();
	
	void prompt(String string) {
		System.out.println(string);
		System.out.print("> ");
	}

	void invalid() {
		prompt("Invalid number; please try again:");
	}
}
