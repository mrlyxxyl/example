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
	 * ΢��������Spinner�� ����: getValue()��setValue()��getNextvalue()��getPreviousValue()
	 * setValue()
	 */
	private JPanel panel = new JPanel();
	private JLabel[] labelArray = new JLabel[] { new JLabel("ѡ���꣺"), new JLabel("ѡ���£�"), new JLabel("ѡ���գ�") };

	JLabel resultLabel = new JLabel("��ѡ����Ԥ����Ʊ�����ڣ�");
	private ArrayList<String> arrayList = new ArrayList<String>();
	private SpinnerNumberModel snm1 = new SpinnerNumberModel();
	private SpinnerListModel slm = new SpinnerListModel();
	private SpinnerNumberModel snm2 = new SpinnerNumberModel(9, 1, 31, 1);
	private JSpinner[] spinnerArray = { new JSpinner(snm1), new JSpinner(slm), new JSpinner(snm2) };

	public SpinnerTest() {
		panel.setLayout(null);

		for (int i = 0; i <= 12; i++) {
			arrayList.add(i + "��");

		}

		slm.setList(arrayList);
		slm.setValue("9��");

		for (int j = 0; j < spinnerArray.length; j++) {
			labelArray[j].setBounds(20 + j * 120, 30, 80, 30);
			panel.add(labelArray[j]);
			spinnerArray[j].setBounds(70 + j * 130, 30, 60, 26);
			panel.add(spinnerArray[j]);
			spinnerArray[j].addChangeListener(this);

		}
		this.add(panel);
		this.add(resultLabel,BorderLayout.SOUTH);
		
		this.setTitle("ѡ���Ʊ����ʵ��");
		this.setBounds(200,200,450,130);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

	public void stateChanged(ChangeEvent e) {
		int year = ((Integer)(spinnerArray[0].getValue())).intValue();
		String month = ((String )(spinnerArray[1].getValue()));
		int day = ((Integer)(spinnerArray[2].getValue())).intValue();
		
		resultLabel.setText("��Ԥ���Ļ�Ʊ�������ǣ�" + year + "��" + month + "��" + day + "��");
	}

	public static void main(String[] args) {
		new SpinnerTest();
	}

}
