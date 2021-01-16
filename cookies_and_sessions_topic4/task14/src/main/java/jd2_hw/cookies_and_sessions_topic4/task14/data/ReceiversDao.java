package jd2_hw.cookies_and_sessions_topic4.task14.data;

import java.util.List;

public interface ReceiversDao {

    void create(Receivers receivers);

    Receivers read(int num);

    List<Receivers> readAll();

    void update(Receivers receivers);

    void delete(Receivers receivers);
}
