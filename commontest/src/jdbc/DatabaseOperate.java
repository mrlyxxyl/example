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
	 * ����վ��������
	 * 
	 * @param tableName
	 *            ����������վtitle��
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
	 * ��ѯ���ݿ�
	 * 
	 * @param searchSql
	 *            ����ѯ��sql���
	 * @return�����ؽ����
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
	 * �Բ�ѯ������з�ҳ����
	 * 
	 * @param searcySql
	 *            ����ѯsql���
	 * @return������ҳ��
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
	 * �Բ�ѯ������з�ҳ����
	 * 
	 * @param searcySql
	 *            ����ѯsql���
	 * @return������ҳ��
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
	 * ɾ��������Ϣ
	 * 
	 * @param deleteSql
	 *            ��ɾ��sql���
	 */
	public void deletePost(String deleteSql) {
		try {
			statement.execute(deleteSql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ��������
	 * 
	 * @param sql
	 *            ������sql���
	 */
	public void insert(String sql) {
		try {
			statement.execute(sql);
		} catch (SQLException e) {
		}
	}

	/**
	 * ��ȡ���ݿ��е����еı�
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
