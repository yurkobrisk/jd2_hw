package jd2_hw.cookies_and_sessions_topic4.task14.data;

import java.io.Serializable;

public class Receivers implements Serializable {

    private int num;
    private String name;

    public Receivers() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Receivers)) return false;
        Receivers receivers = (Receivers) o;
        if (getNum() != receivers.getNum()) return false;
        return getName().equals(receivers.getName());
    }

    @Override
    public int hashCode() {
        int result = getNum();
        result = 31 * result + getName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Receivers{" +
                "num=" + num +
                ", name='" + name + '\'' +
                '}';
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
