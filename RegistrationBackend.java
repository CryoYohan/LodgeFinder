package trashcash;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class RegistrationBackend {
	int ln;
	String UsernameMain = "";
	String Username, Password, Email, Firstname, Lastname, Age, Phonenumber;
	File f = new File("C:\\Users\\CYRIL\\OneDrive\\Desktop\\School Files\\OOPROG21\\LodgeHub\\Accounts");
	// REGISTER THE USER'S CREDENTIALS
    // If folder doesn't exist, create new folder
    void createFolder() {
    	if(!f.exists()) {
    		f.mkdirs();
    	}
    }
    // Checks if file exist, if not create file
    void readFile() {
    	try {
			FileReader fr = new FileReader(f+"\\accounts.txt");
			System.out .println("file exists!");
		} catch (FileNotFoundException ex) {
			try {
				FileWriter fw = new FileWriter(f+"\\accounts.txt");
				System.out.println("File created!");
			} catch (IOException ex1) {
				Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE,null, ex1);
			}
			
		}
    }
    // Add data to Text file, user, pass and email
    void addData(String usr, String pswd, String mail, String fname, String lname, String phonenumber,String age) {
    	try {
			RandomAccessFile raf = new RandomAccessFile(f+"\\accounts.txt", "rw");
			for(int i = 0; i < ln; i++) {
				raf.readLine(); 
			}
			raf.writeBytes("Username:" + usr + "\r\n");
			raf.writeBytes("Password:" + pswd + "\r\n");
			raf.writeBytes("Email:" + mail + "\r\n");
			raf.writeBytes("Fname:" + fname + "\r\n");
			raf.writeBytes("Lname:" + lname +  "\r\n");
			raf.writeBytes("Age:" + age +  "\r\n");
			raf.writeBytes("Phonenum:" + phonenumber);
			raf.writeBytes("\r\n");
			raf.writeBytes("\r\n");
		} catch (FileNotFoundException ex) {
			Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE,null, ex);
		} catch (IOException ex) {
			Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE,null, ex);
		}
    }
    // Count lines, i think lines is every user's info like line 1 composed of user 1's user pass and email
    void countLines() {   	
    	try {
    		ln = 1;
			RandomAccessFile raf = new RandomAccessFile(f+"\\accounts.txt", "rw");
			for(int i = 0;raf.readLine()!=null;i++) {
				ln++;
			}
			System.out.println("number of lines: " + ln);
		} catch (FileNotFoundException ex) {
			System.out.println("1");
			Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE,null, ex);
		} catch (IOException ex) {
			System.out.println("2");
			Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE,null, ex);
		}
    }
    // This checks the data inputted in the login user and pass if it matches or not, dire ang naay error

    void logic(String usr, String pswd) {
    	try {
			RandomAccessFile raf = new RandomAccessFile(f + "\\accounts.txt", "rw");
			for(int i = 0; i < ln; i+=8) {
				System.out.println("count " + i);
				String lineForUser = raf.readLine();
		        String lineForPass = raf.readLine();
		        String lineForEmail = raf.readLine();
		        String lineForFname = raf.readLine();
		        String lineForLname = raf.readLine();
		        String lineForAge = raf.readLine();
		        String lineForPhonenumber = raf.readLine();
		       

		        // Check if either line is null (end of file)
		        if (lineForUser == null || lineForPass == null || lineForEmail == null || lineForFname == null) {
		            JOptionPane.showMessageDialog(null, "Invalid User/Password");		           
		          }
		        // Check if the line has enough characters before extracting substrings
	            if (lineForUser.length() >= 9 && lineForPass.length() >= 9 && lineForEmail.length()>=6 && lineForFname.length()>=7 && lineForLname.length()>=7 &&  lineForAge.length()>=4 && lineForPhonenumber.length()>=9 ) {
	                String forUser = lineForUser.substring(9);
	                String forPass = lineForPass.substring(9);
	                String forEmail = lineForEmail.substring(6);
	                String forFname = lineForFname.substring(6);
	                String forLname = lineForLname.substring(6);
	                String forAge = lineForAge.substring(4);
	                String forPhonenumber = lineForPhonenumber.substring(9);

	                if (usr.equals(forUser) && pswd.equals(forPass)) {
	                    JOptionPane.showMessageDialog(null, "Login Successful!");
	                    new LodgeHubHome(forFname, forLname, forAge, forPhonenumber, forEmail);
	                    break;
	                }
	            } else 
	                JOptionPane.showMessageDialog(null, "Invalid User/Password");

				raf.readLine();
				
				
			}
		} catch (FileNotFoundException ex) {
			Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE,null, ex);
		} catch (IOException ex) {
			Logger.getLogger(RegistrationForm.class.getName()).log(Level.SEVERE,null, ex);
		}
    	
    }
    
    void checkData(String usr, String pswd) {

    	try {
			RandomAccessFile raf = new RandomAccessFile(f+"\\accounts.txt","rw");
			String line = raf.readLine();
			Username = line.substring(9);
			Password = raf.readLine().substring(9);
			Email = raf.readLine().substring(6);
			if(usr.equals(Username) & pswd.equals(Password)) {
				JOptionPane.showMessageDialog(null, "Login Successful!");
				//new LodgeHubHome();
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid User/Password");
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
}
