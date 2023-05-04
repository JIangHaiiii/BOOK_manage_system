import javax.swing.*;
import java.awt.*;
public class ByZuoZhe extends JPanel {
    JTextField inputZuoZhe;
    JButton button;
    ByZuoZheHandleData handle;
    ByZuoZhe() {
        inputZuoZhe = new JTextField(12);
        button = new JButton("确定");
        add(new JLabel("请输入作者:"));
        add(inputZuoZhe);
        add(button);
        handle = new ByZuoZheHandleData();  //负责按姓名去处理数据的处理者
        handle.setJTextField(inputZuoZhe);
        button.addActionListener(handle);
    }
}

