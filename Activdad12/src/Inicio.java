import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inicio extends JFrame{
    private JTextField txtnombre;
    private JPanel panel1;
    private JTextField txtnumero;
    private JButton mostrar;
    private JMenuBar menuBar;
    private JMenu Opciones;
    private JButton agregarContacto;
    private JButton borrar;
    private JList lista;
    private JButton guardar;
    private JButton cargar;
    DefaultListModel modelo=new DefaultListModel();
    AddressBook ad=new AddressBook();
    public Inicio(){
        super("Actividad 12 JAVA");
        setContentPane(panel1);
        lista.setModel(modelo);
        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    mostrar();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        agregarContacto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    create();
                } catch (Exception ex) {
                    try {
                        delete();
                    } catch (Exception exc) {
                        exc.printStackTrace();
                    }
                }
            }
        });
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    delete();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
     

    }

    public void create() throws Exception {
        String numero=txtnumero.getText();
        String nombre=txtnombre.getText();
        ad.ldapContent.put(numero,nombre);
        ad.save();
        mostrar();

    }
    public void mostrar() throws Exception {
        ad.load();
        modelo.removeAllElements();
            ad.ldapContent.forEach((k,v) -> modelo.addElement(k +": "+ v));
            lista.setModel(modelo);
       // ad.save();
    }
    public void delete() throws Exception {
        String numero2=txtnumero.getText();
        ad.ldapContent.remove(numero2);
        ad.save();
        mostrar();
    }
}
