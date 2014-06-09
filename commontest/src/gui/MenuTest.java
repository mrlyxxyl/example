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

	private JMenu[] menu = { new JMenu("�ļ�"), new JMenu("����"), new JMenu("����") };

	JMenuItem open = new JMenuItem("��");
	JMenuItem save = new JMenuItem("����");
	JMenuItem saveas = new JMenuItem("���Ϊ");
	JMenuItem exit = new JMenuItem("�˳�");

	private JMenuItem[] menuItem = { open, save, saveas, exit };

	private JRadioButtonMenuItem[] radioButton = new JRadioButtonMenuItem[] { new JRadioButtonMenuItem("�Զ�����", true), new JRadioButtonMenuItem("������") };
	private ButtonGroup buttonGroup = new ButtonGroup();
	private JCheckBoxMenuItem[] checkBox = new JCheckBoxMenuItem[] { new JCheckBoxMenuItem("����"), new JCheckBoxMenuItem("б��"), new JCheckBoxMenuItem("����") };

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
		this.setTitle("�˵�С����");
		this.setBounds(200, 200, 300, 200);
		this.setVisible(true);

	}

	String newline = "\n";

	
	public void actionPerformed(ActionEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		String s = "����¼�" + newline + "�¼�Դ" + source.getText() + "(ѡ�����" + getClassName(source) + ")";
		textArea.append(s + newline);

	}

	public void itemStateChanged(ItemEvent e) {
		JMenuItem source = (JMenuItem) e.getSource();
		String s = "�˵�����" + newline + "�¼�Դ��" + source.getText() + "��ѡ�����" + getClassName(source) + ")" + newline + "�µ�״̬��" + ((e.getStateChange() == ItemEvent.SELECTED) ? "ѡ��" : " ��ѡ��");
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
