/**
 * DIRECTORY
 * 
 * @author Emmanuel Taylor
 * @author Leo Tangban
 * @author Vincent Gruse
 * 
 * @description
 *      This class implements the AbstractFile interface and will act as
 *      the composite class. This class holds both Files and Directories.
 *      It's ls() method goes through each File/Directory and prints their
 *      contents.
 * 
 * @packages
 *      Java Utilities (ArrayList)
 */

import java.util.ArrayList;

public class Directory implements AbstractFile {
    private String name;
    private ArrayList<AbstractFile> includedFiles = new ArrayList<>();

    /**
     * Constructor Name: Directory
     * @param name (String)
     * 
     * Generates a Directory object.
     */
    public Directory(String name) {
        this.name = name;
    }

    /**
     * Functoin Name: add
     * @param file (AbstractFile)
     * 
     * Adds files and directories to a directory.
     */
    public void add(AbstractFile file) {
        includedFiles.add(file);
    }

    @Override
    public void ls() {
        System.out.println("Directory: " + name);
        for (AbstractFile file : includedFiles) {
            file.ls();
        }
    }
}
