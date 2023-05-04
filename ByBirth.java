import  java.awt.*;
import javax.swing.*;
public class ByBirth extends JPanel {
    JTextField inputYear,inputMonth,inputDay;
    JButton button;
    ByBirthHandleData handle;
    ByBirth() {
        inputYear = new JTextField(10);
        inputMonth = new JTextField(6);
        inputDay = new JTextField(6);
        button = new JButton("确定");
        add(new JLabel("请输入入库年份"));
        add(inputYear);
        add(new JLabel("请输入入库月份"));
        add(inputMonth);
        add(new JLabel("请输入入库日期"));
        add(inputDay);
        add(button);
        handle = new ByBirthHandleData();//负责按出生去查询的数据处理者
        handle.setJTextField(inputYear,inputMonth,inputDay);
        button.addActionListener(handle);
    }
}