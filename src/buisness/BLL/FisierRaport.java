package buisness.BLL;

import java.io.*;
import java.util.List;

public class FisierRaport {
    private static int i = 0;

    public void genereazaFactura(List<String> lista) {

    try {
        PrintWriter writer = new PrintWriter("raport.txt", "UTF-8");
        for(String s:lista){
        writer.println(s);}
        writer.close();
    }
    catch (Exception e){

        }
    }

}
