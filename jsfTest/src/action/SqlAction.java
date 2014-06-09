package action;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@ManagedBean
@ViewScoped
public class SqlAction {

    private Connection connection;
    private Statement statement;
    private String sqlStr;
    static Properties properties;
    static String sDBDriver;
    static String sConnStr;
    static String user;
    static String passwd;

    static {
        properties = new Properties();
        try {
            properties.load(SqlAction.class.getClassLoader().getResourceAsStream("prjcfg.properties"));
            sDBDriver = properties.getProperty("pub.platform.db.ConnectionManager.sDBDriver");
            sConnStr = properties.getProperty("pub.platform.db.ConnectionManager.sConnStr");
            user = properties.getProperty("pub.platform.db.ConnectionManager.user");
            passwd = properties.getProperty("pub.platform.db.ConnectionManager.passwd");
            Class.forName(sDBDriver);
        } catch (IOException e) {
            addMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
        } catch (ClassNotFoundException e) {
            addMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
        }
    }

    public void executeSQL() {
        try {
            connection = DriverManager.getConnection(sConnStr, user, passwd);
            statement = connection.createStatement();
            sqlStr = sqlStr.trim();
            if (sqlStr.endsWith(";")) {
                sqlStr = sqlStr.substring(0, sqlStr.lastIndexOf(";"));
            }
            if (sqlStr.startsWith("update")) {
                statement.executeUpdate(sqlStr);
                addMessage(FacesMessage.SEVERITY_INFO, "update success!");
            } else if (sqlStr.startsWith("alter")) {
                statement.execute(sqlStr);
                addMessage(FacesMessage.SEVERITY_INFO, "alter success!");
            } else if (sqlStr.startsWith("delete")) {
                statement.executeUpdate(sqlStr);
                addMessage(FacesMessage.SEVERITY_INFO, "delete success!");
            } else if (sqlStr.startsWith("create")) {
                statement.execute(sqlStr);
                addMessage(FacesMessage.SEVERITY_INFO, "create success!");
            } else if (sqlStr.startsWith("drop")) {
                statement.execute(sqlStr);
                addMessage(FacesMessage.SEVERITY_INFO, "drop success!");
            } else {
                addMessage(FacesMessage.SEVERITY_ERROR, "不支持此种操作！");
            }
        } catch (SQLException e) {
            addMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    addMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    addMessage(FacesMessage.SEVERITY_ERROR, e.getMessage());
                }
            }
        }
    }

    public static void addMessage(FacesMessage.Severity severity, String infoStr) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(severity, infoStr, infoStr));
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }

}
