package action;

import java.util.ArrayList;
import java.util.List;

/**
 * 增强for在使用时应该先判断一下对象是否为空
 * 在使用for循环时也应该先判断一下是否为空
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
