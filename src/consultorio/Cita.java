/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package consultorio;


public class Cita {

    private String id, motivo, fechaHora, paciente, doctor;

    public Cita(String id, String motivo, String fechaHora, String paciente, String doctor) {
        this.id = id;
        this.motivo = motivo;
        this.fechaHora = fechaHora;
        this.paciente = paciente;
        this.doctor = doctor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getDoctor() {
        return doctor;
    }

    public void setDoctor(String doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Cita " + id+"\nMotivo: "+motivo+"\tMes:Hora: "+fechaHora+"\tPaciente: "+paciente+"\tDoctor: "+doctor;
    }

}
