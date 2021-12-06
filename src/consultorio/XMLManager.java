/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;


public class XMLManager {

    private boolean exist = false;
    private final File xmlFile;
    private DocumentBuilderFactory factory;
    private DocumentBuilder builder;
    private DOMImplementation implementation;
    private Document document;

    private ArrayList<Paciente> pacientes;
    private ArrayList<Doctor> doctores;
    private ArrayList<Cita> citas;

    public XMLManager() throws IOException {
        pacientes = new ArrayList<>();
        doctores = new ArrayList<>();
        citas = new ArrayList<>();
        xmlFile = new File("database.xml");
        if (!xmlFile.exists()) {
            exist = false;
            xmlFile.createNewFile();
            baseCreate();
        } else {
            try {
                factory = DocumentBuilderFactory.newInstance();
                builder = factory.newDocumentBuilder();

                document = builder.parse(xmlFile);
                Element ePacientes = (Element) document.getDocumentElement().getChildNodes().item(0);
                for (int i = 0; i < ePacientes.getChildNodes().getLength(); i++) {
                    Element paciente = (Element) ePacientes.getChildNodes().item(i);
                    String id = paciente.getChildNodes().item(0).getTextContent();
                    String nombre = paciente.getChildNodes().item(1).getTextContent();
                    pacientes.add(new Paciente(id, nombre));
                }
                Element eDoctores = (Element) document.getDocumentElement().getChildNodes().item(1);
                for (int i = 0; i < eDoctores.getChildNodes().getLength(); i++) {
                    Element doctor = (Element) eDoctores.getChildNodes().item(i);
                    String id = doctor.getChildNodes().item(0).getTextContent();
                    String nombre = doctor.getChildNodes().item(1).getTextContent();
                    String especialidad = doctor.getChildNodes().item(2).getTextContent();
                    doctores.add(new Doctor(id, nombre, especialidad));
                }
                Element eCitas = (Element) document.getDocumentElement().getChildNodes().item(2);
                for (int i = 0; i < eCitas.getChildNodes().getLength(); i++) {
                    Element cita = (Element) eCitas.getChildNodes().item(i);
                    String id = cita.getChildNodes().item(0).getTextContent();
                    String motivo = cita.getChildNodes().item(1).getTextContent();
                    String fechaHora = cita.getChildNodes().item(2).getTextContent();
                    String paciente = cita.getChildNodes().item(3).getTextContent();
                    String doctor = cita.getChildNodes().item(4).getTextContent();
                    citas.add(new Cita(id, motivo, fechaHora, paciente, doctor));
                }
            } catch (Exception ex) {
                
            }
            baseCreate();
        }
    }

    private void writePacientes(ArrayList<Paciente> pacientes) {
        Element pacientesD = (Element) document.getDocumentElement().getChildNodes().item(0);
        pacientes.forEach((t) -> {
            Element paciente = document.createElement("Paciente");
            Element elementId = document.createElement("id");
            Text id = document.createTextNode(t.getId());
            Element elementNombre = document.createElement("nombre");
            Text nombre = document.createTextNode(t.getNombre());
            elementNombre.appendChild(nombre);
            elementId.appendChild(id);
            paciente.appendChild(elementId);
            paciente.appendChild(elementNombre);
            pacientesD.appendChild(paciente);
        });
    }

    private void writeDoctores(ArrayList<Doctor> doctores) {
        Element doctoresD = (Element) document.getDocumentElement().getChildNodes().item(1);
        doctores.forEach((t) -> {
            Element paciente = document.createElement("Doctor");
            Element elementId = document.createElement("id");
            Text id = document.createTextNode(t.getId());
            Element elementNombre = document.createElement("nombre");
            Text nombre = document.createTextNode(t.getNombre());
            Element elementEspecialidad = document.createElement("especialidad");
            Text especialidad = document.createTextNode(t.getEspecialidad());
            elementId.appendChild(id);
            elementNombre.appendChild(nombre);
            elementEspecialidad.appendChild(especialidad);
            paciente.appendChild(elementId);
            paciente.appendChild(elementNombre);
            paciente.appendChild(elementEspecialidad);
            doctoresD.appendChild(paciente);
        });
    }

    private void writeCitas(ArrayList<Cita> citas) {
        Element citasD = (Element) document.getDocumentElement().getChildNodes().item(2);
        citas.forEach((t) -> {
            Element cita = document.createElement("Cita");
            Element elementId = document.createElement("id");
            Text id = document.createTextNode(t.getId());
            Element elementMotivo = document.createElement("motivo");
            Text motivo = document.createTextNode(t.getMotivo());
            Element elementFecha = document.createElement("fechaHora");
            Text fechaHora = document.createTextNode(t.getFechaHora());
            Element elementPaciente = document.createElement("paciente");
            Text paciente = document.createTextNode(t.getPaciente());
            Element elementDoctor = document.createElement("doctor");
            Text doctor = document.createTextNode(t.getDoctor());
            elementId.appendChild(id);
            elementMotivo.appendChild(motivo);
            elementFecha.appendChild(fechaHora);
            elementPaciente.appendChild(paciente);
            elementDoctor.appendChild(doctor);
            cita.appendChild(elementId);
            cita.appendChild(elementMotivo);
            cita.appendChild(elementFecha);
            cita.appendChild(elementPaciente);
            cita.appendChild(elementDoctor);
            citasD.appendChild(cita);
        });
    }

    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public ArrayList<Doctor> getDoctores() {
        return doctores;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void saveChanges(ArrayList<Paciente> pacientes, ArrayList<Doctor> doctores, ArrayList<Cita> citas) {
        baseCreate();
        writePacientes(pacientes);
        writeDoctores(doctores);
        writeCitas(citas);
        try {
            Source DOMSource = new DOMSource(document);
            Result result = new StreamResult(xmlFile);

            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.transform(DOMSource, result);
        } catch (TransformerException ex) {
            Logger.getLogger(XMLManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void baseCreate() {
        try {
            factory = DocumentBuilderFactory.newInstance();
            builder = factory.newDocumentBuilder();
            implementation = builder.getDOMImplementation();

            document = implementation.createDocument(null, "Consultorio", null);
            document.setXmlVersion("1.0");

            Element ePacientes = document.createElement("Pacientes");
            Element eDoctores = document.createElement("Doctores");
            Element eCitas = document.createElement("Citas");

            document.getDocumentElement().appendChild(ePacientes);
            document.getDocumentElement().appendChild(eDoctores);
            document.getDocumentElement().appendChild(eCitas);
        } catch (ParserConfigurationException | DOMException e) {
        }
    }

}
