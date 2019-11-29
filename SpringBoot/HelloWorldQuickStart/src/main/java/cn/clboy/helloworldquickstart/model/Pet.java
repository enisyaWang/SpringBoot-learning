package cn.clboy.helloworldquickstart.model;

/**
 * @Author cloudlandboy
 * @Date 2019/11/13 下午8:17
 * @Since 1.0.0
 */

public class Pet {

    private String name;
    private Integer age;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Pets{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}