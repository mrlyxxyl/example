package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginTest extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel jp = new JPanel();
	JLabel name = new JLabel("�������û���");
	JLabel password = new JLabel("����������");
	JLabel show = new JLabel();
	private JLabel[] jl = { name, password, show };
	JButton login = new JButton("��¼");
	JButton reset = new JButton("����");
	private JButton[] jb = { login, reset };
	private JTextField jName = new JTextField();
	private JPasswordField jPassword = new JPasswordField();

	public LoginTest() {
		jp.setLayout(null);
		for (int i = 0; i < 2; i++) {
			jl[i].setBounds(30, 20 + 40 * i, 180, 20);
			jb[i].setBounds(30 + 110 * i, 100, 80, 20);
			jp.add(jl[i]);
			jp.add(jb[i]);
			jb[i].addActionListener(this);
		}

		jName.setBounds(130, 15, 100, 20);
		jp.add(jName);
		jName.addActionListener(this);
		jPassword.setBounds(130, 60, 100, 20);
		jp.add(jPassword);
		jPassword.setEchoChar('*');
		jPassword.addActionListener(this);
		jl[2].setBounds(10, 180, 270, 20);
		jp.add(jl[2]);
		this.add(jp);

		this.setTitle("��¼����");
		this.setBounds(200, 200, 270, 250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jName) {//��Ҫ���ж��¼� ������
			jPassword.requestFocus();//����¼��Ľ���
		} else if (e.getSource() == jb[1]) {
			jl[2].setText("");
			jName.setText("");
			jPassword.setText("");
			jName.requestFocus();
		}

		else {
			if (jName.getText().equals("lixiangguo") && String.valueOf(jPassword.getPassword()).equals("19801001")) {
				jl[2].setText("��½�ɹ�����ӭ���ĵ���");
			}else {
				jl[2].setText("��Ǹ��������˻����������µ�¼");
			}
		}
	}
	public static void main(String[] args) {
		new LoginTest();
	}
}
