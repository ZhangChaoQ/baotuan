package com.lila.baotuan.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HtmlUtil {

    public static String write(String htmlContext, String name) throws IOException {
        String filePath = "/home/payPath/" + name + ".html";
        FileOutputStream fop = null;
        OutputStreamWriter osw = null;
        String charset = "UTF-8";
        fop = new FileOutputStream(filePath);
        osw = new OutputStreamWriter(fop, "gbk");
        String context = new String(htmlContext.getBytes(charset));
        osw.write(context);
        osw.flush();
        osw.close();
        return name + ".html";
    }

}
