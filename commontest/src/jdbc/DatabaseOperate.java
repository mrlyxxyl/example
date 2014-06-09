package jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseOperate {
	Connection connection;
	Statement statement;
	ResultSet rs;
	String user = "root";
	String passwd = "lyx5858112";
	public DatabaseOperate() {
		try {
			Class.forName("com.jdbc.mysql.Driver");
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:8888/test", user, passwd);
			statement = connection.createStatement();
			String sql = "create database if not exists spider";
			statement.execute(sql);
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:8888/spider", user, passwd);
			statement = connection.createStatement();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 以网站名创建表
	 * 
	 * @param tableName
	 *            ：表名（网站title）
	 */
	public void createTable(String tableName) {
		String createTableSql = "create table if not exists "
				+ tableName
				+ " (posturl varchar(150)  CHARACTER SET gb2312 COLLATE gb2312_chinese_ci primary key,posttitle varchar(80) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci,executetime date)";
		try {
			statement.execute(createTableSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询数据库
	 * 
	 * @param searchSql
	 *            ：查询的sql语句
	 * @return：返回结果集
	 */
	public ResultSet searchPost(String searchSql) {
		ResultSet resultSet = null;
		try {
			resultSet = statement.executeQuery(searchSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultSet;
	}

	/**
	 * 对查询结果进行分页处理
	 * 
	 * @param searcySql
	 *            ：查询sql语句
	 * @return：返回页数
	 */
	public int getSearchPageNums(String searcySql) {
		int pageNum = 0;
		try {
			int postNum = 0;
			rs = statement.executeQuery(searcySql);
			rs.last();
			postNum = rs.getRow();
			pageNum = postNum / 10 + (postNum % 10 == 0 ? 0 : 1);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageNum;
	}

	/**
	 * 对查询结果进行分页处理
	 * 
	 * @param searcySql
	 *            ：查询sql语句
	 * @return：返回页数
	 */
	public int getPostNums(String searcySql) {
		int postNum = 0;
		try {
			rs = statement.executeQuery(searcySql);
			rs.last();
			postNum = rs.getRow();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return postNum;
	}

	/**
	 * 删除帖子信息
	 * 
	 * @param deleteSql
	 *            ：删除sql语句
	 */
	public void deletePost(String deleteSql) {
		try {
			statement.execute(deleteSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 插入数据
	 * 
	 * @param sql
	 *            ：插入sql语句
	 */
	public void insert(String sql) {
		try {
			statement.execute(sql);
		} catch (SQLException e) {
		}
	}

	/**
	 * 获取数据库中的所有的表
	 * 
	 * @return
	 */
	public ArrayList<String> getAllTables() {
		DatabaseMetaData databaseMetaData;
		ArrayList<String> tableList = new ArrayList<String>();
		try {
			databaseMetaData = connection.getMetaData();
			String[] tableType = { "TABLE" };
			rs = databaseMetaData.getTables(null, null, "%", tableType);
			while (rs.next()) {
				tableList.add(rs.getString(3));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tableList;
	}
}
