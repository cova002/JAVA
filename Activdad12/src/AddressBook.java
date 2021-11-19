import javax.swing.*;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.StringTokenizer;

public class AddressBook extends Exception{
    static Map<String, String> ldapContent = new HashMap<String, String>();
    private boolean limpiar;
    static Properties properties = new Properties();
    private static final String CSVFILEPATH="./src/contactos.txt";
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame= new Inicio();
                frame.setSize(650,400);
                frame.setVisible(true);
            }
        });
        load();
    }

    public static void load() throws Exception{
        //properties.load(new FileInputStream(CSVFILEPATH));
        //for (String key : properties.stringPropertyNames()) {
        //    ldapContent.put(key, properties.get(key).toString());
       // }
        FileReader reader = new FileReader(CSVFILEPATH);
        BufferedReader br = new BufferedReader(reader);

        boolean validar = true;

        while (validar) {
            String archivo = br.readLine();
            if (archivo != null) {
                StringTokenizer delim = new StringTokenizer(archivo, ",");
                String numero = delim.nextToken();
                String nombre = delim.nextToken();
                ldapContent.put(numero, nombre);
            } else {
                br.close();
                reader.close();
                validar = false;
            }
        }

    }

    public void save2(String numero, String nombre, boolean limpiar) throws Exception{
       // for (Map.Entry<String,String> entry : ldapContent.entrySet()) {
         //   properties.put(entry.getKey(), entry.getValue());
        //}
       // properties.store(new FileOutputStream(CSVFILEPATH), null);
        try (FileWriter fw = new FileWriter(CSVFILEPATH, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter pw = new PrintWriter(bw)) {
            if (limpiar) {
                this.limpiar = false;
                PrintWriter pw2 = new PrintWriter(CSVFILEPATH);
                pw2.print("");
            }
            pw.println(numero + ", " + nombre);
            pw.close();
            bw.close();
            fw.close();
        }
    }

    public void save() {
        limpiar = true;
        ldapContent.forEach((i, y) -> {
            try {
                save2(i, y, limpiar);
            }  catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
