package common;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.sql.SQLException;



public class DButill {

	public static Connection getConnection() throws SQLException {

		try {

			Class.forName("com.mysql.cj.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

		String url = "jdbc:mysql://ykdb.ceqzgagqvncl.ap-northeast-2.rds.amazonaws.com/bank";

		String user = "sku@skuniv.ac.kr";

		String pass =  "1q2w3e4r!";

		Connection conn = DriverManager.getConnection(url,user,pass);

		return conn;

	}

	

	public static void close(Connection con, PreparedStatement ps) {

		if(con != null) {

			try {

				con.close();

			} catch(SQLException e){

				e.printStackTrace();

			}

		}

		if(ps != null) {

			try {

				ps.close();

			} catch(SQLException e){

				e.printStackTrace();

			}

		}

	}

	

	public static void close(Connection con, PreparedStatement ps,ResultSet rs) {

		if(rs != null) {

			try {

				rs.close();

			} catch(SQLException e){

				e.printStackTrace();

			}

		}

		close(con,ps);

	}

	



}