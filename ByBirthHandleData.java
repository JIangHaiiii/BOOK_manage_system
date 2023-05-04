import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
public class ByBirthHandleData implements ActionListener {
    JTextField inputYear,inputMonth,inputDay;
    Query query;
    ByBirthHandleData() {
        query=new Query();
    }
    public void setJTextField(JTextField ... text) {
        inputYear = text[0];
        inputMonth = text[1];
        inputDay = text[2];
    }
    public void actionPerformed(ActionEvent e) {
        String yy = inputYear.getText(); //得到年
        String mm = inputMonth.getText(); //得到月
        String dd = inputDay.getText(); //得到日
        query.setDatabaseName("test");
        String SQL=
                "SELECT * FROM student where year(入库日期)="+yy+
                        " and month(入库日期)="+mm+
                        " and day(入库日期)="+dd;
        query.setSQL(SQL);
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