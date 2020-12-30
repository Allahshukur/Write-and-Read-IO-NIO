package com.company;

import com.company.User.Store;
import com.company.User.Teacher;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws  Exception{

//        write_and_read_with_IO();

//        writeTextIntoFileIO("ALLAH");

//        readTextFromFileIO();

//        deleteFile();

//        writeTextIntoFileNIO("Allah");
//        System.out.println(readTextFromFileNIO());
    }

    public static String readTextFromFileNIO() throws Exception{
        return new String(Files.readAllBytes(Paths.get("Files/texttest.txt")));
    }

    public static void writeTextIntoFileNIO(String text){
        try {
            Files.write(Paths.get("Files/texttest.txt"), text.getBytes());
            System.out.println("Successfully wroted to the file");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void write_and_read_withText_IO(){


    }

    public static void deleteFile(){
        File myObj = new File("Files/test.txt");
        if (myObj.delete()) {
            System.out.println("Deleted the file: " + myObj.getName());
        } else {
            System.out.println("Failed to delete the file.");
        }
    }

    public static void readTextFromFileIO2() throws Exception{
        FileReader fr = new FileReader("Files/textfile.txt");
        BufferedReader br = new BufferedReader(fr);
        try {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
        } finally { // finally ona gore yazilirki eger kod duz isdesede
                    // errorda olsa finally in icerisinde olan kodlar her zaman isleyecek.
            br.close();
        }
    }

    public static void readTextFromFileIO1(){
        try {
            File myObj = new File("Files/textfile.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void writeTextIntoFileIO(String text){
        try {
            FileWriter myWriter = new FileWriter("Files/textfile.txt");
            myWriter.write(text);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void write_and_read_with_IO(){
        Store store = readFromFileIO();
        System.out.println(store.getTeacher().toString());

        Teacher teacher = new Teacher();
        System.out.print("Please enter teacher name = ");
        teacher.setName(new Scanner(System.in).nextLine());
        System.out.print("Please enter teacher surname = ");
        teacher.setSurname(new Scanner(System.in).nextLine());

        store.setTeacher(teacher);
        writeIntoFileIO(store);
    }

    public static void writeIntoFileIO(Store store)  {

        try {
            File file= new File("Files/test.txt");
            FileOutputStream f = new FileOutputStream(file);
            ObjectOutputStream o = new ObjectOutputStream(f);

            // Write objects to file
            o.writeObject(store);

            o.close();
            f.close();
            System.out.println("Successfully write to file");
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }

    public static Store readFromFileIO() {
        try {
            File file = new File("Files/test.txt");
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);

            // Read objects
            Store pr1 = (Store) oi.readObject();
            oi.close();
            fi.close();
            return pr1;
        } catch (Exception ex){
            Store s = new Store();
            s.setTeacher(new Teacher());
//            s.setList(new Student[1000]);
//            s.setListteacher(new Teacher[1000]);
            return s;
        }
    }
}
