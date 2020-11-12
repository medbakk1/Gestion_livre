package projet1;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import database.DataBaseConnexion;

public class Test {
	
	public static void totalPrice() throws ClassNotFoundException {
        double Totalprice=0;
        try {
        	DataBaseConnexion con;
            PreparedStatement pstmt;
            con = new DataBaseConnexion();
            pstmt = con.MyConnection().prepareStatement("SELECT total FROM commande ");
          
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
                {
                 Totalprice += Double.parseDouble(rs.getString("total"));
                }
            System.out.println();
            System.out.println("total to pay "+Totalprice);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
      
      
    }
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
			System.out.println("welcome ");
			Livre book = new Livre();
			Utilisateur user = new Utilisateur();
			Commande cmd1= new Commande();
			byte choix=0;
 
			
			
			System.out.println("Bienvenu ");
			System.out.println("1:Ajout du livre ");
			System.out.println("2:suppression du livre  ");
			System.out.println("3:mise a jour du livre ");
			System.out.println("4:commander ");
			System.out.println("5:affichage des livres ");
			System.out.println("6:Ajout utilisateur ");
			System.out.println("7:suppression utilisateur ");
			System.out.println("8:mise a jour utilisateur ");
			System.out.println("9:affichage des utilisateurs ");
			System.out.println("10: Ajout d'une commande");
			System.out.println("11: Affiche d'une commande");
			System.out.println("12: le prix total est");
			System.out.println("13:tronquer ");
			System.out.println("14:Exit ");

			Scanner sc3 = new Scanner( System.in );
			choix   = sc3.nextByte();
			switch(choix) {
			  case 1:
			  	{	
				System.out.println("entrez le titre du livre");
				Scanner sc = new Scanner( System.in );
				String title   = sc.nextLine();
				System.out.println(" entrez le nom de l'auteur du livre");
				Scanner sc1 = new Scanner( System.in );
				String author   = sc1.nextLine();
				System.out.println("entrez le prix du livre ");
				Scanner sc2 = new Scanner( System.in );
				double price   = sc2.nextDouble();	
				System.out.println("entrez la date d'édition du livre");
	            Scanner sc5 = new Scanner( System.in );
	            String doj=sc5.next();
	            Date releasedate=java.sql.Date.valueOf(doj);
				book.addBook(title, author, price, releasedate);
					break;
				}
			  case 2:
			  	{
				  book.displayBook();	
				  System.out.println("entrez l' id du livre ");
					Scanner sc = new Scanner( System.in );
					int id   = sc.nextInt();
					book.deleteBook(id);
					break;
				}
			  case 3:
			  {
				  System.out.println("entrez l' id du livre");
				Scanner sc4 = new Scanner( System.in );
				int id   = sc4.nextInt();
				  System.out.println("entrez le titre du livre ");
				Scanner sc = new Scanner( System.in );
				String title   = sc.nextLine();
				System.out.println("entrez le nom de l'auteur du livre ");
				Scanner sc1 = new Scanner( System.in );
				String author   = sc1.nextLine();
				System.out.println("entrez le prix du livre ");
				Scanner sc2 = new Scanner( System.in );
				double price   = sc2.nextDouble();	
				System.out.println("entrez la date d'édition du livre");
	          Scanner sc5 = new Scanner( System.in );
	          String doj=sc5.next();
	          Date releasedate=java.sql.Date.valueOf(doj);
				book.updateBook(title, author, price, releasedate, id);
				break;}
			  case 4:
			  {			  book.displayBook();

				  System.out.println("entrez l'id du livre ");
					Scanner sc1 = new Scanner( System.in );
					int id   = sc1.nextInt();
					System.out.println("entrez la quantité ");
					Scanner sc2 = new Scanner( System.in );
					int quantite   = sc2.nextInt();
				  
				  
					break;
					}
			  case 5:
			  {
				  book.displayBook();
					break;
				}
			  case 6:
			  {
					user.addutilisateur();
				break;}
			  case 7:
			  {user.displayUser();	
			  System.out.println("entrez CIN ");
				Scanner sc = new Scanner( System.in );
				String CIN  = sc.nextLine();
				user.deleteUser(CIN);
				break;
					}
			  case 8:
			  {System.out.println("entrez CIN ");
				Scanner sc5 = new Scanner( System.in );
				String CIN   = sc5.nextLine();
				System.out.println("entrez le nouveau CIN1 ");
				Scanner sc6 = new Scanner( System.in );
				String CIN1   = sc6.nextLine();
				  System.out.println("entrez le nom ");
				Scanner sc = new Scanner( System.in );
				String nom   = sc.nextLine();
				System.out.println("entrez le prenom ");
				Scanner sc1 = new Scanner( System.in );
				String prenom   = sc1.nextLine();
				System.out.println("entrez le telephone ");
				Scanner sc2 = new Scanner( System.in );
				long tele = sc2.nextLong();	
				
					user.updateUser(nom,prenom,tele,CIN,CIN1);
				break;
					}
			  case 9:
			  {user.displayUser();
					break;}
			  case 10:
			  {
				  cmd1.addCommande();
				break;}
			case 11:
            { 
                 
                    DataBaseConnexion con;
                    PreparedStatement pstmt;
                    con = new DataBaseConnexion();
                     pstmt = con.MyConnection().prepareStatement("SELECT * FROM Commande "); 
                    ResultSet rs = pstmt.executeQuery();
                    int i=0;
                    while (rs.next()) {
                        
                           String id_commande = rs.getString("id_commande");
                           String id = rs.getString("id");
                           String price = rs.getString("price_cmd");
                           String Quantite = rs.getString("Quantite");
                           String price_cmd= rs.getString("total");
                           

 

                           //Display values
                           System.out.print("\n"+"id commande: " + id_commande);
                           System.out.print(", id book: " + id);
                           System.out.print(", price book: " +price);
                           System.out.print(", quantity: " + Quantite);
                           System.out.print(", total price: " + price_cmd);
               }
                    
                
            break;}
			 case 12:
			  {
				  totalPrice();
				}
            case 13: 
            	DataBaseConnexion con;
                 PreparedStatement pstmt;
                 con = new DataBaseConnexion();
                 try {
                 pstmt = con.MyConnection().prepareStatement("TRUNCATE TABLE Commande ");

 

                
                 pstmt.executeUpdate();
                 
                 }
                 catch(SQLException e)
                 {e.printStackTrace();
                 break;}
                 
			}
			
			
			while(choix!=14);
		    
	System.out.println("a bientot");
            
			
			
			
			}
			}
			
	
	
 

	
		 

	    