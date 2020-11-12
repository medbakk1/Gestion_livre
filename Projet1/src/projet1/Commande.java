package projet1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import database.DataBaseConnexion;

public class Commande {
	
	
	
	
	

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}



	



	public void addCommande() throws ClassNotFoundException, SQLException
    { double pricebook = 0;
    DataBaseConnexion con;
    PreparedStatement pstmt;
    con = new DataBaseConnexion();
    System.out.println("Entrez l'id du livre ");
    Scanner sc1 = new Scanner( System.in );
    int id   = sc1.nextInt();
    System.out.println("Entrez la quantité ");
    Scanner sc2 = new Scanner( System.in );
    int quantite   = sc2.nextInt();
     try {
            pstmt = con.MyConnection().prepareStatement("SELECT * FROM Book where id = ? ");
            pstmt.setDouble(1,id);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
                {
                 pricebook =Double.parseDouble(rs.getString("price"));
                }
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
    pstmt =  con.MyConnection().prepareStatement("INSERT INTO `commande`(id_commande,id,price_cmd,quantite,total) VALUES ( ?, ?, ?, ?,?)");
    pstmt.setNString(1, null );
    pstmt.setLong(2, id );
    pstmt.setDouble(3,pricebook);
    pstmt.setInt(4, quantite );
    pstmt.setDouble(5,pricebook*quantite );
    System.out.println("addition with success");
    pstmt.executeUpdate();
    }
	
	  
	

}
