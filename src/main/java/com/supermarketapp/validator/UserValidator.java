package com.supermarketapp.validator;

import java.util.regex.Pattern;


import com.supermarketapp.exception.ValidationException;
import com.supermarketapp.model.User;


public class UserValidator {

public static void validateUserDetails(User user) throws ValidationException {
	ValidUsername(user.getName());
	validateEmail(user.getEmail());
	validatePassword(user.getPassword());
	validateMobileNumber(user.getMobileNumber());
}
		public static String ValidUsername(String name) throws ValidationException
		{   
		    
		    
		    // If the username is empty
			// return false
		    if (name == null||name.trim() == "") {
				throw new ValidationException("Please enter your name");
			}

			// Regex to check valid username.
			String regex = "^[A-Za-z]\\w{4,29}$";

			// Compile the ReGex
			Pattern pattern = Pattern.compile(regex);

			
			

			// Pattern class contains matcher() method
			// to find matching between given username
			// and regular expression.
			if(pattern.matcher(name).matches()){
			    return "valid";
			}

			else{
			   throw new ValidationException("Name should contains atleast 5 characters");
			   
			}
		}
		
		
		public static String validateEmail(String email) throws ValidationException{

	        if (email == null || email.isEmpty()){
	         throw new ValidationException ("Enter a valid email");
	          }
	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
	                    "[a-zA-Z0-9_+&*-]+)*@"+
	                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
	        Pattern pattern = Pattern.compile(emailRegex);
	            if(pattern.matcher(email).matches()){
	            return "valid";
	      }
	               else{
	            throw new ValidationException ("Enter a valid email");
	            }
	           }

	    public static String validatePassword(String password) throws ValidationException{
	        
	        if (password == null || password.isEmpty()){
	         return "Invalid";
	          }
	        String PATTERN = 
	                       "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
				
				Pattern pattern = Pattern.compile(PATTERN);
				if(pattern.matcher(password).matches())
			  {
				 return "valid";
			  }else{
				  throw new ValidationException("Enter a valid password");
			  }	
	    }


	public static String validateMobileNumber(Long mobileNumber) throws ValidationException{
	        
			String mobileNoStr = mobileNumber != null ? mobileNumber.toString():null;
		
	        if (mobileNoStr ==null|| mobileNoStr.isEmpty()){
	         throw new ValidationException (" Enter a valid mobile Number");
	          }
	          
	    String regex = "(0/91)?[7-9][0-9]{9}";
				
				Pattern pattern = Pattern.compile(regex);
				if(pattern.matcher(mobileNoStr).matches())
			  {
				 return "valid";
			  }else{
				  throw new ValidationException("enter a valid mobile number");
			  }	
	    }
	

		public static void validateLogin(User userLogin) throws ValidationException {
		if (userLogin.getEmail() == null || userLogin.getEmail().trim().equals("")) {
			throw new ValidationException ("Invalid email");
		} else if (!userLogin.getEmail().contains("@")) {
			throw new ValidationException ("Email should contain @");
		}
		if (userLogin.getPassword() == null || userLogin.getPassword().trim().equals("")) {
			throw new ValidationException ("Invalid password");
		} else if (userLogin.getPassword().length() < 8) {
			throw new ValidationException ("Password must be minimum 8 characters");
		}
	}
	
//	public static void validateForgetPassword(User user) throws ValidationException {
//		validateEmail1(user.getEmail());
//		validatePassword1(user.getPassword());
//		
//	}
//		public static String validateEmail1(String email) throws ValidationException{
//
//	        if (email == null || email.isEmpty()){
//	         throw new ValidationException ("Enter a valid email");
//	          }
//	    String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
//	                    "[a-zA-Z0-9_+&*-]+)*@"+
//	                    "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
//	        Pattern pattern = Pattern.compile(emailRegex);
//	            if(pattern.matcher(email).matches()){
//	            return "valid";
//	      }
//	               else{
//	            throw new ValidationException ("Enter a valid email");
//	            }
//	           }
//		 public static String validatePassword1(String password) throws ValidationException{
//		        
//		        if (password == null || password.isEmpty()){
//		         return "Invalid";
//		          }
//		        String PATTERN = 
//		                       "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";
//					
//					Pattern pattern = Pattern.compile(PATTERN);
//					if(pattern.matcher(password).matches())
//				  {
//					 return "valid";
//				  }else{
//					  throw new ValidationException("Enter a valid password");
//				  }	
//		    }
//		
//

}
