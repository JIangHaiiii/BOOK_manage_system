
import javax.swing.*;
import java.awt.*;
public class RegisterAndLoginView extends JPanel{
    JTabbedPane p;
    RegisterView registerView;
    LoginView loginView;
    public RegisterAndLoginView(){
        registerView=new RegisterView();
        loginView = new LoginView();
        setLayout(new BorderLayout());
        p = new JTabbedPane();
        p.add("注册界面",registerView);
        p.add("登录界面",loginView);



        p.validate();
        add(p,BorderLayout.CENTER);
    }
    public boolean isLoginSuccess() {
        return loginView.isLoginSuccess();
    }
}