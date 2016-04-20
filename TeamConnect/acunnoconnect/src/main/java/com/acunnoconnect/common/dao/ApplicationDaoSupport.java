package com.acunnoconnect.common.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class ApplicationDaoSupport {

	public DataSource getDataSource() {
		return dataSource;
	}



	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Autowired
	public DataSource dataSource;

	/**
	 * Gets the connection.
	 * 
	 * @return the connection
	 * 
	 * @throws SQLException
	 *             the SQL exception
	 */
	public Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}



	/**
	 * Close connection.
	 * 
	 * @param con
	 *            the con
	 * 
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void closeConnection(Connection con) throws SQLException {
		if (con != null)
			con.close();
	}

	/**
	 * Close result set.
	 * 
	 * @param resultSet
	 *            the result set
	 * 
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void closeResultSet(ResultSet resultSet) throws SQLException {
		if (resultSet != null)
			resultSet.close();
	}

	/**
	 * Close callable statement.
	 * 
	 * @param callableStatement
	 *            the callable statement
	 * 
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void closeCallableStatement(CallableStatement callableStatement)
			throws SQLException {
		if (callableStatement != null)
			callableStatement.close();
	}

	/**
	 * Close callable statement.
	 * 
	 * @param callableStatement
	 *            the callable statement
	 * 
	 * @throws SQLException
	 *             the SQL exception
	 */
	public void closeStatement(Statement statement) throws SQLException {
		if (statement != null)
			statement.close();
	}
}
