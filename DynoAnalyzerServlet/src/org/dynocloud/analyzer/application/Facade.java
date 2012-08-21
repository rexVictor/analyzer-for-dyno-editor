package org.dynocloud.analyzer.application;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.util.Enumerator;
import org.dynocloud.analyzer.domain.ShapeResolver;
import org.dynocloud.analyzer.importer.json.application.Importer;
import org.postgresql.Driver;

/**
 * Servlet implementation class Facade
 */
public class Facade extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private final Map<String, String> idToJson = new HashMap<String, String>();
	
	private final Importer importer = new Importer();
	
	private Connection connection;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Facade() {
        super();
        try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
        try {
			connection = DriverManager.getConnection("jdbc:postgresql:dynoanalyzer", "rex", "postgres");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();				
		String resourceID = request.getParameter("resourceID");
		String json = idToJson.get(resourceID);
		if (json != null){
			idToJson.remove(resourceID);
			ShapeResolver resolver = importer.importJson(json);
			out.print("<html><head></head><body><h5>");
			out.print(resolver);
			out.print("</h5></body></html>");
			
			Statement statement = null;
			try {
				Statement stmtCreate = connection.createStatement();
		//		stmtCreate.execute("CREATE TABLE Customer" + "(alter integer, Vorname char(25), Nachname char(25), Strasse char(25), Ort char(25));");
				//stmtCreate.execute("CREATE TABLE Test" + "(key varchar, value , Nachname char(25), Strasse char(25), Ort char(25));");
				
				statement = connection.createStatement();
				
				statement.executeUpdate( "INSERT INTO CUSTOMER " +
					"VALUES(50,'Christian','Ullenboom','Immengarten 6','Hannover')" );
				 ResultSet rs = statement.executeQuery( "SELECT * FROM Customer" );
			      while ( rs.next() ){
			    	  System.out.print(rs.getString(0));
			        System.out.printf( "%s, %s %s%n", rs.getString(1),
			                           rs.getString(2), rs.getString(3) );
			      }
			      rs.close();

			      statement.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("resourceID");
		String json = request.getParameter("JSON");
		idToJson.put(id, json);
		response.setStatus(HttpServletResponse.SC_OK);
	}

}
