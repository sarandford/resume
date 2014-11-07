package library;

/**
 * The book class creates a book object which allows for storage and access to
 * the title attribute of the book. Note: for the purposes of this program, no
 * other getters or setter methods were requried for effective implementation
 * and therefore are not included
 * 
 * @author Sarah Ford
 * @since September 2, 2014
 */
public class Book {
	private String id;
	private String author;
	private String title;
	private String genre;
	private String price;
	private String publishDate;
	private String description;

	public Book(String id, String author, String title, String genre,
			String price, String publishDate, String description) {
		this.id = id;
		this.author = author;
		this.title = title;
		this.genre = genre;
		this.price = price;
		this.publishDate = publishDate;
		this.description = description;
	}

	/**
	 * 
	 the get title method is a getter which returns a string of the title
	 * attribute It does not depend on any other methods or classes.
	 * 
	 * @param void
	 * @return String representing the title
	 * 
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 
	 the display method returns a string of the attributes of the book which
	 * can be used to write the information to a file or display to the console.
	 * It does not depend on any other methods or classes.
	 * 
	 * @param void
	 * @return String representing all the relevant book attributes
	 * 
	 */
	public String display() {
		return ("Id:" + id + "\nBook Title: " + title + "\nAuthor: " + author
				+ "\nGenre: " + genre + "\n" + "Publish Date: " + publishDate
				+ "\nDescription: " + description + "\n\n");
	}
}
