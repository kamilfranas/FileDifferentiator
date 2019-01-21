package main.files;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileReader {
    private RandomAccessFile randomAccessFile;
    private int bytesToRead;
    private StringBuilder stringBuilder;

    public FileReader(File file, int bytesToRead){
        try {
            randomAccessFile = new RandomAccessFile(file, "r");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }
        this.bytesToRead = bytesToRead;
    }

    public String readFirstBytes()  {
        stringBuilder = new StringBuilder();
        for(int i = 0; i < bytesToRead; i++){
            try {
                stringBuilder.append(String.format("%X",randomAccessFile.readByte()));
            } catch (IOException e) {
                System.out.println("to small files");
            }
        }
        return stringBuilder.toString();
    }

    public String readLastBytes() {
        stringBuilder = new StringBuilder();
        try {
            randomAccessFile.seek(randomAccessFile.length() - bytesToRead);
        } catch (IOException e) {
            System.out.println("random access files is null");
        }
        for(int i = 0; i < bytesToRead; i++){
            try {
                stringBuilder.append(String.format("%X",randomAccessFile.readByte()));
            } catch (IOException e) {
                System.out.println("to small files");
            }
        }
        try {
            randomAccessFile.close();
        } catch (IOException e) {
            System.out.println("random access files is null");
        }
        return stringBuilder.toString();


    }

}
