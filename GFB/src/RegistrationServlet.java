

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        PrintWriter out = response.getWriter();
        
        // Setup the database parameters
        String JDBCUrl = "jdbc:mysql://localhost:3306/gfb_database";
        String username = "root";
        String password = ""; //insert your root password between "" 

        try {
            System.out.println("\nConnecting to the SSD Database......");
            /*connexion to the database gfb_database with the username and the password defined above*/
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(JDBCUrl, username, password); 
        }
        catch (Exception e) {
        	/* message displayed if the program failed to connect to the database*/
            System.out.println("\nAn error has occurred during the connection phase!  This is most likely due to your CLASSPATH being set wrong and the"
                    + "  classes unable to be found.  Otherwise the database itself may be down.  Try telneting to port 3306 and see if it is up!");
            e.printStackTrace();
            System.exit(0);
        }   
        
        /*save the html form data in variables*/
        //String spassword = "*";
        //String ID = request.getParameter("ID");
        String ID = null;
        String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String mail = request.getParameter("mail");
        String dateBirth = request.getParameter("dateBirth");
        String phone = request.getParameter("phone");
        String houseNum = request.getParameter("houseNum");
        String streetName = request.getParameter("streetName");
        String address1 = request.getParameter("address1");
        String address2 = request.getParameter("address2");
        String address3 = request.getParameter("address3");
        String addInfo = request.getParameter("addInfo");
        String nationality = request.getParameter("nationality");
        String cityBirth = request.getParameter("cityBirth");
        String countryBirth = request.getParameter("countryBirth");
        String gender = request.getParameter("gender");
        String employmentStatus = request.getParameter("employmentStatus");
        String spassword = request.getParameter("password");
        double balance =  0.0;
        int status = 2;
        //String status = request.getParameter("status");
        
	     if  (phone == null && address1 == null && nationality == null && spassword == null) {
	    	 try {/*CREATION DATABASE*/
				 /* insert variables set above in the database*/
				  PreparedStatement pstmt = con.prepareStatement("INSERT INTO gfb_database.customer(ID,lname,mail,dateBirth,phone,address,addInfo,nationality,cityBirth,countryBirth,gender,employmentStatus,password,balance,status) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
						  pstmt.clearParameters();       // Clears any previous parameters
						  pstmt.setString(1, ID);
						  pstmt.setString(2, fname + " " + lname);
						  pstmt.setString(3, mail);
						  pstmt.setString(4, dateBirth);
						  pstmt.setString(5, phone);
						  pstmt.setString(6, address1);
						  pstmt.setString(7, addInfo);
						  pstmt.setString(8, nationality);
						  pstmt.setString(9, cityBirth);
						  pstmt.setString(10, countryBirth);
						  pstmt.setString(11, gender);
						  pstmt.setString(12, employmentStatus);
						  pstmt.setString(13, spassword);
						  pstmt.setDouble(14, balance);
						  pstmt.setInt(15, status);
						  pstmt.executeUpdate();
						  
						  /*HTTP session*/
						  HttpSession session=request.getSession();
						  session.setAttribute("mail",mail);
							
						  System.out.println("successfully updated");
						  response.sendRedirect("/GFB/mobilePhoneNumber.jsp");
		
	    	 }
	    	 catch (SQLException e) {
	    		 /*message displayed if an error has occurred during the Statement/ResultSet phase*/
	    		 System.out.println("\nAn error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
	    		 while (e != null) {
	    			 System.out.println(e.getMessage());
	    			 e = e.getNextException();
			     }
	    		 System.exit(0);
	    	 }
		     
		
	    	 finally {
	    		 try {    
			         if (rs != null) rs.close();
			         if (stmt != null) stmt.close();
			         if (con != null) con.close();
			     }
			     catch (Exception ex) {
			         System.out.println("An error occurred while closing down connection/statement"); 
		         }
	    	 }
	     }else if (address1 == null && nationality == null && spassword == null) { 
	    	 /*update the data in the data base with the data from the form on page mobilePhoneNumber.jsp*/
	    	 try {
	    		HttpSession session=request.getSession(false);
	 			mail=(String)session.getAttribute("mail");
	 			System.out.print("mail:" + mail);
	    		
	 			PreparedStatement pstmt = con.prepareStatement("update gfb_database.customer set phone=? where mail=?");
	    		pstmt.setString(1, phone);
				pstmt.setString(2, mail);
				pstmt.executeUpdate();
				
				System.out.println("Database updated successfully ");
				response.sendRedirect("/GFB/homeAddress.jsp");
				
	    	 } catch (SQLException e) {
	    		 /*message displayed if an error has occurred during the Statement/ResultSet phase*/
	    		 System.out.println("\nAn error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
	    		 while (e != null) {
	    			 System.out.println(e.getMessage());
	    			 e = e.getNextException();
			     }
	    		 System.exit(0);
	    	 }
		     
		
	    	 finally {
	    		 try {    
			         if (rs != null) rs.close();
			         if (stmt != null) stmt.close();
			         if (con != null) con.close();
			     }
			     catch (Exception ex) {
			         System.out.println("An error occurred while closing down connection/statement"); 
		         }
	    	 }
	     }else if (nationality == null && spassword == null) {
	    	 /*update the data in the data base with the data from the form on page homeAddress.jsp*/
	    	 try {
	    		HttpSession session=request.getSession(false);
	 			mail=(String)session.getAttribute("mail");
	 			System.out.print("mail:" + mail);
	    		
	 			PreparedStatement pstmt = con.prepareStatement("update gfb_database.customer set address=? where mail=?");
	    		pstmt.setString(1, houseNum +" "+ streetName + " " + address1 + " " + address2 + " " + address3);
				pstmt.setString(2, mail);
				pstmt.executeUpdate();
				
				pstmt = con.prepareStatement("update gfb_database.customer set addInfo=? where mail=?");
	    		pstmt.setString(1, addInfo);
				pstmt.setString(2, mail);
				pstmt.executeUpdate();
				
				System.out.println("Database updated successfully ");
				response.sendRedirect("/GFB/additionalInformation.jsp");
				
	    	 } catch (SQLException e) {
	    		 /*message displayed if an error has occurred during the Statement/ResultSet phase*/
	    		 System.out.println("\nAn error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
	    		 while (e != null) {
	    			 System.out.println(e.getMessage());
	    			 e = e.getNextException();
			     }
	    		 System.exit(0);
	    	 }
		     
		
	    	 finally {
	    		 try {    
			         if (rs != null) rs.close();
			         if (stmt != null) stmt.close();
			         if (con != null) con.close();
			     }
			     catch (Exception ex) {
			         System.out.println("An error occurred while closing down connection/statement"); 
		         }
	    	 }
	     }else if (spassword == null) {
	    	 /*update the data in the data base with the data from the form on page additionalInformation.jsp*/
	    	 try {
	    		HttpSession session=request.getSession(false);
	 			mail=(String)session.getAttribute("mail");
	 			System.out.print("mail:" + mail);
	    		
	 			PreparedStatement pstmt = con.prepareStatement("update gfb_database.customer set nationality=? where mail=?");
	    		pstmt.setString(1, nationality);
				pstmt.setString(2, mail);
				pstmt.executeUpdate();
				 
				pstmt = con.prepareStatement("update gfb_database.customer set cityBirth=? where mail=?");
	    		pstmt.setString(1, cityBirth);
				pstmt.setString(2, mail);
				pstmt.executeUpdate();
				 
				pstmt = con.prepareStatement("update gfb_database.customer set countryBirth=? where mail=?");
	    		pstmt.setString(1, countryBirth);
				pstmt.setString(2, mail);
				pstmt.executeUpdate();
				 
				pstmt = con.prepareStatement("update gfb_database.customer set gender=? where mail=?");
	    		pstmt.setString(1, gender);
				pstmt.setString(2, mail);
				pstmt.executeUpdate();
				 
				pstmt = con.prepareStatement("update gfb_database.customer set employmentStatus=? where mail=?");
	    		pstmt.setString(1, employmentStatus);
				pstmt.setString(2, mail);
				pstmt.executeUpdate();
				
				System.out.println("Database updated successfully ");
				response.sendRedirect("/GFB/createPassword.jsp");
				
	    	 } catch (SQLException e) {
	    		 /*message displayed if an error has occurred during the Statement/ResultSet phase*/
	    		 System.out.println("\nAn error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
	    		 while (e != null) {
	    			 System.out.println(e.getMessage());
	    			 e = e.getNextException();
			     }
	    		 System.exit(0);
	    	 }
		     
		
	    	 finally {
	    		 try {    
			         if (rs != null) rs.close();
			         if (stmt != null) stmt.close();
			         if (con != null) con.close();
			     }
			     catch (Exception ex) {
			         System.out.println("An error occurred while closing down connection/statement"); 
		         }
	    	 }
	     }else {
	    	 /*update the data in the data base with the data from the form on page createPassword.jsp*/
	    	 try {
	    		HttpSession session=request.getSession(false);
	 			mail=(String)session.getAttribute("mail");
	 			System.out.print("mail:" + mail);
	    		
	 			PreparedStatement pstmt = con.prepareStatement("update gfb_database.customer set password=? where mail=?");
	    		pstmt.setString(1, spassword);
				pstmt.setString(2, mail);
				pstmt.executeUpdate();
	 			
				System.out.println("Database updated successfully ");
				response.sendRedirect("/GFB/createAccount.jsp");
				
	    	 } catch (SQLException e) {
	    		 /*message displayed if an error has occurred during the Statement/ResultSet phase*/
	    		 System.out.println("\nAn error has occurred during the Statement/ResultSet phase.  Please check the syntax and study the Exception details!");
	    		 while (e != null) {
	    			 System.out.println(e.getMessage());
	    			 e = e.getNextException();
			     }
	    		 System.exit(0);
	    	 }
		     
		
	    	 finally {
	    		 try {    
			         if (rs != null) rs.close();
			         if (stmt != null) stmt.close();
			         if (con != null) con.close();
			     }
			     catch (Exception ex) {
			         System.out.println("An error occurred while closing down connection/statement"); 
		         }
	    	 }
	     }  
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	

}
