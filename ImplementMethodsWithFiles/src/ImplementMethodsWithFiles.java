import java.io.*;

public class ImplementMethodsWithFiles {
    //creat new file
    public static void creatNewFile(File file){
        try {
            if(file.createNewFile()){
                System.out.println("File is created!");
            }
            else{
                System.out.println("File already exists!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //save file
    public static void savefile(){
    }
    //write data to file
    public static void writeToFile(File file,String content){
        try {
            FileWriter fileWriter= new FileWriter(file.getAbsolutePath(), true);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Read file
    public static void readFile(File file)  {
        try {
            FileReader fileReader= new FileReader(file.getAbsolutePath());
            int i;
            while ((i=fileReader.read())!=-1){
                System.out.print((char) i);
            }
            fileReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //Get the file path
    public static void getTheFilePath(File file){
        System.out.println(file.getAbsolutePath());
    }
    //Delete file
    public static void deleteFile(File file){
        if(file.delete()){
            System.out.println("Delete file success!");
        }
        else{
            System.out.println("Delete file failed!");
        }
    }
    //Creat folder
    public static void creatFolder(String folderPath){
        File file= new File(folderPath);
        if(!file.exists()){
            if(file.mkdir()){
                System.out.println("Folder is created!");
            }
            else{
                System.out.println("Failed to creat folder!");
            }
        }
        else{
            System.out.println("Folder already exists!");
        }
    }

    public static void main(String[] args) {
        File file= new File("D:\\text.txt");
        System.out.println("Creat file test.txt in D drive:");
        creatNewFile(file);
        String content="XIn chàoo ";
        System.out.println("Write data to file: "+content);
        writeToFile(file,content);
        System.out.print("Read data from file text.txt:");
        readFile(file);
        System.out.println("\nGet the file path of text.txt:");
        getTheFilePath(file);
        System.out.println("Delete file");
        deleteFile(file);
        System.out.println("Creat NewFolder folder in D driver: ");
        String path="D:\\NewFolder";
        creatFolder(path);
    }
}
