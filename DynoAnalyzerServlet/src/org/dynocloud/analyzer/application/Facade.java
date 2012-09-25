package org.dynocloud.analyzer.application;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
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
import org.dynocloud.analyzer.plugins.AnalyzerEvent;
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
			AnalyzerEvent event = new AnalyzerEvent(resolver);
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			ObjectOutputStream objectStream = new ObjectOutputStream(byteArrayOutputStream);
			objectStream.writeObject(event);
			out.print("<html><head></head><body>");
			
			byte[] array = byteArrayOutputStream.toByteArray();
			out.print("<h4> "+ Arrays.toString(array)+ "</h4>");
			
			InputStream inputStream = new ByteArrayInputStream(array);
			ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
			try {
				AnalyzerEvent imported = (AnalyzerEvent) objectInputStream.readObject();
				out.print("<h3> "+ imported.getShapeResolver().toString() +" </h3>");
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			Statement statement = null;
			try {
				statement = connection.createStatement();
				String graphObjectAsString;
				statement.executeUpdate( "INSERT INTO CUSTOMER " +
					"VALUES(50,'Christian','Ullenboom','Immengarten 6','Hannover')" );
				 ResultSet rs = statement.executeQuery( "SELECT * FROM Customer" );
			      while ( rs.next() ){
			    	  //System.out.print(rs.getString(0));
			        System.out.printf( "%s, %s %s%n", rs.getString(1),
			                           rs.getString(2), rs.getString(3) );
			      }
			      rs.close();

			      statement.close();
			
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print("<h5>");
			out.print(resolver);
			out.print("</h5></body></html>");
			
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
