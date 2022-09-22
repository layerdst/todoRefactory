package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static db.DBInfo.*;

public class DBConnections {
    private final Connection conn;
    private final PreparedStatement psmt;

    public DBConnections(String sql){
        try{
            this.conn = DriverManager.getConnection(DB_ADDR_MYSQL, DB_USER, DB_PW);
            this.psmt = conn.prepareStatement(sql);
        }catch (Exception e){
            throw new IllegalArgumentException("DB 주소나 유저정보가 잘못되었음");
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
