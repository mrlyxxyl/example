package gui;
import javax.swing.JOptionPane;


public class DialogTest {
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "���Ǵ������Ϣ","������Ϣ", JOptionPane.ERROR_MESSAGE);
		JOptionPane.showMessageDialog(null, "������Ϣ����Ϣ","��Ϣ", JOptionPane.INFORMATION_MESSAGE);
		JOptionPane.showMessageDialog(null, "���Ǿ������Ϣ","������Ϣ", JOptionPane.WARNING_MESSAGE);
		JOptionPane.showMessageDialog(null, "�����������Ϣ","������Ϣ", JOptionPane.QUESTION_MESSAGE);
		JOptionPane.showMessageDialog(null, "���ǲ���ͼ�����Ϣ","ͼ����Ϣ", JOptionPane.PLAIN_MESSAGE);
		
		JOptionPane.showConfirmDialog(null, "��ȷ���ύ��","ȷ���ύ",JOptionPane.OK_CANCEL_OPTION);
		System.out.println(JOptionPane.showConfirmDialog(null, "��ȷ���ύ��","ȷ���ύ",JOptionPane.YES_NO_CANCEL_OPTION));
		System.out.println(JOptionPane.showConfirmDialog(null, "��ȷ���ύ��","ȷ���ύ",JOptionPane.YES_NO_OPTION));
		JOptionPane.showConfirmDialog(null, "��ȷ���ύ��","ȷ���ύ",JOptionPane.YES_OPTION);
		String s =JOptionPane.showInputDialog("Ҫɾ������ǰ�����ӣ�", "");
		System.out.println(s);
	}

}
