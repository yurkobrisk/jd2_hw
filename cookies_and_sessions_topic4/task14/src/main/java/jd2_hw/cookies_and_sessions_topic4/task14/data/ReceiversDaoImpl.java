package jd2_hw.cookies_and_sessions_topic4.task14.data;

import java.sql.Connection;
import java.util.List;

public class ReceiversDaoImpl implements ReceiversDao {
    Connection connection;

    public ReceiversDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Receivers receivers) {
    }

    @Override
    public Receivers read(int num) {
        return null;
    }

    @Override
    public List<Receivers> readAll() {
        return null;
    }

    @Override
    public void update(Receivers receivers) {
    }

    @Override
    public void delete(Receivers receivers) {
    }
}
