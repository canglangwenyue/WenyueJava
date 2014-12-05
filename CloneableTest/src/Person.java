/**
 * Created by canglangwenyue on 12/5/14.
 */
public class Person implements Cloneable {

    private int id;
    private String name;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() {

        Person copy = null;

        try {
            copy = (Person) super.clone();
            copy.clone().getClass().getName();

        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        } finally {
            return copy;
        }


    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * 引用复制的测试
     */

    public static void referenceTest() {
        Person person = new Person();

        person.setId(1);
        person.setName("WenYue");

        Person copy = person;

        if (copy.equals(person))
            System.out.println("引用复制的person和copy是同一个对象");
        else
            System.out.println("引用复制的person和copy不是同一个对象");

        System.out.println(person);
        System.out.println(copy);
        System.out.println(person.getName());
        System.out.println(copy.getName());

    }

    /**
     * 对于Object的clone的测试方法，并检测出clone实现的是浅拷贝
     */
    public static void cloneTest(){
        Person person = new Person();

        person.setId(1);
        person.setName("WenYue");

        Person copy = null;

        copy = (Person) person.clone();
        copy.setName("CangLang");

        if (copy.equals(person))
            System.out.println("clone的person和copy是同一个对象");
        else
            System.out.println("clone的person和copy不是同一个对象");

        System.out.println(person);
        System.out.println(copy);
        System.out.println(person.getName());
        System.out.println(copy.getName());

        String result = person.getName()==copy.getName()?"clone是浅拷贝":"clone是深拷贝";
        System.out.println(result);

    }

    public static void main(String[] args) {
        /*测试clone*/
        cloneTest();

        /*测试引用复制*/
        referenceTest();

    }


}
