package com.lila.baotuan.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlUtil {

    public static String write(String htmlContext) throws IOException {
        String HtmlName = new SimpleDateFormat("YYYYMMddhhmmssSSS").format(new Date()) + ".html";
        String filePath = "/www/payPath/" + HtmlName;
        FileOutputStream fop = null;
        File file;
        try {

            file = new File(filePath);
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            fop = new FileOutputStream(file);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // get the content in bytes
            byte[] contentInBytes = htmlContext.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return HtmlName;
    }

    public static void main(String[] args) throws IOException {
        write("测试文件");
    }
}
