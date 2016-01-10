package by.epam.jamp.module5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import by.epam.jamp.module5.main.ConsoleMenu;
import by.epam.jamp.module5.main.command.AddCommandImpl;
import by.epam.jamp.module5.main.command.Command;

public class Runner {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	// public static void main(String[] args) {
	// AnsiConsole.out(ANSI_RED + "This text is red!" + ANSI_RESET);
	// System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);
	// }

	static void updateProgress(double progressPercentage) {
		final int width = 50; // progress bar width in chars

		System.out.print("\r" + ANSI_RED + "[");
		int i = 0;
		for (; i <= (int) (progressPercentage * width); i++) {
			System.out.print(".");
		}
		for (; i < width; i++) {
			System.out.print(" ");
		}
		System.out.print(ANSI_RED + "]");
	}

	// public static void main(String[] args) {
	// try {
	// for (double progressPercentage = 0.0; progressPercentage < 1.0;
	// progressPercentage += 0.01) {
	// updateProgress(progressPercentage);
	// Thread.sleep(20);
	// }
	// } catch (InterruptedException e) {
	// }
	// }

	public static void main(String[] args) {
		Map<String, Command> list = new HashMap<String, Command>();
		list.put("1. Add", new AddCommandImpl());
		list.put("0. Exit", null);
		ConsoleMenu consoleMenu = new ConsoleMenu(list);
		ConsolePrinter printer = new ConsolePrinterImpl();
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			boolean exit = false;
			while (!exit) {
				printer.show(consoleMenu);
				int input = Integer.valueOf(br.readLine());
				if (input == 13 || input == 10) {
					continue;
				}
				if (input == 49) {
					System.out.print(input);
				}
				/*
				 * if(input != null) { System.out.println("Your input is : " +
				 * input); if ("quit".equals(input)) { System.out.println(
				 * "Exit programm"); exit = true; } else if ("x".equals(input))
				 * { //Do something } }
				 */
				Thread.sleep(3000);

			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

		}
	}

}
