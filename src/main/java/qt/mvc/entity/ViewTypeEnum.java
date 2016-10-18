package qt.mvc.entity;

/**
 * Created by qiutian on 16-10-2.
 */
public enum ViewTypeEnum {

    JSP("JSP", 0), Freemarker("Freemarker", 1),Velocity("Velocity", 2);

    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private ViewTypeEnum(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (ViewTypeEnum c : ViewTypeEnum.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public static ViewTypeEnum getEnum(int index) {
        for (ViewTypeEnum c : ViewTypeEnum.values()) {
            if (c.getIndex() == index) {
                return c;
            }
        }
        return ViewTypeEnum.JSP;
    }
}
