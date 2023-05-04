import javax.swing.*;
import java.awt.*;
public class ByName extends JPanel {
    JTextField inputName;
    JButton button;
    ByNameHandleData handle;
    ByName() {
        inputName = new JTextField(12);
        button = new JButton("确定");
        add(new JLabel("请输入书籍名称:"));
        add(inputName);
        add(button);
        handle = new ByNameHandleData();
        handle.setJTextField(inputName);
        button.addActionListener(handle);
    }
}
