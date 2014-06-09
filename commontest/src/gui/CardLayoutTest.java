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
	 * 卡片布局管理器 方法介绍： first(Container parent);第一张 last(Container parent);最后一张
	 * next(Container parent);下一张 previous(Container parent);切换到指定容器的钱一张卡片
	 * show(Container parent,String name);切换到指定名称的组建
	 */

	JButton next = new JButton("下一个");
	JButton previous = new JButton("前一个");
	JButton first = new JButton("第一个");
	JButton last = new JButton("最后一个");
	JButton second = new JButton("第二个");
	JButton third = new JButton("第三个");
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
		
		this.setTitle("卡片布局管理器");
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
		g.drawString("下面是" + index + "图片", 80, 20);
		g.setColor(new Color(40, 40, 40));
		g.fillRect(125 - R, 125 - R, R * 2, R * 2);
		g.setColor(new Color(205, 205, 205));
		g.fillOval(125 - R, 125 - R, R * 2, R * 2);

	}

}
