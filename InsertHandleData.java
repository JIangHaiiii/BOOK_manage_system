import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
public class InsertHandleData implements ActionListener {
    String [][] a;
    Query query;
    int m;
    InsertHandleData() {
        query=new Query();
    }
    public void setArray(String [][] a) {
        this.a =a;
    }
    public void actionPerformed(ActionEvent e) {
        Connection con;
        PreparedStatement sql;
        try { con=GetDBConnection.connectDB("test","root","123");
            String SQL=
                    "INSERT INTO student VALUES(?,?,?,?,?,?,?,?)";
            sql=con.prepareStatement(SQL);
            sql.setString(1,a[0][0].trim());
            sql.setString(2,a[0][1].trim());
            sql.setString(3,a[0][2].trim());
            sql.setString(4,a[0][3].trim());
            sql.setString(5,a[0][4].trim());
            sql.setString(6,a[0][5].trim());
            sql.setFloat(7,Float.parseFloat(a[0][6].trim()));
            sql.setString(8,a[0][7].trim());
            m=sql.executeUpdate();
            con.close();
        }
        catch(SQLException exp) {
            JOptionPane.showMessageDialog
                    (null,""+exp,"消息对话框", JOptionPane.WARNING_MESSAGE);
        }
        if(m!=0){
            query.setDatabaseName("test");
            query.setSQL("SELECT * FROM student where 图书编号='"+a[0][0].trim()+"'");
            query.startQuery();
            String ziduan[] =query.getColumnName();
            String [][]record =query.getRecord();
            DialogOne dialog = new DialogOne();
            dialog.setZiduan(ziduan);
            dialog.setRecord(record);
            dialog.init();
            dialog.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog
                    (null,"插入记录失败","消息对话框", JOptionPane.WARNING_MESSAGE);
        }
    }
}
