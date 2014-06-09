package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class MyBrowser extends JFrame implements ActionListener, HyperlinkListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel panel = new JPanel();

	private JEditorPane editorPane = new JEditorPane();
	private JTextField textField = new JTextField();
	private JButton button = new JButton("转到");
	private JScrollPane scrollPane = new JScrollPane(editorPane);

	public MyBrowser() {
		editorPane.setEditable(false);
		panel.setLayout(null);
		textField.setBounds(10, 10, 500, 26);
		button.setBounds(520, 10, 80, 26);
		scrollPane.setBounds(5, 40, 602, 430);
		panel.add(textField);
		panel.add(button);
		panel.add(scrollPane);
		button.addActionListener(this);
		textField.addActionListener(this);
		editorPane.addHyperlinkListener(this);

		this.add(panel);
		this.setTitle("简易浏览器");
		this.setBounds(100, 100, 620, 500);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void actionPerformed(ActionEvent e) {
		String url = textField.getText().trim();

		try {
			editorPane.setPage(url);
		} catch (IOException e1) {
			this.errorMsg();
			e1.printStackTrace();
		}
	}

	private void errorMsg() {

		try {
			File file = new File("F:/Java/error.htm");
			editorPane.setPage(file.toURI().toURL());
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void hyperlinkUpdate(HyperlinkEvent e) {// 重写方法
		if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {//通过获取 的URL设置当前的页面
			try {
				editorPane.setPage(e.getURL());
			} catch (IOException e1) {
				this.errorMsg();
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new MyBrowser();
	}

}
