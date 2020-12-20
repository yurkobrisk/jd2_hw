package jd2_hw.maven_topic2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticTest {

    @Test
    public void testGetResult() {
        List<Integer> list = new ArrayList<>();
        list.add(-2);
        list.add(10);

        Arithmetic arithmetic = new Arithmetic(list);

        Assert.assertEquals(4.0, arithmetic.getResult(), 0);

    }
}