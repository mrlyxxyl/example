package action;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ǿfor��ʹ��ʱӦ�����ж�һ�¶����Ƿ�Ϊ��
 * ��ʹ��forѭ��ʱҲӦ�����ж�һ���Ƿ�Ϊ��
 */
public class TestSuperFor {
    public static void main(String[] args) {
        List<String> list = null;
        for (String s : list == null ? new ArrayList<String>() : list) {
            System.out.println(s);
        }

        int[] nums = new int[]{1,1,1,2};
        for (int temp : nums) {
            System.out.println(temp);
        }
    }
}
