package com.dr.file.organizer;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {

	public static void main(String[] args) {

		System.out.println(" _____ _ _         ___                        _              ");
		System.out.println("|  ___(_) | ___   / _ \\ _ __ __ _  __ _ _ __ (_)_______ _ __ ");
		System.out.println("| |_  | | |/ _ \\ | | | | '__/ _` |/ _` | '_ \\| |_  / _ \\ '__|");
		System.out.println("|  _| | | |  __/ | |_| | | | (_| | (_| | | | | |/ /  __/ |   ");
		System.out.println("|_|   |_|_|\\___|  \\___/|_|  \\__, |\\__,_|_| |_|_/___\\___|_|   ");
		System.out.println("                            |___/                            ");
		System.out.println("");
		System.out.println("--------------------------------[ by Davide Ruffolo v1.0 ]---");
		System.out.println("");

		if (args.length < 2) {
			System.out.println("Usage:");
			System.out.println("java -jar fileOrganizer.jar -in=<folder_in> -out=<folder_out>");
			System.out.println("");
			System.out.println("Example:");
			System.out.println("java -jar fileOrganizer.jar -in=\"c:\\myFolder\\in\" -out=\"c:\\myFolder\\out\"");
			return;
		}

		String folderIN = "";
		String folderOUT = "";

		for (String string : args) {
			if(string.contains("-in"))
				folderIN = string.replace("-in=", "");
			else if(string.contains("-out"))
				folderOUT = string.replace("-out=", "");
		}

		if(folderIN.isEmpty() || folderOUT.isEmpty()) {
			System.out.println("Please add 'in' and 'out' parameters.");
			return;
		}

		File _folderIN = new File(folderIN);
		if (_folderIN.exists() && _folderIN.isDirectory()) {
			File[] listOfFiles = _folderIN.listFiles();

			for (File file : listOfFiles) {
				if (file.isFile()) {
					System.out.println("File: " + file.getName());

					try {
						long lastModified = file.lastModified();
						Date date = new Date(lastModified);
						SimpleDateFormat monthFormat = new SimpleDateFormat("MM");
						String mese = monthFormat.format(date);
						SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
						String year = yearFormat.format(date);
						System.out.println("Month: " + mese + " - " + "Year: " + year);

						File yearFolder = new File(folderOUT+"/"+year);
						if(!yearFolder.exists())
							yearFolder.mkdir();

						File monthFolder = new File(folderOUT+"/"+year + "/" + mese);
						if(!monthFolder.exists())
							monthFolder.mkdir();

						File moveFile = new File(monthFolder + "/"+ file.getName());
						file.renameTo(moveFile);

					} catch (Exception e) {
						System.out.println("An error was generated: " + e.getMessage());
					}

					System.out.println("--------------------------------");
				}
			}
		} else {
			System.out.println("The folder does not exist or is not a directory.");
		}

	}

}
