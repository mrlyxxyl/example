package beanCopy;

import java.util.Date;

public class People {
    private String id;//id��
    private String name;//����
    private int age;//����
    private String sex;//�Ա�
    private Date birthday;//����
    private int height;//���
    private int weight;//����
    private double score;//�ɼ�
    private long btime;//��������

    public People() {
    }

    public People(String id, String name, int age, String sex, Date birthday, int height, int weight, double score, long btime) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.birthday = birthday;
        this.height = height;
        this.weight = weight;
        this.score = score;
        this.btime = btime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public long getBtime() {
        return btime;
    }

    public void setBtime(long btime) {
        this.btime = btime;
    }


}
