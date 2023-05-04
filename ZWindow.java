import java.awt.*;
import javax.swing.*;
public class ZWindow extends JFrame{
    JTabbedPane p;
    ByName byName;
    ByBirth byBirth;
    ByPrice byPrice;


    ByZuoZhe byZuoZhe;

    UpdateView  updateView;
    InsertView  insertView;

    public ZWindow(){


        setBounds(100,100,1200,360);
        setTitle("图书借阅处图书管理系统");
        setVisible(true);
        p=new JTabbedPane();
        byName = new ByName();
        byBirth = new ByBirth();
        byPrice = new ByPrice();


        byZuoZhe = new ByZuoZhe();

        updateView = new UpdateView();
        insertView = new InsertView();



        p.add("按书籍名称查询",byName);
        p.add("按价格区间查询",byPrice);
        p.add("按入库日期查询",byBirth);


        p.add("按作者查询",byZuoZhe);

        p.add("向图书管理表添加记录",insertView);
        p.add("根据图书编号更新记录",updateView);
        p.validate();
        add(p,BorderLayout.CENTER);
        validate();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}