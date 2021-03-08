package com.sekolah.sekolah.repository;

import com.sekolah.sekolah.model.Siswa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiswaRepository extends JpaRepository<Siswa, String> {
    List<Siswa> findByNama(String nama);
    List<Siswa> findByAlamat(String alamat);
}
