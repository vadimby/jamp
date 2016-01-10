package by.epam.jamp.module5.runner.commands;

public class ShowModulesCommand implements MenuCommand {

	public void run() {
		System.out.println("List of the loaded modules: ");
		System.out.println("module1");
		System.out.println("module2");
		System.out.println("module3");
		System.out.println("module4");
	}

}
