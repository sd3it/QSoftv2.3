package ihm;

import java.io.File;

public class Copy {

	public Copy(){}

	//Methode permettant la copie d'un fichier
	public static File copyfile( File source, File destination ){   
		// Declaration des flux 
		java.io.FileInputStream sourceFile=null; 
		java.io.FileOutputStream destinationFile=null; 
		
		try { 
			// Création du fichier : 
			destination.createNewFile(); 
			
			// Ouverture des flux 
			sourceFile = new java.io.FileInputStream(source); 
			destinationFile = new java.io.FileOutputStream(destination); 

			// Lecture par segment de 0.5Mo  
			byte buffer[]=new byte[512*1024]; 
			int nbLecture;
			
			while( (nbLecture = sourceFile.read(buffer)) != -1 ) { 
				destinationFile.write(buffer, 0, nbLecture); 
			} 
		} 
		catch(java.io.FileNotFoundException f) {} 
		
		catch(java.io.IOException e) {} 
		
		finally { 
			// Quoi qu'il arrive, on ferme les flux 
			try { 
				sourceFile.close(); 
			} 
			catch(Exception e) {} 
			
			try { 
				destinationFile.close(); 
			} 
			catch(Exception e) {} 
		}  
		return( destination ); 
	} 
}