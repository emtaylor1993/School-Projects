/**
 * CLIENT
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class represents a Client that will add files and directories
 *      to the root directory to demonstrate the functionality of the
 *      composite design pattern.
 * 
 * @packages
 *      None
 */

public class Client {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        File file1 = new File("File1.txt");
        File file2 = new File("File2.txt");
        File file3 = new File("File3.txt");

        Directory subDirectory = new Directory("SubDirectory");
        File file4 = new File("File4.txt");
        File file5 = new File("File5.txt");
        File file6 = new File("File6.txt");   
        
        root.add(file1);
        root.add(file2);
        root.add(file3);
        root.add(subDirectory);
        subDirectory.add(file4);
        subDirectory.add(file5);
        subDirectory.add(file6);

        root.ls();
        System.out.println();
        subDirectory.ls();
    }
}
