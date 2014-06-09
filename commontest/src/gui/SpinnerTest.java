package gui;
import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpinnerTest extends JFrame implements ChangeListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 微调测试器Spinner类 方法: getValue()、setValue()、getNextvalue()、getPreviousValue()
	 * setValue()
	 */
	private JPanel panel = new JPanel();
	private JLabel[] labelArray = new JLabel[] { new JLabel("选择年："), new JLabel("选择月："), new JLabel("选择日：") };

	JLabel resultLabel = new JLabel("请选择您预订机票的日期！");
	private ArrayList<String> arrayList = new ArrayList<String>();
	private SpinnerNumberModel snm1 = new SpinnerNumberModel();
	private SpinnerListModel slm = new SpinnerListModel();
	private SpinnerNumberModel snm2 = new SpinnerNumberModel(9, 1, 31, 1);
	private JSpinner[] spinnerArray = { new JSpinner(snm1), new JSpinner(slm), new JSpinner(snm2) };

	public SpinnerTest() {
		panel.setLayout(null);

		for (int i = 0; i <= 12; i++) {
			arrayList.add(i + "月");

		}

		slm.setList(arrayList);
		slm.setValue("9月");

		for (int j = 0; j < spinnerArray.length; j++) {
			labelArray[j].setBounds(20 + j * 120, 30, 80, 30);
			panel.add(labelArray[j]);
			spinnerArray[j].setBounds(70 + j * 130, 30, 60, 26);
			panel.add(spinnerArray[j]);
			spinnerArray[j].addChangeListener(this);

		}
		this.add(panel);
		this.add(resultLabel,BorderLayout.SOUTH);
		
		this.setTitle("选择机票日期实例");
		this.setBounds(200,200,450,130);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void stateChanged(ChangeEvent e) {
		int year = ((Integer)(spinnerArray[0].getValue())).intValue();
		String month = ((String )(spinnerArray[1].getValue()));
		int day = ((Integer)(spinnerArray[2].getValue())).intValue();
		
		resultLabel.setText("您预订的机票的日期是：" + year + "年" + month + "月" + day + "日");
	}

	public static void main(String[] args) {
		new SpinnerTest();
	}

}
