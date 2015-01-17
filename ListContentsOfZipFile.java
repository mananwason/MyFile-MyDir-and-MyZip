package AdtFile;


import java.io.IOException;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ListContentsOfZipFile {
	
	public static void main(String[] args) {
		
		display("E:/ap/Sir Codes/adt2code_2603.zip");
		
	}
	
	public static void display(String path){
		ZipFile zipFile = null;

		try {
			zipFile = new ZipFile(path);

			Enumeration<? extends ZipEntry> e = zipFile.entries();

			while (e.hasMoreElements()) {
				
				ZipEntry entry = e.nextElement();
				String entryName = entry.getName();
				System.out.println("ZIP Entry: " + entryName);

			}

		}
		catch (IOException ioe) {
			System.out.println("Error opening zip file" + ioe);
		}
		 finally {
			 try {
				 if (zipFile!=null) {
					 zipFile.close();
				 }
			 }
			 catch (IOException ioe) {
					System.out.println("Error while closing zip file" + ioe);
			 }
		 }
	}

}