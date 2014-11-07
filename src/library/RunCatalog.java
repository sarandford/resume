package library;

import java.io.*;
import java.util.Scanner;

/**
 * The Runcatalog class runs an instance of the catalog and allows a user to
 * interact with it
 * 
 * @author Sarah Ford
 * @since September 2,2014
 * @status Functioning properly
 */
public class RunCatalog {
	private Catalog bookCatalog;
	private Scanner in;

	public RunCatalog() throws IOException {
		bookCatalog = new Catalog("catalog.xml");
		in = new Scanner(System.in);
	}

	/**
	 * 
	 the main method creates and instantiates an instance of catalog and
	 * prompts the user for input. It relies on the catalog class
	 * 
	 * @param String
	 *            [] args an empty string array
	 * @return void
	 * 
	 */
	public static void main(String[] args) throws IOException {
		RunCatalog runner = new RunCatalog();
		System.out
				.print("Enter a number from the following options then follow the instrutions: \n"
						+ "1. Add a book to the catalog\n"
						+ "2. Remove a book from the catalog by title\n"
						+ "3. Search for all books\n"
						+ "4. Print the catalog\n" + "5. End program\n");
		String input = "";// initalizing container variable for parsing user
							// input
		do {
			System.out.println("Enter an Option(1-5): ");
			input = runner.in.nextLine();
			// System.out.println(input);
			if (input.contains("4")) {
				System.out.println(runner.bookCatalog.printCatalog());
				continue;
			} else if (input.contains("3")) {
				runner.search();
			} else if (input.contains("2")) {
				runner.remove();
				continue;
			} else if (input.contains("1")) {
				runner.add();
				continue;
			}
		} while (!input.contains("5"));
		runner.exit();

	}

	/**
	 * 
	 the add method invokes the addBookToCatalog function from the catalog
	 * class but gathers the neccesary data from user input
	 * 
	 * @param void
	 * @return void
	 * 
	 */
	public void add() {
		System.out
				.println("Please enter the data for your new entry after each prompt: ");
		System.out.println("Id: ");
		String id = in.nextLine();
		System.out.println("Title: ");
		String title = in.nextLine();
		System.out.println("Author(Last,First): ");
		String author = in.nextLine();
		System.out.println("Genre: ");
		String genre = in.nextLine();
		System.out.println("Price: ");
		String price = in.nextLine();
		System.out.println("Publish date: ");
		String publishDate = in.nextLine();
		System.out.println("Description: ");
		String description = in.nextLine();
		bookCatalog.addBookToCatalog(id, author, title, genre, price,
				publishDate, description);
		System.out.println(title + " has been added");
	}

	/**
	 * 
	 the search method uses the search method from the catalog class by and
	 * accepts user input as its parameters
	 * 
	 * @param void
	 * @return void
	 * 
	 */
	public void search() {
		System.out
				.println("Enter the title or part of the title for the book which you would like to find: ");
		String title = in.nextLine().trim();
		String entry = bookCatalog.searchBook(title);
		if (entry != (null))
			System.out.println(entry);
		else
			System.out
					.println("No book title matches your search. Please try a new search");
	}

	/**
	 * the remove method uses the remove method in catalog but accepts user
	 * input as parameters
	 * 
	 * @param void
	 * @return void
	 * 
	 */
	public void remove() {
		System.out
				.println("Please enter the exact title of the book which you would like to remove");
		String title = in.nextLine().trim();
		bookCatalog.removeBook(title);

	}

	public void exit() throws IOException {
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
				new FileOutputStream("bookCatlog.txt")));
		writer.write(print());
		writer.close();
		System.out
				.println("Program Ended. Catalog has ben saved to bookCatalog.txt");
		System.exit(0);
	}

	public String print() {
		return bookCatalog.printCatalog();
	}
}
