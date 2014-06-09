package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class MenuTest extends JFrame implements ActionListener, ItemListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JMenu[] menu = { new JMenu("文件"), new JMenu("设置"), new JMenu("字体") };

	JMenuItem open = new JMenuItem("打开");
	JMenuItem save = new JMenuItem("保存");
	JMenuItem saveas = new JMenuItem("另存为");
	JMenuItem exit = new JMenuItem("退出");

	private JMenuItem[] menuItem = { open, save, saveas, exit };

	private JRadioButtonMenuItem[] radioButton = new JRadioButtonMenuItem[] { new JRadioButtonMenuItem("自动换行", true), new JRadioButtonMenuItem("不换行") };
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBoxMenuItem[] checkBox = new JCheckBoxMenuItem[] { new JCheckBoxMenuItem("粗体"), new JCheckBoxMenuItem("斜体"), new JCheckBoxMenuItem("宋体") };

	private JMenuBar menuBar = new JMenuBar();
	private JTextArea textArea = new JTextArea();
	private JScrollPane scrollPane = new JScrollPane(textArea);

	public MenuTest() {
		menuBar.add(menu[0]);
		menuBar.add(menu[1]);

		for (int i = 0; i < menuItem.length; i++) {
			menu[0].add(menuItem[i]);
			menuItem[i].addActionListener(this);
		}

		for (int i = 0; i < radioButton.length; i++) {
			menu[1].add(radioButton[i]);
			radioButton[i].addItemListener(this);
			buttonGroup.add(radioButton[i]);

		}

		menu[1].addSeparator();
		menu[1].add(menu[2]);
		for (int i = 0; i < checkBox.length; i++) {
			menu[2].add(checkBox[i]);
			checkBox[i].addItemListener(this);

		}

		this.setJMenuBar(menuBar);
		this.add(scrollPane);
		this.setTitle("菜单小测试");
		this.setBounds(200, 200, 300, 200);
		this.setVisible(true);

	}

	String newline = "\n";

	
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		String s = "监测事件" + newline + "事件源" + source.getText() + "(选择对象" + getClassName(source) + ")";
		textArea.append(s + newline);

	}

	public void itemStateChanged(ItemEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		String s = "菜单监听" + newline + "事件源：" + source.getText() + "（选择对象" + getClassName(source) + ")" + newline + "新的状态：" + ((e.getStateChange() == ItemEvent.SELECTED) ? "选择" : " 不选择");
		textArea.append(s + newline);
	}

	protected String getClassName(Object o) {
		String classString = o.getClass().getName();
		int dotIndex = classString.lastIndexOf(".");
		return classString.substring(dotIndex + 1);
	}

	public static void main(String[] args) {
		new MenuTest();
	}

}
