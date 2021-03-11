package com.sekolah.sekolah.repository;

import com.sekolah.sekolah.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SiswaRepository extends JpaRepository<Siswa, String> {
    // list dibawah ini dibuat secara manual dengan mengacu pada attribut pada model
    List<Siswa> findByNama(String nama);
    List<Siswa> findByAlamat(String alamat);

    // tambahan kata containing fungsinya sama seperti keyword LIKE di sql
    List<Siswa> findByNamaContaining(String nama);
    List<Siswa> findByAlamatContaining(String alamat);

    // tambahan kata StartsWith fungsinya untuk mencari kalimat yang awalannya diinputkan oleh user
    List<Siswa> findByNamaStartsWith(String nama);
    List<Siswa> findByAlamatStartsWith(String alamat);

    // tambahan kata EndsWith fungsinya untuk mencari kalimat yang akhirannya diinputkan oleh user
    List<Siswa> findByNamaEndsWith(String nama);
    List<Siswa> findByAlamatEndsWith(String alamat);

    // tambahan kata NotContaining kebalikan dari Containing yang artinya jika diinputkan adalah sebuah
    // kalimat nama maka nama tersebut tidak akan tertampil, yang tertampil hanyalah nama yang tidak mengandung nama
    // yang di inputkan
    List<Siswa> findByNamaNotContaining(String nama);
    List<Siswa> findByAlamatNotContaining(String alamat);

    //

}
