package book;

public class test {
	
	public static void main (String[] args) {
		
		book book1 = new book(); 
		book book2 = new book("Real Book"); 
		String[] bothAuthors = new String[6]; 
		
		book1.setISBN("124sfg654fd");
		book1.setTitle("How to do your lab");
		book1.addAuthor("anyone");
		book1.addAuthor("nobody");
		//book1.addAuthor("somebody");
		
		System.out.println(book1.equals(book1)); 
		System.out.println(); 
		
		book2.setISBN("124sfg654flll");
		book2.addAuthor("Captain Obvious");
		book2.addAuthor("Captain Awesome");
		book2.addAuthor("CAPTAIN 1");
		book2.addAuthor("not an author"); 
		
		System.out.println(book2.equals(book1)); 
		System.out.println(); 
		
		System.out.println(book2.equals(book2)); 
		System.out.println(); 
		
		bothAuthors = book.getAllAuthors(book1, book2);
		for(int i = 0; i < 6; i++) {
			System.out.println(bothAuthors[i]);
		}
		System.out.println();
		
		
		System.out.println(book1.toString()); 
		System.out.println();
		System.out.println(book2.toString()); 
		System.out.println();
		
		
		
		
		
	} // of main

}
