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




public class MyFile {
	private static final String Name = "ab.txt.txt";
	@SuppressWarnings("unused")
	public MyFile(String string) {
	String name;
	String path;
		

	}

	public static void copy()throws IOException {
		//Files.copy(source.toPath(), Destination.toPath());
		MyFile src = new MyFile( "a.txt");
		MyFile dest = new MyFile("C:/Users/manan/Desktop/b.txt");
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			/*ublic static void main(String[] args)
		    {	
		 
		    	InputStream inStream = null;
			OutputStream outStream = null;
		 
		    	try{
		 
		    	    MyFile afile =new MyFile("Afile.txt");
		    	    MyFile bfile =new MyFile("Bfile.txt");
		 
		    	    inStream = new FileInputStream(afile);
		    	    outStream = new FileOutputStream(bfile);
		 
		    	    byte[] buffer = new byte[1024];*/
			File afile = new File("a.txt");
			File bfile = new File("C:/Users/manan/Desktop/b.txt");
			inStream = new FileInputStream(afile);
			outStream = new FileOutputStream(bfile);

			byte[] buffer = new byte[1024];
			System.out.println(src.toString());
			System.out.println(dest.toString());

			int length;
			while ((length = inStream.read(buffer)) > 0) {
				outStream.write(buffer, 0, length);
			}
			inStream.close();
			outStream.close();
			System.out.println("\n\n\n\n\n\nFile is copied");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws IOException {
		
		
		
		
		copy();
		Search("E:/dm/");
		
		
		
	}


	public static void Search(String path) {
		FileVisitor<Path> fileProcessor = new ProcessFile();
		try {
			Files.walkFileTree(Paths.get(path), fileProcessor);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static final class ProcessFile extends SimpleFileVisitor<Path> {

		@Override
		public FileVisitResult visitFile(Path aFile, BasicFileAttributes aAttrs)
				throws IOException {
			String f = aFile.getFileName().toString();
			if (f.equals(Name)) {	
				System.out.println(f +"  file found ");
				System.exit(0);
			}
			System.out.println("Processing file:" + aFile);
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult preVisitDirectory(Path aDir,
				BasicFileAttributes aAttrs) throws IOException {
			System.out.println("Processing directory:" + aDir);
			return FileVisitResult.CONTINUE;
		}
	}
}

