import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class ByNameHandleData implements ActionListener {
    JTextField inputName;
    Query query;
    ByNameHandleData() {
        query=new Query();
    }
    public void setJTextField(JTextField ... text) {
        inputName = text[0];
    }
    public void actionPerformed(ActionEvent e) {
        String na = inputName.getText(); //得到姓名
        query.setDatabaseName("test");
        query.setSQL("SELECT * FROM student where 书籍名称='"+na+"'");
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
