import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class ByZuoZheHandleData implements ActionListener {
    JTextField inputZuoZhe;
    Query query;
    ByZuoZheHandleData() {
        query=new Query();
    }
    public void setJTextField(JTextField ... text) {
        inputZuoZhe = text[0];
    }
    public void actionPerformed(ActionEvent e) {
        String na = inputZuoZhe.getText(); //得到姓名
        query.setDatabaseName("test");
        query.setSQL("SELECT * FROM student where 作者='"+na+"'");
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
