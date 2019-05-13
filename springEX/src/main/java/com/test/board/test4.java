package com.test.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class test4 {
	

    public static void main(String args[]) {
        /**
         * メンバ変数を定義
         */
        Connection con = null;
        Statement stmt = null;
        ResultSet res = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }


        /**
         * URLとSQL文を指定
         */
        String url = "jdbc:mysql://localhost:3306/tsdb";
        String user = "root";
        String password = "";
        String sql = "select * frome test";

        try {
            //データベースに接続
            con = DriverManager.getConnection(url, user, password);
            //ステートメントの作成
            stmt = con.createStatement();
            //SQL文の実行
            res = stmt.executeQuery(sql);
            //ワードローブの情報を表示

            while(res.next()) {
                System.out.println(res.getInt(1));
                System.out.println(res.getString(2));
                System.out.println(res.getString(3));
                System.out.println(res.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                //結果セットのクローズ
                if(res != null) {
                    res.close();
                }
                //ステートメントのクローズ
                if(stmt != null) {
                    stmt.close();
                }
                //接続のクローズ
                if(con != null) {
                    con.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }

}
