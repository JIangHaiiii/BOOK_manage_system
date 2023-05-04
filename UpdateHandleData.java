import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
public class UpdateHandleData implements ActionListener {
    JTextField inputID;
    JButton buttonLook,buttonUpdate;
    String [][] a;
    Query query;
    String id;
    int m;
    UpdateHandleData() {
        query=new Query();
    }
    public void setArray(String [][] a) {
        this.a =a;
    }
    public void setJTextField(JTextField ... text) {
        inputID = text[0];
    }
    public void setJButton(JButton ... b) {
        buttonLook= b[0];
        buttonUpdate =b[1];
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonUpdate) {
            id=inputID.getText().trim();
            doGengxin();
        }
        else if(e.getSource()==buttonLook) {
            id=inputID.getText().trim();
            doLookRecord();
        }
    }
    private void doGengxin(){
        Connection con;
        PreparedStatement sql;
        try { con=con=GetDBConnection.connectDB("test","root","123");
            String SQL=
                    "update student set 书籍名称=? ,作者=? ,出版社名称=? ,文学类型=? ,入库日期=? ,图书价格=? ,是否在库中=? where 图书编号='"+id+"'";

            sql=con.prepareStatement(SQL);
            sql.setString(1,a[0][0].trim());
            sql.setString(2,a[0][1].trim());
            sql.setString(3,a[0][2].trim());
            sql.setString(4,a[0][3].trim());
            sql.setString(5,a[0][4].trim());
            sql.setFloat(6,Float.parseFloat(a[0][5].trim()));
            sql.setString(7,a[0][6].trim());

            m=sql.executeUpdate();
            con.close();
        }
        catch(SQLException e) {
            JOptionPane.showMessageDialog
                    (null,""+e,"消息对话框", JOptionPane.WARNING_MESSAGE);
        }
        if(m!=0){
            query.setDatabaseName("test");
            query.setSQL("SELECT * FROM student where 图书编号='"+id+"'");
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
                    (null,"更新记录失败","消息对话框", JOptionPane.WARNING_MESSAGE);
        }
    }
    private void doLookRecord() {
        query.setDatabaseName("test");
        query.setSQL("SELECT * FROM student where 图书编号='"+id+"'");
        query.startQuery();
        String ziduan[] =query.getColumnName();
        String [][]record =query.getRecord();
        DialogOne dialog = new DialogOne();
        dialog.setZiduan(ziduan);
        dialog.setRecord(record);
        dialog.init();
        dialog.setVisible(true);
    }
}

