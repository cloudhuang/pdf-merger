package pdf.merger;

import org.apache.pdfbox.pdmodel.PDDocument;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

public class Main {
    private static final FilenameFilter filter = (f, name) -> name.endsWith(".pdf");

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            usage();
            System.exit(1);
        }

        String folderName = args[0];
        String descFile = args[1];

        final PDDocument destDoc = new PDDocument();

        File folder = new File(folderName);
        File[] listOfFiles = folder.listFiles(filter);

        if (listOfFiles != null && listOfFiles.length > 0) {
            PDDocument srcDoc;
            for (File file : listOfFiles) {
                srcDoc = PDDocument.load(file);

                //Instantiating PDFMergerUtility class
                PDFMergerUtility PDFmerger = new PDFMergerUtility();

                //adding the source files
                PDFmerger.appendDocument(destDoc, srcDoc, getFileNameWithoutExt(file.getName()));
                srcDoc.close();
            }

            destDoc.save(new File(descFile));
            System.out.println("Documents merged");
        } else {
            System.out.println("PDF files not found in the directory!");
        }
    }

    private static String getFileNameWithoutExt(String fileName) {
        return fileName.replaceFirst("[.][^.]+$", "");
    }

    /**
     * This will print the usage for this document.
     */
    private static void usage() {
        System.err.println("Usage: java pdf-merger.jar <input-folder> <output-pdf>");
    }
}