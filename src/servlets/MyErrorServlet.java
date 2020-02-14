package servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyError")
public class MyErrorServlet extends HttpServlet {
	
	// Set global variable of type string to hold custom error message
	private String sendErrorMessage;
		
		public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
			// Assign error message to String error variable
			sendErrorMessage = "Looks like you stumbled on an Error!";
			
			// Call method to send custom error message
			sendErrorReport(response, sendErrorMessage);

		}
		
		// Method that makes it doGet even if it is doPost
		public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);		
		}
		
		// Method to send custom error repost
		private void sendErrorReport(HttpServletResponse response,
				String message)
				throws IOException {
				response.sendError(HttpServletResponse.SC_NOT_FOUND, message);
				}
}
