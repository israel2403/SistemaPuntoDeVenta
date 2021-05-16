/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

/**
 *
 * @author isra
 */
public class TReportes_clientes {

    public TReportes_clientes() {
    }

    private int IdReporte;
    private double DeudaActual;
    private String FechaDeuda;
    private double UltimoPago;
    private String FechaPago;
    private String Ticket;
    private int IdCliente;

    public int getIdReporte() {
        return IdReporte;
    }

    public void setIdReporte(int IdReporte) {
        this.IdReporte = IdReporte;
    }

    public double getDeudaActual() {
        return DeudaActual;
    }

    public void setDeudaActual(double DeudaActual) {
        this.DeudaActual = DeudaActual;
    }

    public String getFechaDeuda() {
        return FechaDeuda;
    }

    public void setFechaDeuda(String FechaDeuda) {
        this.FechaDeuda = FechaDeuda;
    }

    public double getUltimoPago() {
        return UltimoPago;
    }

    public void setUltimoPago(double UltimoPago) {
        this.UltimoPago = UltimoPago;
    }

    public String getFechaPago() {
        return FechaPago;
    }

    public void setFechaPago(String FechaPago) {
        this.FechaPago = FechaPago;
    }

    public String getTicket() {
        return Ticket;
    }

    public void setTicket(String Ticket) {
        this.Ticket = Ticket;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

}
