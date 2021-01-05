package jd2_hw.servlet_topic2.task9;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task9Servlet extends HttpServlet {

    private int counter;
    private String fileName = "D:\\jd2_hw\\servlet_topic2\\task9\\counter.txt";

    /**
     * Метод читает из файла значение counter-a
     * @return
     */
    protected int getCounter() {
        File file = new File(fileName);
        String result = "";
        if (!file.isFile()) {
            return 0;
        }else {
            try (FileInputStream fis = new FileInputStream(fileName)) {
                int i;
                while ((i = fis.read()) != -1) {
                    result += (char) i;
                }
                if (result.equals("") || (Integer.parseInt(result) < 1)) {
                    return 0;
                }
                return Integer.parseInt(result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    /**
     * Метод записывает в файл значение counter-a
     * @param counter Счетчик
     */
    protected void setCounter(int counter) {
        File file = new File(fileName);
            try (FileOutputStream fos = new FileOutputStream(file)) {
                fos.write(("" + counter).getBytes(StandardCharsets.UTF_8));
            } catch (IOException e) {
                e.printStackTrace();
            }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        counter = getCounter();
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>First Servlet</title></head>");
        out.println("<body><h1>This is Task 9 Servlet for topic 2: servlet</h1>");
        out.println("Counter : " + ++counter);
        out.println("</body></html>");
        setCounter(counter);
    }

}
