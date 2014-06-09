package gui;
import javax.swing.JOptionPane;


public class DialogTest {
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "这是错误的信息","错误信息", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "这是信息的信息","信息", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "这是警告的信息","警告信息", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "这是问题的信息","问题信息", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(null, "这是不带图标的信息","图标信息", JOptionPane.PLAIN_MESSAGE);
		
		JOptionPane.showConfirmDialog(null, "您确定提交吗","确定提交",JOptionPane.OK_CANCEL_OPTION);
		System.out.println(JOptionPane.showConfirmDialog(null, "您确定提交吗","确定提交",JOptionPane.YES_NO_CANCEL_OPTION));
		System.out.println(JOptionPane.showConfirmDialog(null, "您确定提交吗","确定提交",JOptionPane.YES_NO_OPTION));
		JOptionPane.showConfirmDialog(null, "您确定提交吗","确定提交",JOptionPane.YES_OPTION);
		String s =JOptionPane.showInputDialog("要删除几天前的帖子？", "");
		System.out.println(s);
	}

}
