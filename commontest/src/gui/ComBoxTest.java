package gui;
import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ComBoxTest {

	private JFrame jf;
	private JComboBox box1, box2;
	private JLabel label1;
	private JLabel label2;
	private Object[][] obj2;

	public ComBoxTest(Object[] obj1, Object[][] obj2) {
		this.obj2 = obj2;

		jf = new JFrame("�����б����");
		box1 = new JComboBox(obj1);
		box2 = new JComboBox(obj2[0]);
		label1 = new JLabel("ʡ�ݣ�");
		label2 = new JLabel("���У�");
		jf.setLayout(new FlowLayout());
		jf.add(label1);
		jf.add(box1);
		jf.add(label2);
		jf.add(box2);
		addEventHandler();
	}

	public void addEventHandler() {
		box1.addItemListener(new ItemListener() {

			public void itemStateChanged(ItemEvent e) {
				int index = box1.getSelectedIndex();
				box2.removeAllItems();
				for (int i = 0; i < obj2[index].length; i++) {
					box2.addItem(obj2[index][i]);
				}
			}
		});
	}

	public void showMe() {
		jf.setSize(400, 300);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		Object[] obj1 = new Object[] { "==��ѡ��==", "�㶫", "ɽ��", "�ӱ�", "����", "����", "����" };
		Object[][] obj2 = new Object[][] { { "==��ѡ��==" }, { "����", "����", "��ͷ", "��ɽ", "��ɽ", "Ϋ��" }, { "����", "̩��", "�ൺ", "����", "����" }, { "ʯ��ׯ", "����", "�ȷ�", "����", "�ػʵ�" }, { "֣��", "����", "����", "����", "����" }, { "�Ͼ�", "����", "����", "����", "����" }, { "����", "����", "����", "����", "����" }, };

		new ComBoxTest(obj1, obj2).showMe();
	}

}
