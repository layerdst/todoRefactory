package db.connect;

import java.sql.*;

import static db.source.DBInfo.*;

public class DBConnection {
    private Connection conn = null;
    private PreparedStatement psmt = null;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public void setPsmt(PreparedStatement psmt) {
        this.psmt = psmt;
    }

    private static DBConnection instance;
    public static void setInstance(DBConnection instance) {
        DBConnection.instance = instance;
    }
    public static DBConnection getInstance(){
        if(instance == null){
            instance = new DBConnection();
        }
        return instance;
    }

    public PreparedStatement setParamSql(String sql){
        try{
            this.conn = DriverManager.getConnection(DB_ADDR_MYSQL, DB_USER, DB_PW);
            this.psmt = conn.prepareStatement(sql);
            return psmt;
        }catch (Exception e){
            e.printStackTrace();
            throw new IllegalArgumentException("DB 접속에 문제가 있음");
        }
    }

    public PreparedStatement getPsmt() {
        return psmt;
    }

    public void  closedConnection(Connection conns, PreparedStatement psmts, ResultSet rs) throws SQLException {
        if(conns!=null){
            conns.close();
        }
        if(psmts!=null){
            psmts.close();
        }
        if(rs != null){
            rs.close();
        }
    }
}
