package book; 

/*
 * Author:  Xiana Lara
 * Date:    01-28-19
 */
class book {
	
	private String title; 
	private int authorAmt; 
	public String[] authors; 
	private String ISBN; 
	
	public book () {
		
		// given assignments 
		title = null; 
		ISBN = null; 
		authorAmt = 0; 
		authors = new String[3]; 
		
	} // of book 
	
	public book (String _title) {
		
		// given assignments 
		title = _title; 
		ISBN = null; 
		authorAmt = 0; 
		authors = new String[3]; 
		
	} // of book
	
	public book (Object obj) {
		
		if( obj != null){
			if(obj instanceof book) {
				book objBook = (book)obj;
				title = objBook.title;
				authorAmt = objBook.authorAmt;
				ISBN = objBook.ISBN; 
				for(int i = 0; i < 3; i++) {
					if(objBook.authors[i] != null) {
						authors[i] = objBook.authors[i]; 
					} // of if 
				} // of for loop
			} // of if instance of 
		}// of if null 
	} // of book
	
	public String getTitle () {
		
		return title;

	} // of getTitle
	
	public int getAuthorNumber () {
		
		return authorAmt;
		
	} // of getAuthorNumber
	
	public String getISBN () {
		
		return ISBN;
		
	} // of getISBN
	
	public void setTitle(String _title) {
		
		title = _title;
		
	} // of setTitle
	
	public void setISBN (String _isbn) {
		
		ISBN = _isbn; 
		
	} // of setISBN
	
	public boolean addAuthor (String _author) {
		
		// if there is no first author one will be added
		if(authors[0] == null) {
			authors[0] = _author; 
			authorAmt = authorAmt + 1; 
			return true; 
		}
		// if there is no second author one will be added
		else if(authors[1] == null) {
			authors[1] = _author; 
			authorAmt = authorAmt + 1; 
			return true; 
		}
		// if there is no third author one will be added
		else if(authors[2] == null) {
			authors[2] = _author; 
			authorAmt = authorAmt + 1; 
			return true; 
		}
		// returns false if there is no available space
		else {
			return false; 
		}
	} // of addAuthor
	
	public boolean equals (Object obj) {
		
		if( obj != null){
			if(obj instanceof book) {
				book objBook = (book)obj;
				if(ISBN == objBook.getISBN()) {
					return true; 
				} // of if isbn
			} // of if instance of 
		}// of if null  
		
		return false;
		
	} // of equals
	
	public static String[] getAllAuthors (book b1, book b2) {
		
		String allAuthors[] = new String[6];
			for(int i = 0; i < b1.getAuthorNumber(); i++) {
				allAuthors[i] = b1.authors[i];
			}
			for(int i = 0; i < b2.getAuthorNumber(); i++) {
				if(allAuthors[i].equals(b2.authors[i])) {
					allAuthors[i] = b2.authors[i];
				}
				else{
					allAuthors[allAuthors.length - 1 - i] = b2.authors[i];
				}
			}
	
		return allAuthors; 
	} // of getAllAuthors
	
	/**
	* Generate a String representation of this book. 
	* 
	@param -none
	* 
	@return
	*   a String representation of this book. 
	**/
	public String toString () {
		
		// if there is no first author
		if(authors[0] == null) {
			return ("" + title + ", " + ISBN + ", " + authorAmt);
		}
		// if there is no second author one will be added
		else if(authors[1] == null) {
			return ("" + title + ", " + ISBN + ", " + authorAmt + ", " + 
					authors[0]);
		}
		// if there is no third author one will be added
		else if(authors[2] == null) {
			return ("" + title + ", " + ISBN + ", " + authorAmt + ", " + 
					authors[0] + ", " + authors[1]);
		}
		else {
			return ("" + title + ", " + ISBN + ", " + authorAmt + ", " + 
					authors[0] + ", " + authors[1]+ ", " + authors[2]);
		}
		
	} // of toString
	
	
} // of class
