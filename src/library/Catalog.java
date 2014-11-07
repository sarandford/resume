package library;

import java.io.*;

/**
 * The Catalog class contains a singly linked list of book elements and provides
 * methods to manipulate those elements
 * 
 * @author Sarah Ford
 * @since September 2, 2014
 */
public class Catalog {
	private SinglyLinkedList<Book> books;

	/**
	 * The catalog constructor accepts an xml file containing information about
	 * books and implements parsing methods to gather data from the xml and
	 * create the book objects. It relies on methods from the SinglyLinkedList
	 * class
	 * 
	 * @param fileName
	 * @throws IOException
	 */
	public Catalog(String fileName) throws IOException {
		books = new SinglyLinkedList<Book>(0, null, null);
		BufferedReader input = new BufferedReader(new FileReader(fileName));
		String line = input.readLine();
		while (line != (null)) {
			if (line.contains("<book")) {
				// initalizes attributes requried to create book
				String id = null;
				String author = null;
				String title = null;
				String genre = null;
				String price = null;
				String publishDate = null;
				String description = null;
				if (line.contains("<book")) {
					// id attribute cannot be parsed by parse method
					id = line.split("=")[1];
					id = id.split(">")[0];
				}
				do {
					line = input.readLine();
					if (line.contains("author"))
						author = readBookXML("author", line);
					else if (line.contains("title"))
						title = readBookXML("title", line);
					else if (line.contains("genre"))
						genre = readBookXML("genre", line);
					else if (line.contains("price"))
						price = readBookXML("price", line);
					else if (line.contains("publish_date"))
						publishDate = readBookXML("publish_date", line);
					else if (line.contains("description")) {
						// descriptions are multi line and must be handled
						// seperatley
						description = line.split(">")[1].trim();
						line = input.readLine();
						while (!(line.contains("</description>"))) {
							description += " " + line.trim();
							line = input.readLine();
						}
						description += " " + line.split("<")[0].trim();
					}

				} while (!(line.contains("</book>")));
				// creating book object for node from gathered information
				Book book = new Book(id, author, title, genre, price,
						publishDate, description);
				books.addLast(book);
			}
			line = input.readLine();

		}
		input.close();
	}

	/**
	 * 
	 the readBookXML method parses the xml for the catalog xml information
	 * 
	 * @param String
	 *            attribute, determines which row to examine String input,
	 *            provides text from xml to parse
	 * @return String representing the attribute to store in Book objects
	 * 
	 */
	public String readBookXML(String attribute, String input)
			throws IOException {
		attribute = input.split(">")[1];
		attribute = attribute.split("<")[0];
		return attribute;
	}

	/**
	 * 
	 the addBookToCatalog method accepts book attributes and creates a book
	 * object and adds it to the singlylinkedlist contained in the catalog. It
	 * relies on the singly linked list class and its methods
	 * 
	 * @param String
	 *            id, String author, String title, String genre, String price,
	 *            String publishDate, String description, Each string provides
	 *            information about an attribute of a book object
	 * @return void
	 * 
	 */
	public void addBookToCatalog(String id, String author, String title,
			String genre, String price, String publishDate, String description) {
		Book book = new Book(id, author, title, genre, price, publishDate,
				description);
		books.addLast(book);
	}

	/**
	 * 
	 The removeBook method searchs for and removes an element from the
	 * catalog. It relies on the singly linked list class and its methods
	 * 
	 * @param String
	 *            title, provides the title to find the book to remove
	 * @return void
	 * 
	 */
	public void removeBook(String title) {// searches for exact string match
		for (int i = 1; i <= books.size(); i++) {
			Book currentBook = books.getElementAtPosition(i);
			if (currentBook.getTitle().equals(title)) {
				books.removeElementAtPosition(i);
				System.out.println("The book " + title + " has been removed");
				return;
			}
		}
		System.out
				.println("No book title matches your search. No books were removed");
	}

	/**
	 * 
	 the searcBook method accepts a substring which it compares to the titles
	 * of different book objects. It relies on the singly linked list class and
	 * its methods. It returns null if no match is found.
	 * 
	 * @param String
	 *            titlePiece, provides the substring for which the method
	 *            searches the book objects
	 * @return Book a book object with a matching substring
	 * 
	 */
	public String searchBook(String titlePiece) {// searches by substring
		String currentBookInfo = "";
		for (int i = 1; i <= books.size(); i++) {
			Book currentBook = books.getElementAtPosition(i);
			if (currentBook.getTitle().contains(titlePiece)) {
				currentBookInfo += currentBook.display();
			}
		}
		if (currentBookInfo.equals(""))
			return null;// returns null if the string is not found
		else
			return currentBookInfo;

	}

	/**
	 * 
	 the printCatalog method loops over the indvidual books contained in the
	 * sll of the catalog object and relies on methods from the singly linked
	 * list class and book class.
	 * 
	 * @param void
	 * @return void
	 * 
	 */
	public String printCatalog() {
		String bookInfo = "";
		for (int i = 1; i <= books.size(); i++) {
			bookInfo += books.getElementAtPosition(i).display();
		}
		return bookInfo;

	}

}
