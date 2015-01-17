package AdtFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;


public class MyDir {

	
	public static void main(String[] args) {
		TreeDisplay("C:/Users/manan/Documents/Project 1");
		System.out.println("\n\n\n\n");
		File srcFolder = new File("C:/Users/manan/Documents/assignment1(1)");
    	File destFolder = new File("C:/Users/manan/Desktop");
    	if(!srcFolder.exists()){
 
           System.out.println("Directory does not exist.");
           System.exit(0);
 
        }else{
 
           try{
        	   System.out.println("Start copying directory");
        	copyFolder(srcFolder,destFolder);
           }catch(IOException e){
        	e.printStackTrace();
                System.exit(0);
           }
        }
 
    	System.out.println("Done");
	}
	
	    public static void copyFolder(File src, File dest)
	    	throws IOException{
	 
	    	if(src.isDirectory()){
	    		if(!dest.exists()){
	    		   dest.mkdir();
	    		   System.out.println("Directory copied from " 
	                              + src + "  to " + dest);
	    		}
	 
	    		String files[] = src.list();
	 
	    		for (String file : files) {
	    		   File srcFile = new File(src, file);
	    		   File destFile = new File(dest, file);
	    		   copyFolder(srcFile,destFile);
	    		}
	 
	    	}else{
	    		InputStream in = new FileInputStream(src);
	    	        OutputStream out = new FileOutputStream(dest); 
	 
	    	        byte[] buffer = new byte[1024];
	 
	    	        int length;
	    	        while ((length = in.read(buffer)) > 0){
	    	    	   out.write(buffer, 0, length);
	    	        }
	 
	    	        in.close();
	    	        out.close();
	    	        System.out.println("File copied from " + src + " to " + dest);
	    	}
	    }
	
	public static void TreeDisplay(String path){
		    FileVisitor<Path> fileProcessor = new ProcessFile();
		    try {
				Files.walkFileTree(Paths.get(path), fileProcessor);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		  }

		  private static final class ProcessFile extends SimpleFileVisitor<Path> {
		    @Override public FileVisitResult visitFile(
		      Path aFile, BasicFileAttributes aAttrs
		    ) throws IOException {
		      System.out.println("Processing file:" + aFile);
		      return FileVisitResult.CONTINUE;
		    }
		    
		    @Override  public FileVisitResult preVisitDirectory(
		      Path aDir, BasicFileAttributes aAttrs
		    ) throws IOException {
		      System.out.println("Processing directory:" + aDir);
		      return FileVisitResult.CONTINUE;
		    }
	}
}
