package action;

import java.util.Random;

public class GenerateRandomNumber {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getCharAndNumr(10));
        }
    }

    /**
     * java����������ֺ���ĸ���
     *
     * @return
     */
    public static String getCharAndNumr(int length) {
        String val = "";
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            // �����ĸ��������
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // �ַ���
            if ("char".equalsIgnoreCase(charOrNum)) {
                // ȡ�ô�д��ĸ����Сд��ĸ
                int choice = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (choice + random.nextInt(26));
            } else if ("num".equalsIgnoreCase(charOrNum)) { // ����
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

}