package projet1;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DataBaseConnexion;



import java.sql.Date;

 

public class Livre{
	private int id;
    private String title;
    private String author;
    private double price;
    private Date releaseDate;
    public Livre(String title, String author, double price, Date releaseDate, int id) {
        super();
        this.id=id;
        this.title = title;
        this.author = author;
        this.price = price;
        this.releaseDate = releaseDate;
    }
    public Livre() {
        // TODO Auto-generated constructor stub
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public Date getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }
    
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", price=" + price + ", releaseDate=" + releaseDate
                + "]";
    }
    
    
    public void addBook(String title, String author, double price,Date releaseDate) throws ClassNotFoundException, SQLException 
    { 
    DataBaseConnexion con;
    PreparedStatement pstmt;
    con = new DataBaseConnexion();
    
    pstmt =  con.MyConnection().prepareStatement("INSERT INTO `book`(id,title,author,price,releaseDate) VALUES (? , ?, ?, ?, ?)");
    pstmt.setNString(1, null );
    pstmt.setString(2, title );
    pstmt.setString(3, author );
    pstmt.setDouble(4,price);
    pstmt.setDate(5, releaseDate );
    System.out.println("addition with success");
    pstmt.executeUpdate();
        }
    
    public void displayBook() throws ClassNotFoundException, SQLException 
    {   DataBaseConnexion con;
    PreparedStatement pstmt;
    con = new DataBaseConnexion();
    try {
    pstmt = con.MyConnection().prepareStatement("SELECT * FROM Book "); 
    ResultSet rs = pstmt.executeQuery();
    int i=0;
    while (rs.next()) {
        i++;
        System.out.println("Book n° "+i);
        System.out.println("id : " + rs.getString("id"));
        System.out.println("title : " + rs.getString("title"));
        System.out.println("author : " + rs.getString("author"));
        System.out.println("price: " + rs.getString("price"));
        System.out.println("releaseDate : " + rs.getString("releaseDate"));
    }}
    catch(SQLException e)
    {e.printStackTrace();}

 

     }
   
    
    
    public void deleteBook(int id) throws ClassNotFoundException, SQLException 
    {    DataBaseConnexion con;
        PreparedStatement pstmt;
        con = new DataBaseConnexion();
        try {
            pstmt = con.MyConnection().prepareStatement("DELETE FROM book WHERE id =?"); 
   
            pstmt.setInt(1,id);
            pstmt.executeUpdate();
            System.out.println("successful deletion");
            }
        catch(SQLException e)
            {e.printStackTrace();}
            
      }

	public void updateBook(String title, String author, double price,Date releaseDate,int id) throws ClassNotFoundException, SQLException 
	{   DataBaseConnexion con;
	PreparedStatement pstmt;
    con = new DataBaseConnexion();
    
    try {
    		pstmt = con.MyConnection().prepareStatement("UPDATE book SET title = ?,author = ?,price = ?,releaseDate = ? WHERE id = ?"); 
    		pstmt.setInt(5, id );
    		pstmt.setString(1, title );
    		pstmt.setString(2, author );
    		pstmt.setDouble(3,price);
    		pstmt.setDate(4, releaseDate );
    		pstmt.executeUpdate();
    	}
    
    catch(SQLException e)
    {
    	e.printStackTrace();}    	
	 }
	
}

    
    

