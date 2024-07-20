package javapackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCConnectivity {

	public static void main(String[] args) throws Exception {
		try {

			//1. create a connection
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbcdemo","root","Aaravaadhvik1729");

			//2. create a statement/query
			Statement stmt=con.createStatement();
			String s="INSERT INTO empdata values(101,'Jenny',25,10000),"
					+ "(102, 'Jacky',30,20000),"
					+ "(103, 'Joe',20,40000),"
					+ "(104, 'John',40,80000),"
					+ "(105, 'Shameer',25,90000)";
			System.out.println("Successfully inserted into table empdata");

			//3. Execute the statement/query
			String strSelect = "select * from empdata";
			ResultSet rs = stmt.executeQuery(strSelect);
			while(rs.next()) {   
				// Move the cursor to the next row
				System.out.println(rs.getInt("empcode") + ", "
						+ rs.getString("empname") + ", "
						+ rs.getString("empage") + ", "
						+ rs.getDouble("esalary"));
			}

			//4. close the connection
			con.close();
			System.out.println("Query executed successfully");
		}
		catch(SQLException e){
			e.printStackTrace();
			System.out.println("Query executed successfully");
		}
	}

}
/* OUTPUT
	Successfully inserted into table empdata
	101, Jenny, 25, 10000.0
	102, Jacky, 30, 20000.0
	103, Joe, 20, 40000.0
	104, John, 40, 80000.0
	105, Shameer, 25, 90000.0
	Query executed successfully
 */




