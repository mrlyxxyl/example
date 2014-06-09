package gui;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CardLayoutTest extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 * ��Ƭ���ֹ����� �������ܣ� first(Container parent);��һ�� last(Container parent);���һ��
	 * next(Container parent);��һ�� previous(Container parent);�л���ָ��������Ǯһ�ſ�Ƭ
	 * show(Container parent,String name);�л���ָ�����Ƶ��齨
	 */

	JButton next = new JButton("��һ��");
	JButton previous = new JButton("ǰһ��");
	JButton first = new JButton("��һ��");
	JButton last = new JButton("���һ��");
	JButton second = new JButton("�ڶ���");
	JButton third = new JButton("������");
	private JButton[] jb = new JButton[] { next, previous, first, second, third, last };

	private JPanel jP = new JPanel();

	public CardLayoutTest() {
		this.setLayout(null);

		for (int i = 0; i < jb.length; i++) {
			jb[i].setBounds(300, 30 + 30 * i, 90, 20);
			this.add(jb[i]);
			jb[i].addActionListener(this);
		}

		jP.setLayout(new CardLayout());
		for (int i = 0; i < 4; i++) {
			jP.add(new Card(i), "card" + (i + 1));
		}
		
		jP.setBounds(10,10,200,200);
		this.add(jP);
		
		this.setTitle("��Ƭ���ֹ�����");
		this.setBounds(200,200,400,250);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		new CardLayoutTest();
	}

	public void actionPerformed(ActionEvent e) {
		CardLayout cl = (CardLayout)jP.getLayout();
		
		if (e.getSource() == jb[0]) {
			cl.next(jP);
		}
		else if (e.getSource() == jb[1]) {
			cl.previous(jP);
		}
		else if (e.getSource() == jb[2]) {
			cl.first(jP);
		}
		else if (e.getSource() == jb[3]) {
			cl.show(jP,"card2");
		}
		else if (e.getSource() == jb[4]) {
			cl.show(jP,"card3");
		}
		else if (e.getSource() == jb[5]) {
			cl.last(jP);
		}
	}

}

class Card extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int index, R;

	public Card() {

	}

	public Card(int index) {
		this.index = index + 1;
		this.R = index * 20 + 20;
	}

	@Override
	public void paint(Graphics g) {
		g.clearRect(0, 0, 200, 200);
		g.drawString("������" + index + "ͼƬ", 80, 20);
		g.setColor(new Color(40, 40, 40));
		g.fillRect(125 - R, 125 - R, R * 2, R * 2);
		g.setColor(new Color(205, 205, 205));
		g.fillOval(125 - R, 125 - R, R * 2, R * 2);

	}

}
