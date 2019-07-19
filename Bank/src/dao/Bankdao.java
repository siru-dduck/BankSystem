package dao;

import java.sql.Connection;

import java.sql.PreparedStatement;

import java.sql.ResultSet;

import java.util.ArrayList;



import common.DButill;

import dto.Accountdto;

import dto.Customerdto;



public class Bankdao {

	

	//Customer 테이블에 삽입 성공시 true 반환 그렇지 않은 경우 false 반환

	public boolean createCustomer(Customerdto customer) { 

		Connection conn = null;

		PreparedStatement pstmt = null;

		String sql = "INSERT INTO customer VALUES(?,?,?,?,?)";

		boolean result = false;

		try {

			conn = DButill.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, customer.getName());

			pstmt.setString(2, customer.getPinnumber());

			pstmt.setString(3, customer.getAddress());

			pstmt.setString(4, customer.getBankid());

			pstmt.setString(5, customer.getBankpassword());

			if(pstmt.executeUpdate()==1) {

				result = true;

			}

		}catch (Exception e) {

			e.printStackTrace();

		}finally {

			DButill.close(conn, pstmt);

		}

		return result;

	}

	

	//읽기 성공시 Customerdto 객체 반환, 읽기 실패시 null 반환

	public Customerdto readCustomer(String bankid) {

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String sql = "SELECT * FROM customer WHERE bankid=?";

		Customerdto result = null;

		

		try {

			conn = DButill.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, bankid);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				result = new Customerdto();

				result.setName(rs.getString("name"));

				result.setAddress(rs.getString("address"));

				result.setBankid(rs.getString("bankid"));

				result.setBankpassword(rs.getString("bankpassword"));

				result.setPinnumber(rs.getString("pinnumber"));

			}

		}catch (Exception e) {

			e.printStackTrace();

		}finally {

			DButill.close(conn, pstmt);

		}

		return result;

	}

	

	//Account 테이블에 삽입 성공시 true 반환 그렇지 않은 경우 false 반환

	public boolean createAccount(Accountdto account) { 

		Connection conn = null;

		PreparedStatement pstmt = null;

		String sql = "INSERT INTO account VALUES(?,?,?,?)";

		boolean result = false;

		try {

			conn = DButill.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, account.getAccountnumber());

			pstmt.setString(2, account.getAccountpassword());

			pstmt.setInt(3, account.getBalance());

			pstmt.setString(4, account.getOwnerpinnumber());

			if(pstmt.executeUpdate()==1) {

				result = true;

			}

		}catch (Exception e) {

			e.printStackTrace();

		}finally {

			DButill.close(conn, pstmt);

		}

		return result;

	}

	

	//읽기 성공시 Accountdto 객체 반환, 읽기 실패시 null 반환

	public ArrayList<Accountdto> readAccountByOwnerPinnumber(String ownerpinnumber) {

		Connection conn = null;

		PreparedStatement pstmt = null;

		ResultSet rs = null;

		String sql = "select * from account where ownerpinnumber=? ";

		Accountdto dto = null;

		ArrayList<Accountdto> result = new ArrayList<>();

		try {

			conn = DButill.getConnection();

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, ownerpinnumber);

			rs = pstmt.executeQuery();

			if(rs.next()) {

				dto = new Accountdto();

			

				dto.setAccountnumber(rs.getString("accountnumber"));

				dto.setAccountpassword(rs.getString("accountpassword"));

				dto.setBalance(rs.getInt("balance"));

				dto.setOwnerpinnumber(rs.getString("ownerpinnumber"));

				result.add(dto);

			}

		}catch (Exception e) {

			e.printStackTrace();

		}finally {

			DButill.close(conn, pstmt);

		}

		return result;

	}
	public String getpinnumber(String bankid) {
		String pinnumber=null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		try {
			sql = "select pinnumber from customer where bankid=?";
			conn=DButill.getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bankid);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				pinnumber = rs.getString("pinnumber");
			}
			
		}
		catch(Exception e) {}
		finally {DButill.close(conn, pstmt);}
		return pinnumber;
	}
	
	public boolean sendmoney(String sendaccount,String receiveaccount,int money) {
		String sql;
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		try {
			conn = DButill.getConnection();
			sql = "update account set balance = balance-? where accountnumber=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, sendaccount);
			pstmt.executeUpdate();
			
			sql = "update account set balance = balance+? where accountnumber=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, money);
			pstmt.setString(2, receiveaccount);
			pstmt.executeUpdate();
		
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		finally {DButill.close(conn, pstmt);}
		return true;
	}
	public void inserttransaction(String sendaccount,String reciveaccount,String time) {
		String sql = "insert into transaction values(?,?,?,?)";
	}

	

	

}