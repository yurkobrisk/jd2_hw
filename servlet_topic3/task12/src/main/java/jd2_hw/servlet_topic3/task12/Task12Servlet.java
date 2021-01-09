package jd2_hw.servlet_topic3.task12;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class Task12Servlet extends HttpServlet {

    private int counter;
    private String fileName = "D:\\jd2_hw\\servlet_topic3\\task12\\counter.txt";

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
        // установить тип передаваемых данных
        resp.setContentType("image/jpeg");

        // закинуть картинку в буфер
//        BufferedImage image = new BufferedImage(500, 400, BufferedImage.TYPE_INT_RGB);
        BufferedImage image = ImageIO.read(new File("D:\\jd2_hw\\servlet_topic3\\task12\\image.jpg"));

        counter = getCounter();

        // создание объекта 2D графики
        Graphics2D graphics = image.createGraphics();
        graphics.setFont(new Font("Serif", Font.BOLD, 250));
        graphics.setColor(Color.WHITE);
        graphics.drawString("" + ++counter, 100, 300);

        // создание потока и вывод картинки
        ServletOutputStream outputStream = resp.getOutputStream();
        ImageIO.write(image, "jpeg", outputStream);

        setCounter(counter);
    }
}
