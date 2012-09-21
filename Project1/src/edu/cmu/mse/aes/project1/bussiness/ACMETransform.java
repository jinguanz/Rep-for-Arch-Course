package edu.cmu.mse.aes.project1.bussiness;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.Scanner;

public class ACMETransform {

    /**
     * Performs an XSLT transformation, sending the results
     * to System.out.
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println(
                "Usage: java Transform [xmlfile] [xsltfile]");
            System.exit(1);
        }

        System.out.println("Enter a brand.");
        Scanner scan = new Scanner(System.in);
        String choice = scan.next();
        System.out.println("User entered the following choice: "+choice);
        scan.close();
        File xmlFile = new File(args[0]);
        File xsltFile = new File(args[1]);

        File f = new File("C:/Users/DELL/git/Rep-for-Arch-Course/Project1/src/outputdata/source.htm");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        
        Source xmlSource = new StreamSource(xmlFile);
        Source xsltSource = new StreamSource(xsltFile);

        TransformerFactory transFact =
                TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);

        trans.transform(xmlSource, new StreamResult(new FileOutputStream(f)));
        //trans.transform(xmlSource, new StreamResult(bw));
        //String url = "http://www.google.com";
        java.awt.Desktop.getDesktop().browse(java.net.URI.create("file:///C:/Users/DELL/git/Rep-for-Arch-Course/Project1/src/outputdata/source.htm"));
        
        System.out.println("Processing done!!");
    }
}