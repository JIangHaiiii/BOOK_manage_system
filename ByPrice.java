import javax.swing.*;
import java.awt.*;
public class ByPrice extends JPanel {
    JTextField price1;
    JTextField price2;
    JButton button;
    ByPriceHandleData handle;
    ByPrice() {
        price1 = new JTextField(5);
        price2 = new JTextField(5);
        button = new JButton("确定");
        add(new JLabel("输入价格区间:"));
        add(price1);
        add(new JLabel("到"));
        add(price2);
        add(button);
        handle = new ByPriceHandleData();  //负责按姓名去处理数据的处理者
        handle.setJTextField(price1,price2);
        button.addActionListener(handle);
    }
}
