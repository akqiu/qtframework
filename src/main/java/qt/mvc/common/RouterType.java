package qt.mvc.common;

/**
 * Created by qiutian on 16-9-13.
 */
public enum RouterType {
    Post("Post", 1), Get("Get", 2), Json("Json", 3);
    // 成员变量
    private String name;
    private int index;

    // 构造方法
    private RouterType(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (RouterType c : RouterType.values()) {
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
}
