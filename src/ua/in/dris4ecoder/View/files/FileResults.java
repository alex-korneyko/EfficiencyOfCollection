package ua.in.dris4ecoder.View.files;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Клас для вывода таблицы в фойл
 * <p>
 * Created by Alex Korneyko on 31.05.2016.
 */
public class FileResults {
    String fileName;
    FileType fileType;
    File file;
    PrintWriter printWriter;

    public FileResults(String fileName, FileType fileType) {
        this.fileName = fileName;
        this.fileType = fileType;

        file = new File(this.fileName);
        try {
            if (file.exists()) file.delete();

            file.createNewFile();

            printWriter = new PrintWriter(file.getAbsoluteFile());

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void close() {

        printWriter.close();
    }

    public void writeLine(String line) {

        printWriter.print(line + "\n");
    }


}
