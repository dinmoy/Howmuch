package JavaProject;

import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
//https://eating-coding.tistory.com/42
public class CommonFrame extends JFrame {
   static Connection con;
   static Statement stmt;
   
   static {
      try {
         con = DriverManager.getConnection("jdbc:mysql://localhost/shopingdb", "root", "1234");
         stmt = con.createStatement();
      } catch (SQLException e) {
         e.printStackTrace();
      }
   }
   
   void showWithPrev(ActionListener action) {
        setVisible(true);
        
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                action.actionPerformed(null);
            }
        });
    }
   
   static ResultSet getResulSet(String sql, Object... paramter) {
      try {
         var pstmt = con.prepareStatement(sql);
         for (int i = 0; i < paramter.length; i++) {
            pstmt.setObject(i + 1, paramter[i]);
         }
         
         //SELECT 전용
         return pstmt.executeQuery();
         
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      return null;
   }
   
   static ResultSet updateSQL(String sql, Object... paramter) {
      try {
         var pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
         
         for (int i = 0; i < paramter.length; i++) {
            pstmt.setObject(i + 1, paramter[i]);
         }
         
         //INSER, UPDATE, DELETE 데이터 변경
         pstmt.executeUpdate();
         
         return pstmt.getGeneratedKeys();
         
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return null;
   }
}