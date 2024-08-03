package labTshirt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/tdetails")
public class tdetails extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	public tdetails() 
	{
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException 
	{
		//Sets the content type of response
		response.setContentType("text/html");
		//returns the object of PrintWriter Class,in which print(String args) method is declared to print any thing on the browser's page as a response.
		PrintWriter out=response.getWriter();
		String[] Accessories={};
		//every serve let retrieves its parameters the same way, using getParameter() and getParameterValues() 
		//getParameterValues() : Call this method if the parameter appears more than once and returns multiple values, for example checkbox.
		//access -check box; tag line-text box; pocket-check box; t shirt color-drop down menu
		Accessories=request.getParameterValues("access");
		System.out.println("Accessories-lelo");
		String tshirtAccessories="";
		String tshirtTagLine=request.getParameter("tagline");
		String tshirtOption=request.getParameter("pocket");
		System.out.println(tshirtOption);
		String tcolor=request.getParameter("Tshirtcolor");
		out.println("<html>");
		out.println("<head><title>T-shirt</title></head>");
		out.println("<body>");
		Connection conn = null;
		try
		{
			Statement stmt;
			//Loading JDBC Driver
			Class.forName("com.mysql.jdbc.Driver");
			//Database Connection
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/tshirt","suraj","Sur_12345");
			
			if (conn != null) 
			{
				stmt= conn.createStatement();
				String qu;
				if(tshirtAccessories!=null && tshirtTagLine!=null && tshirtOption!=null && tcolor!=null)
				{
					for(String option:Accessories)
					{
						tshirtAccessories=tshirtAccessories+option;
					}
					//Insert statement
					qu = "INSERT INTO tee (tshirtTagLine, tshirtAccessories, tcolor, tshirtOption) VALUES ('" + tshirtTagLine + "','" + tshirtAccessories + "','" + tcolor + "','" + tshirtOption + "');";
                    stmt.executeUpdate(qu);				}
				//Select statement
				qu="select * from tee;";
				//Returns one ResultSet object.Used when select statement is used.
				ResultSet rs =stmt.executeQuery(qu);
				//out.println writes the html text to container's response object
				out.println("<table border=2>");
				out.println("<tr>");
				out.print("<td>OrderNo</td>");
				out.print("<td>T-shirt Accessories</td>");
				out.print("<td>T-shirt tag-line</td>");
				out.print("<td>T-shirt type</td>");
				out.print("<td>T-shirt color</td>");
				out.println("</tr>");
				//The isBeforeFirst() - determine whether the cursor is at the default position of the ResultSet.
				//Default position is before first row
				if(!rs.isBeforeFirst())
				{
					out.print("<tr>");
					out.print("<td>100</td>");
					out.print("<td>NULL</td>");
					out.print("<td>NULL</td>");
					out.print("<td>NULL</td>");
					out.print("<td>NULL</td>");
					out.print("<td>NULL</td>");
					out.println("</tr>");
				}
				//The next() method - moves the pointer of the current (ResultSet) object to the next row, from the current position.
				while(rs.next())
				{
					out.println("<tr>");
					out.print("<td>"+((rs.getInt("OrderNo"))+1)+"</td>");
					out.print("<td>"+rs.getString("tshirtAccessories")+"</td>");
					out.print("<td>"+rs.getString("tshirtTagLine")+"</td>");
					out.print("<td>"+rs.getString("tcolor")+"</td>");
					out.print("<td>"+rs.getString("tshirtOption")+"</td>");
					out.println("</tr>");
				}
				out.println("</table>");
				//Again,we are trying to move to the jsp page
				out.println("<a href=\"tshirt.jsp\">click here</a>");
				out.println("</body></html>");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
}
}