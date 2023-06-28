package pojo;
import java.io.*;
import java.util.Scanner;


public class FileReader1 {


    public FileReader1() throws FileNotFoundException {
    }

    public static void main(String[] a) throws IOException {
        //first approch
//        FileReader reader = new FileReader("C:/Users/shubham/IdeaProjects/ActitimeBDD/src/test/resources/Project.json");
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        String file;
//
//        while ((file = bufferedReader.readLine()) != null) {
//            System.out.println(file);
//        }
//        bufferedReader.close();


        //Second approch
        File file1 = new File("C:/Users/shubham/IdeaProjects/ActitimeBDD/src/test/resources/Project.json");

        Scanner sc = new Scanner(file1);
//        while(sc.hasNext()){
//            System.out.println(sc.next());
//        }
        sc.useDelimiter("//z");
        System.out.println(sc.next());

    }

}