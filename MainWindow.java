
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class MainWindow extends JFrame implements ActionListener{
    JButton computerButton;
    RegisterAndLoginView view;
    MainWindow() {

        setBounds(100,100,800,260);
        view = new RegisterAndLoginView();
        computerButton = new JButton("在登录成功后点击此处以进入管理系统");
        computerButton.addActionListener(this);
        add(view,BorderLayout.CENTER);
        add(computerButton,BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(view.isLoginSuccess()==false){
            JOptionPane.showMessageDialog(null,"请登录","登录提示",
                    JOptionPane.WARNING_MESSAGE);
        }
        else { JOptionPane.showMessageDialog(null,"登陆成功","登录提示",
                           JOptionPane.WARNING_MESSAGE);
            //new ZWindow();
            ZWindow window = new ZWindow();
            Container con = window.getContentPane();
            con.setBackground(Color.black);
        }
    }
    public static void main(String args[]) {
        MainWindow window = new MainWindow();
        Container con = window.getContentPane();
        con.setBackground(Color.black);

        window.setTitle("图书借阅处图书管理系统");
    }
}
