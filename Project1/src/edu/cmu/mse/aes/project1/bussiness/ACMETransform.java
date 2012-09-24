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
     * to source.htm.
     */
    public static void main(String[] args) throws Exception {
        if (args.length != 3) {
            System.err.println(
                "Usage: java Transform [xmlfile] [xsltfile]");
            System.exit(1);
        }
        
        String brand = "";
        String model = "";
        
        //System.out.println("Enter a brand: ");
        //Scanner scan = new Scanner(System.in);
        //brand = scan.next();
        //System.out.println("You entered the following brand: "+brand);
        
        //System.out.println("Enter a model: ");
        //model = scan.next();
        model = args[2];
        //System.out.println("You entered the following model: "+model);
        //scan.close();
        
        File xmlFile = new File(args[0]);
        File xsltFile = new File(args[1]);

        File f = new File("C:/Users/DELL/git/Rep-for-Arch-Course/Project1/src/outputdata/source.htm");
        //BufferedWriter bw = new BufferedWriter(new FileWriter(f));
        
        Source xmlSource = new StreamSource(xmlFile);
        Source xsltSource = new StreamSource(xsltFile);

        TransformerFactory transFact =
                TransformerFactory.newInstance();
        Transformer trans = transFact.newTransformer(xsltSource);
        trans.setParameter("modelname", model.toString());

        trans.transform(xmlSource, new StreamResult(new FileOutputStream(f)));
        //trans.transform(xmlSource, new StreamResult(bw));
        //String url = "http://www.google.com";
        java.awt.Desktop.getDesktop().browse(java.net.URI.create("file:///C:/Users/DELL/git/Rep-for-Arch-Course/Project1/src/outputdata/source.htm"));
        
        System.out.println("Processing done!!");
    }
}