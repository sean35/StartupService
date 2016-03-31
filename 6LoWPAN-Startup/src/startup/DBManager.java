package startup;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

/**
 * @author Engin Leloglu - 2016
 * 
 * DBManager provides the control of database parameters and operations.
 *
 */
public class DBManager {

	private static DBManager instance = null;	// Singleton object
	private Connection conn = null;

	public void connectToDB() {

		try {
			Class.forName("com.mysql.jdbc.Connection");
			conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int insertIntoDB(String defaultId){

		connectToDB();
		
		int generatedId = -1;
		String query = "insert into devicestartup(DEFAULT_ID) values('" + defaultId + "');";
		Statement stm = null;

		try {
			stm = (Statement) conn.createStatement();
			int isSucc = stm.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

			if (isSucc == 1) {
				ResultSet rs = stm.getGeneratedKeys();
				if (rs.next())
					generatedId = rs.getInt(1);
				rs.close();
			}
			stm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println("generatedId -> " + generatedId);
		return generatedId;
	}
	
	public static DBManager getInstance() {
		// Singleton pattern.
		if (instance == null) {
			instance = new DBManager();
		}
		return instance;
	}

}
