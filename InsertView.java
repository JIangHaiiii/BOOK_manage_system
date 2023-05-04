import java.awt.*;
import javax.swing.*;
public class InsertView extends JPanel {
    JTable table;
    String []head ={"图书编号","书籍名称","作者","出版社名称","文学类型","入库日期","图书价格","是否在库中"};
    String [][] a ={{" "," "," "," "," "," "," "," "}};
    JButton button;
    InsertHandleData handle;
    InsertView() {
        setLayout(null);
        table = new JTable(a,head);
        table.setFont(new Font("宋体",Font.BOLD,16));
        table.setRowHeight(40);
        button = new JButton("插入记录");
        JScrollPane js=new JScrollPane(table);
        add(js);
        add(button);
        js.setBounds(10,10,800,80);
        button.setBounds(812,30,120,30);
        handle = new InsertHandleData();  //数据的处理者
        handle.setArray(a);
        button.addActionListener(handle);
    }
}
