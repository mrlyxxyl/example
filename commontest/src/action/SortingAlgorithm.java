package action;

import java.util.Random;

/**
 * ���������㷨,���ǰ������ŵ�
 *
 * @author YSH
 * @Title: SortingAlgorithm.java
 * @Package com.ysh
 * @date 2014��2��24�� ����1:34:32
 */
public class SortingAlgorithm {
    /**
     * �������һ������Ϊlength����������
     *
     * @param length
     * @return
     */
    public int[] getArray(int length) {
        Random random = new Random();
        int[] array = new int[length];
        for (int i = 0; i < length; i++) {
            array[i] = random.nextInt(length);
        }
        return array;
    }

    /**
     * ֱ�Ӳ�������
     *
     * @param array
     */
    public void DirectInsertSort(int[] array) {
        // ��1��ʼ,���ǰ�С��ֵ��ǰ���
        for (int i = 1; i < array.length; i++) {
            // �õ�����Ϊi��ֵ,����ǰ������е�ֵ�Ƚ�
            for (int j = i; j > 0; j--) {
                // �������ֵС��ǰ���ֵ��ʱ��,2��������
                if (array[j] < array[j - 1]) {
                    // ����2������λ��
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }
    }

    /**
     * ð������
     *
     * @param array
     */
    public void MaoPaoSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // ����i��ֵ������������е�ֵ�Ƚ�,�ҳ���С��ֵ
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    // ����2������λ��
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /**
     * ѡ������
     *
     * @param array
     */
    public void ChooseSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // ������Сֵ������
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    // �ҵ���Сֵ������
                    minIndex = j;
                }
            }
            // ����Сֵ�ŵ�ǰ��ȥ
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }

    /**
     * �������� XΪ�ٶ����м�ֵ ��j��ʼ��������,�����ҿ�ʼ��������j--,�ҵ���һ��С��X��ֵ,���߽���
     * ��i��ʼ��������,������ʼ��������i++,�ҵ���һ������X��ֵ,���߽���
     *
     * @param array
     * @param left
     * @param right
     */
    public void QuickSort(int[] array, int left, int right) {
        int i = left;
        int j = right;
        // ���������i++����j--
        boolean flag = true;
        while (i != j) {
            // ��ʼ�ٶ�����ĵ�һ��ֵΪ�м�ֵ
            if (array[i] > array[j]) {
                // ����2��ֵ
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                // ����һ��ֵ��,�ı���������
                // j���ҵ���һ��С���м�ֵ������λ��
                // i���ҵ���һ�������м�ֵ������λ��
                // ����ֵ��,�м�ֵ������λ��Ҳ���Ÿı�(�ٶ����м�ֵ��һ��ѭ�������в���ı�,����λ�û��)
                flag = (flag == true) ? false : true;
            }
            if (flag == true) {
                j--;
            } else {
                i++;
            }
        }
        // һ�������,�м�ֵ��ߵĶ����м�ֵС,�ұߵĶ����м�ֵ��
        // �ݹ������м�ֵ���ߵ�����
        if (left < i - 1) {
            QuickSort(array, left, i - 1);
        }
        if (i + 1 < right) {
            QuickSort(array, i + 1, right);
        }
    }

    /**
     * ϣ������
     *
     * @param array
     */
    public void XiErSort(int[] array) {
        // ѭ������(����ÿ��������ĸ���,�����������Ϊ1ʱ,��������)
        for (int increment = array.length / 2; increment > 0; increment = increment / 2) {
            // ��increment���������������
            for (int i = 0; i < increment; i++) {
                // �����������ֱ�Ӳ�������,������Ҳ���Խ���ð������
                for (int j = i; j < array.length; j = j + increment) {
                    // �õ�����Ϊj��ֵ,����ǰ������е�ֵ�Ƚ�
                    for (int k = j; k > 0; k = k - increment) {
                        // �������ֵС��ǰ���ֵ��ʱ��,2��������
                        if (array[k] < array[k - 1]) {
                            // ����2������λ��
                            int temp = array[k];
                            array[k] = array[k - 1];
                            array[k - 1] = temp;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("����ʼ......");
        long start = System.currentTimeMillis();

        SortingAlgorithm sortingAlgorithm = new SortingAlgorithm();
        int[] array = sortingAlgorithm.getArray(10000);
        // sortingAlgorithm.XiErSort(array);// ϣ������188����
        // sortingAlgorithm.QuickSort(array, 0, array.length - 1);// ��������21����
        // sortingAlgorithm.ChooseSort(array);// ѡ������66����
        // sortingAlgorithm.DirectInsertSort(array);// ֱ�Ӳ�������76����
        sortingAlgorithm.MaoPaoSort(array);// ð������176����

        System.out.println(array[0]);
        System.out.println(array[10000 - 1]);
        long end = System.currentTimeMillis();
        System.out.println("��������ʱ�� = " + (end - start) + "����");
    }

}