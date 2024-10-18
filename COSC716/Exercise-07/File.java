/**
 * FILE
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class will implement the AbstractFile interface and act as
 *      the leaf node. It represents individual files and it's ls() method
 *      will print the names of each file.
 * 
 * @packages
 *      None
 */

public class File implements AbstractFile {
    private String name;

    /**
     * Constructor Name: File
     * @param name (String)
     * 
     * Generates a File object.
     */
    public File(String name) {
        this.name = name;
    }

    @Override
    public void ls() {
        System.out.println("File: " + name);
    }
}
