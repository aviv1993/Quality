package system;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        try {
            System.out.println(FileSystem.fileStorage.countFreeSpace());
            /*
            FileSystem fs = new FileSystem(5);
            System.out.println(FileSystem.fileStorage.countFreeSpace());*/
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
