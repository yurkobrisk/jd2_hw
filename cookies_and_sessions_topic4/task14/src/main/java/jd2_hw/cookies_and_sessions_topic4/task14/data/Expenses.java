package jd2_hw.cookies_and_sessions_topic4.task14.data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Expenses implements Serializable {
    private int num;
    private Date paydate;
    private int receiver;
    private BigDecimal value;

    public Expenses() {
    }

    @Override
    public String toString() {
        return "Expenses{" +
                "num=" + num +
                ", paydate=" + paydate +
                ", receiver=" + receiver +
                ", value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expenses expenses = (Expenses) o;
        return num == expenses.num && receiver == expenses.receiver && Objects.equals(paydate, expenses.paydate) && Objects.equals(value, expenses.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(num, paydate, receiver, value);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Date getPaydate() {
        return paydate;
    }

    public void setPaydate(Date paydate) {
        this.paydate = paydate;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
