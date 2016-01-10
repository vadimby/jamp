package by.epam.jamp.module5;

import by.epam.jamp.module5.main.ConsoleMenu;

public class ConsolePrinterImpl implements ConsolePrinter {

	public void show(ConsoleMenu consoleMenu) {
		clean();
//		System.out.print("\r");
		for (String point : consoleMenu.getPoints().keySet()) {
			for (int i = 0; i < 300; i++) {
				System.out.print("==");
			}
			System.out.print(point);
			System.out.print("\n");
		}

	}

	private void clean() {
		for (int i = 0; i < 700; i++) {
			System.out.print("\b");
		}
		
	}

	public void close() {
		System.out.println();
	}

}
