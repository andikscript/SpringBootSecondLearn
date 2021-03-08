package com.sekolah.sekolah.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Siswa {
    private String nis;
    private String nama;
    private String alamat;

    @Id
    @Column(name = "nis", nullable = false, length = 10)
    public String getNis() {
        return nis;
    }

    public void setNis(String nis) {
        this.nis = nis;
    }

    @Basic
    @Column(name = "nama", nullable = false, length = 50)
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @Basic
    @Column(name = "alamat", nullable = false, length = 255)
    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Siswa siswa = (Siswa) o;
        return Objects.equals(nis, siswa.nis) &&
                Objects.equals(nama, siswa.nama) &&
                Objects.equals(alamat, siswa.alamat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nis, nama, alamat);
    }
}
