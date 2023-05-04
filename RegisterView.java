
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RegisterView extends JPanel implements ActionListener {
    Register register;

    JRadioButton radioM,radioF;
    ButtonGroup group;

    JTextField inputID,inputBirth,W;
    JPasswordField inputPassword;
    JButton buttonRegister;
    RegisterView() {
        group = new ButtonGroup();
        radioM = new JRadioButton("男");
        radioF = new JRadioButton("女");
        group.add(radioM);
        group.add(radioF);

        register = new Register();
        inputID = new JTextField(12);
        inputPassword = new JPasswordField(12);
        W= new JPasswordField(12);
        inputBirth = new JTextField(12);
        buttonRegister = new JButton("注册");
        add(new JLabel("ID:"));
        add(inputID);
        add(new JLabel("密码:"));
        add(inputPassword);


        add(new JLabel("性别:"));
        add(radioM);
        add(radioF);
        //add(W);
        add(new JLabel("出生日期:"));
        add(inputBirth);

        add(buttonRegister);
        buttonRegister.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e) {
        register.setID(inputID.getText());
        char [] pw =inputPassword.getPassword();
        register.setPassword(new String(pw));
        register.setBirth(inputBirth.getText());
        HandleInsertData handleRegister = new HandleInsertData();
        handleRegister.writeRegisterModel(register);
    }
}