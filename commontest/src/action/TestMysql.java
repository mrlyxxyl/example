package action;

import beanCopy.People;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException, InvocationTargetException, IntrospectionException, InstantiationException, IllegalAccessException {
        Connection con;
        PreparedStatement pstmt;
        ResultSet rs;
        Class.forName("com.jdbc.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:jdbc:///test", "root", "admin");
//        genDaoFromDB("people", con);
        String sql = "select * from people";
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();
        List<People> list = getBeanFromDB(People.class, rs);
        System.out.println(list.get(0).getId() + "\t" + list.get(0).getName() + "\t" + list.get(0).getBirthday() + "\t" + list.get(0).getScore() + "\t" + list.get(0).getWeight());
       /* String sql = "select * from people";
        String fieldSql = "SELECT  COLUMN_NAME,DATA_TYPE FROM  `information_schema`.`COLUMNS`  where table_name = 'people'";
        pstmt = con.prepareStatement(sql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            String ccn, cn;
            for (int i = 1; i <= columnCount; i++) {
                ccn = metaData.getColumnClassName(i);
                cn = metaData.getColumnName(i);
                System.out.println(cn + "\t" + ccn);

            }
            break;
        }*/
        con.close();
    }

    /**
     * 将从数据库中查出的记录根据字段名和字段类型转换成相对应的类
     *
     * @param clazz 要转换成的类
     * @param rs    数据集
     * @return 返回封装成的类集合
     * @throws java.beans.IntrospectionException
     *
     * @throws SQLException
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws java.lang.reflect.InvocationTargetException
     *
     */
    public static List getBeanFromDB(Class clazz, ResultSet rs) throws IntrospectionException, SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        if (rs == null) {
            throw new RuntimeException("数据集不能为空！");
        }
        List list = new ArrayList();
        BeanInfo beanInfo = Introspector.getBeanInfo(clazz, Object.class);
        PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
        String columnName;
        while (rs.next()) {
            Object obj = clazz.newInstance();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();
            for (int i = 1; i <= columnCount; i++) {
                columnName = metaData.getColumnName(i);
                String jp, sp;
                for (PropertyDescriptor pd : pds) {
                    jp = pd.getPropertyType().getName();
                    sp = metaData.getColumnClassName(i);
                    if (pd.getName().equalsIgnoreCase(columnName) && jp.equals(sp)) {
                        if (sp.equals("java.lang.Integer")) {
                            pd.getWriteMethod().invoke(obj, rs.getInt(pd.getName()));
                        } else if (sp.equals("java.lang.Float")) {
                            pd.getWriteMethod().invoke(obj, rs.getFloat(pd.getName()));
                        } else if (sp.equals("java.lang.Double")) {
                            pd.getWriteMethod().invoke(obj, rs.getDouble(pd.getName()));
                        } else if (sp.equals("java.lang.String")) {
                            pd.getWriteMethod().invoke(obj, rs.getString(pd.getName()));
                        } else if (sp.equals("java.sql.Date")) {
                            pd.getWriteMethod().invoke(obj, rs.getDate(pd.getName()));
                        }
                        break;
                    }
                }
            }
            list.add(obj);
        }
        return list;
    }


    public static void genDaoFromDB(String tableName, Connection conn) throws ClassNotFoundException, SQLException, IOException {
        PreparedStatement pstmt;
        ResultSet rs;
        String destFilePath = "commontest/src/model/";
        String enterStr = "\r\n";
        File destFile = new File(destFilePath);
        if (!destFile.exists()) {
            destFile.mkdirs();
        }
        FileWriter fw = new FileWriter(destFile.getAbsolutePath() + "/" + tableName.toUpperCase() + ".java");
        fw.write("package model;" + enterStr + "import java.util.Date;" + enterStr + enterStr);
        fw.write("public class " + tableName.toUpperCase() + " {" + enterStr + enterStr);

        String colsql = "SELECT  COLUMN_NAME,DATA_TYPE FROM  information_schema.COLUMNS  where table_name = '" + tableName + "'";
        pstmt = conn.prepareStatement(colsql);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            String columnClassName = rs.getString("DATA_TYPE");
            //生成字段
            if (columnClassName.equals("varchar")) {
                fw.write("    private String " + columnName + ";" + enterStr);
            } else if (columnClassName.equals("int")) {
                fw.write("    private int " + columnName + ";" + enterStr);
            } else if (columnClassName.equals("double")) {
                fw.write("    private double " + columnName + ";" + enterStr);
            } else if (columnClassName.equals("float")) {
                fw.write("    private float " + columnName + ";" + enterStr);
            } else if (columnClassName.equals("date")) {
                fw.write("    private Date " + columnName + ";" + enterStr);
            } else if (columnClassName.equals("char")) {
                fw.write("    private char " + columnName + ";" + enterStr);
            }
        }
        fw.write(enterStr);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            String columnName = rs.getString("COLUMN_NAME");
            String columnClassName = rs.getString("DATA_TYPE");
            //生成get、set方法
            if (columnClassName.equals("varchar")) {
                fw.write("    public void set" + firstToUpperCase(columnName) + "(String " + columnName + ") {" + enterStr);
                fw.write("        this." + columnName + " = " + columnName + ";" + enterStr + "    }" + enterStr);
                fw.write("    public String get" + firstToUpperCase(columnName) + "() {" + enterStr);
                fw.write("        return " + columnName + ";" + enterStr + "    }" + enterStr + enterStr);
            } else if (columnClassName.equals("int")) {
                fw.write("    public void set" + firstToUpperCase(columnName) + "(int " + columnName + ") {" + enterStr);
                fw.write("        this." + columnName + " = " + columnName + ";" + enterStr + "    }" + enterStr);
                fw.write("    public int get" + firstToUpperCase(columnName) + "() {" + enterStr);
                fw.write("        return " + columnName + ";" + enterStr + "    }" + enterStr);
            } else if (columnClassName.equals("double")) {
                fw.write("    public void set" + firstToUpperCase(columnName) + "(double " + columnName + ") {" + enterStr);
                fw.write("        this." + columnName + " = " + columnName + ";" + enterStr + "    }" + enterStr + enterStr);
                fw.write("    public double get" + firstToUpperCase(columnName) + "() {" + enterStr);
                fw.write("        return " + columnName + ";" + enterStr + "    }" + enterStr + enterStr);

            } else if (columnClassName.equals("float")) {
                fw.write("    public void set" + firstToUpperCase(columnName) + "(float " + columnName + ") {" + enterStr);
                fw.write("        this." + columnName + " = " + columnName + ";" + enterStr + "    }" + enterStr + enterStr);
                fw.write("    public float get" + firstToUpperCase(columnName) + "() {" + enterStr);
                fw.write("        return " + columnName + ";" + enterStr + "    }" + enterStr + enterStr);

            } else if (columnClassName.equals("date")) {
                fw.write("    public void set" + firstToUpperCase(columnName) + "(Date " + columnName + ") {" + enterStr);
                fw.write("        this." + columnName + " = " + columnName + ";" + enterStr + "    }" + enterStr + enterStr);
                fw.write("    public Date get" + firstToUpperCase(columnName) + "() {" + enterStr);
                fw.write("        return " + columnName + ";" + enterStr + "    }" + enterStr + enterStr);
            } else if (columnClassName.equals("char")) {
                fw.write("    public void set" + firstToUpperCase(columnName) + "(char " + columnName + ") {" + enterStr);
                fw.write("        this." + columnName + " = " + columnName + ";" + enterStr + "    }" + enterStr + enterStr);
                fw.write("    public char get" + firstToUpperCase(columnName) + "() {" + enterStr);
                fw.write("        return " + columnName + ";" + enterStr + "    }" + enterStr + enterStr);
            }
        }

        fw.write("}");
        fw.close();
    }

    public static String firstToUpperCase(String str) {
        String firstLetter = str.charAt(0) + "";
        str = firstLetter.toUpperCase() + str.substring(1);
        return str;
    }
}
