package org.acme;

import org.apache.kafka.common.protocol.types.Field;


public class Plot {
    private Integer id;
    private String nama;
    private String warna;
    private String deskripsi;
    private Double koordinatX;
    private Double koordinatY;



    public Plot(Integer id, String nama, String warna, String deskripsi, Double koordinatX, Double koordinatY) {
        this.id = id;
        this.nama = nama;
        this.warna = warna;
        this.deskripsi = deskripsi;
        this.koordinatX = koordinatX;
        this.koordinatY = koordinatY;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Double getKoordinatX() {
        return koordinatX;
    }

    public void setKoordinatX(Double koordinatX) {
        this.koordinatX = koordinatX;
    }

    public Double getKoordinatY() {
        return koordinatY;
    }

    public void setKoordinatY(Double koordinatY) {
        this.koordinatY = koordinatY;
    }
}
