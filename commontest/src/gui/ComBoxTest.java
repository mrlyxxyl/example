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

		jf = new JFrame("下拉列表测试");
		box1 = new JComboBox(obj1);
		box2 = new JComboBox(obj2[0]);
		label1 = new JLabel("省份：");
		label2 = new JLabel("城市：");
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
		Object[] obj1 = new Object[] { "==请选择==", "广东", "山东", "河北", "河南", "江苏", "辽宁" };
		Object[][] obj2 = new Object[][] { { "==请选择==" }, { "广州", "深圳", "汕头", "佛山", "中山", "潍坊" }, { "济南", "泰安", "青岛", "临沂", "威海" }, { "石家庄", "保定", "廊坊", "邯郸", "秦皇岛" }, { "郑州", "安阳", "洛阳", "南阳", "开封" }, { "南京", "苏州", "徐州", "扬州", "无锡" }, { "沈阳", "大连", "锦州", "铁岭", "辽阳" }, };

		new ComBoxTest(obj1, obj2).showMe();
	}

}
