package projet1;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import database.DataBaseConnexion;

public class Utilisateur   {
	private String CIN;
	private  String nom;
	private String prenom;
	private int t�l�phone;
	
	
	
	public Utilisateur(String CIN, String nom, String prenom, int t�l�phone) {
		super();
		CIN = CIN;
		this.nom = nom;
		this.prenom = prenom;
		this.t�l�phone = t�l�phone;
	}



	public Utilisateur() {
		super();
		
	}



	public String getCIN() {
		return CIN;
	}



	public void setCIN(String cIN) {
		CIN = cIN;
	}



	public  String getNom() {
		return nom;
	}



	public  void setNom(String nom) {
		this.nom = nom;
	}



	public String getPrenom() {
		return prenom;
	}



	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}



	public int getT�l�phone() {
		return t�l�phone;
	}



	public void setT�l�phone(int t�l�phone) {
		this.t�l�phone = t�l�phone;
	}



	public  void addutilisateur() throws ClassNotFoundException, SQLException
    {
		DataBaseConnexion con;
	    PreparedStatement pstmt;
	    
	    con = new DataBaseConnexion();
	    
        System.out.println(" CIN ");
        Scanner a1 = new Scanner( System.in );
        String CIN  = a1.nextLine();
        System.out.println(" nom ");
        Scanner a2 = new Scanner( System.in );
        String nom  = a2.nextLine();
        System.out.println(" prenom ");
        Scanner a3 = new Scanner( System.in );
        String prenom  = a3.nextLine();
        System.out.println(" t�l�phone ");
        Scanner a4 = new Scanner( System.in );
        String t�l�phone   = a4.nextLine();
        

        pstmt = con.MyConnection().prepareStatement("INSERT INTO `utilisateur`(CIN,nom,prenom,t�l�phone) VALUES (?, ?, ?, ?)");
        pstmt.setNString(1, CIN );
        pstmt.setString(2, nom );
        pstmt.setString(3, prenom);
        pstmt.setString(4,t�l�phone);
        
                   System.out.println("ajout avec success");
                   pstmt.executeUpdate();
    }
	
    
	public void displayUser() throws ClassNotFoundException, SQLException 
	{DataBaseConnexion con;
	PreparedStatement pstmt;
    con = new DataBaseConnexion();
    try {
    pstmt = con.MyConnection().prepareStatement("SELECT * FROM utilisateur "); 
    ResultSet rs = pstmt.executeQuery();
    int i=0;
    while (rs.next()) {
    	i++;
        System.out.println("User n�"+i);
        System.out.println("CIN:" + rs.getString("CIN")+" Nom : " 
        + rs.getString("nom")+" Prenom : " 
        + rs.getString("prenom")+" Telephone : " 
        + rs.getInt("t�l�phone") );
                       }
    	}
    catch(SQLException e)
    {e.printStackTrace();}
	 }

	public void deleteUser(String CIN) throws ClassNotFoundException, SQLException 
	{    DataBaseConnexion con;
		PreparedStatement pstmt;
		con = new DataBaseConnexion();
		try {
			pstmt = con.MyConnection().prepareStatement("DELETE FROM utilisateur WHERE CIN =?"); 
   
			pstmt.setString(1,CIN);
			pstmt.executeUpdate();
			System.out.println("successful deletion");
			}
		catch(SQLException e)
			{e.printStackTrace();}	
	  }
	
	
	
	public void updateUser(String nom, String prenom, long telephone,String CIN,String CIN1) throws ClassNotFoundException, SQLException 
	{   DataBaseConnexion con;
	PreparedStatement pstmt;
    con = new DataBaseConnexion();
    
    try {
    		pstmt = con.MyConnection().prepareStatement("UPDATE utilisateur SET CIN = ?,nom = ?,prenom = ?,t�l�phone = ? WHERE CIN = ?"); 
    		pstmt.setString(1, CIN);
    		pstmt.setString(2, nom);
    		pstmt.setString(3, prenom);
    		pstmt.setLong(4,telephone);
    		pstmt.setString(5,CIN1);
    		pstmt.executeUpdate();
    	}
    
    catch(SQLException e)
    {
    	e.printStackTrace();}    	
	 }
	





	
}
	