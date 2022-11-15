package classes;

import java.io.*;
import java.util.Scanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

// https://www.javatpoint.com/how-to-read-csv-file-in-java
// https://docs.oracle.com/javase/7/docs/api/java/lang/Exception.html
// https://docs.oracle.com/javase/7/docs/api/java/io/File.html
// https://docs.oracle.com/javase/7/docs/api/java/util/Scanner.html
// https://docs.oracle.com/javase/7/docs/api/java/lang/String.html
// https://www.w3schools.com/sql/sql_insert.asp
// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-connect-drivermanager.html
// https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-usagenotes-statements.html
// https://docs.oracle.com/javase/7/docs/api/java/sql/Statement.html
// https://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
// https://www.javatpoint.com/java-string-format
// https://docs.oracle.com/javase/7/docs/api/allclasses-noframe.html
// https://dev.mysql.com/doc/refman/5.7/en/json.html

public class Main {
	public static void insertRegister() {
		Connection conn = null;
		Statement stmt = null;

		try {
			final String dir = System.getProperty("user.dir");
			String pathCSVFile = dir + "/src/bohemian_literature.csv";

			File file = new File(pathCSVFile);
			Scanner sc = new Scanner(file);

			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?" + "user=root&password=root");
			stmt = conn.createStatement();

			String line;
			String[] values;
			String value;
			String sql;
			while (sc.hasNextLine()) {
				line = sc.nextLine();
				System.out.println(line);
				values = line.split(",");
				for (int i = 0; i < values.length; i++) {
					value = values[i];
					// System.out.println( "\t".concat(value) );
					value = values[i].substring(1, value.length() - 1);
					System.out.println("\t".concat(value));
				}
				sql = "INSERT INTO book(idbook, author, title) VALUES("
						.concat("" + values[0].substring(1, values[0].length() - 1) + ", ")
						.concat("'" + values[1].substring(1, values[1].length() - 1) + "', ")
						.concat("'" + values[2].substring(1, values[2].length() - 1) + "');");
				System.out.println("\t".concat(sql));

				if (stmt.execute(sql)) {
					System.out.println("\tRegister don't inserted. Fealure with process.");
				} else {
					System.out.println("\tRegister inserted with success.");
				}
			}
			System.out.println("");
			sc.close();
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void selectRegister(int id) {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/library?" + "user=root&password=");
			// stmt = conn.createStatement();
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

			String sql = "SELECT idbook, title, author FROM book WHERE idbook=".concat(Integer.toString(id));
			rs = stmt.executeQuery(sql);

			rs.last();
			int numberRegisters = rs.getRow();
			rs.beforeFirst();

			if (numberRegisters > 0) {
				while (rs.next()) {
					System.out.println("    id book: ".concat(rs.getObject("idbook").toString()));
					System.out.println("author book: ".concat(rs.getObject("author").toString()));
					System.out.println(" title book: ".concat(rs.getObject("title").toString()));
					System.out.println("");
				}
				System.out.println("");
			} else {
				System.out.println(String.format("- Without results for id %d -", id));
			}
		} catch (SQLException e) {
			System.out.println("SQLException: " + e.getMessage());
			System.out.println("SQLState: " + e.getSQLState());
			System.out.println("VendorError: " + e.getErrorCode());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		// Main.insertRegister();
		Main.selectRegister(10);
	}

}
