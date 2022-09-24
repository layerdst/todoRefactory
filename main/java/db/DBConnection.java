package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static db.DBInfo.*;

public class DBConnection {
    private Connection conn = null;
    private PreparedStatement psmt = null;

    private static DBConnection instance;

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

    public void closedConnection() throws SQLException {
        if(conn!=null){
            conn.close();
        }
        if(psmt!=null){
            psmt.close();
        }
    }
}
