package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public class Controller {
    private static final String PATH = System.getProperty("user.home")
        + File.separator + "output.txt";
    private File currentFile = new File(PATH);

    //Class contructor
    public Controller() { 
    }

    /**
     * @param f is the new File
     */
    public void setCurrentFile(final File f) {
        this.currentFile = f;
    }

    /**
     * @return the current File
     */
    public File getCurrentFile() {
        return this.currentFile;
    }

    /**
     * @return the path of the current file
     */
    public String getCurrentFilePath() {
        return this.currentFile.getPath();
    }

    /**
     * @param text is the text to add in the file
     * @return true if we write the text false if it cacth an {@IOExeption}
     */
    public boolean writeOnTheFile(final String text) {
        try (PrintStream ps = new PrintStream(this.currentFile)) {
            ps.print(text);
            return true;
        } catch (final IOException e) {
            return false;
        }
    }
}
