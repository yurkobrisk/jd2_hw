package jd2_hw.cookies_and_sessions_topic4.task14.data;

import java.util.List;

public interface ExpensesDao {

    void create(Expenses expenses);

    void update(Expenses expenses);

    void delete(Expenses expenses);

    Expenses read(int num);

    List<Expenses> readAll();
}
