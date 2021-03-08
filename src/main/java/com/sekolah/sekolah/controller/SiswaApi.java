package com.sekolah.sekolah.controller;

import com.sekolah.sekolah.exception.ResourceNotFoundException;
import com.sekolah.sekolah.model.Siswa;
import com.sekolah.sekolah.repository.SiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class SiswaApi {

    @Autowired
    private SiswaRepository siswaRepository;

    @GetMapping("/siswa")
    public List<Siswa> getAll() {
        return siswaRepository.findAll();
    }

    @GetMapping("/siswa/{nis}")
    public Siswa getSiswa(@PathVariable(value = "nis") String nis) throws ResourceNotFoundException {
        return siswaRepository.findById(nis).orElseThrow(() -> new ResourceNotFoundException("Siswa Not Found"));
    }

    // mencari data berdasarkan nama
    @GetMapping("/siswa/nama/{nama}")
    public List<Siswa> getSiswaByNama(@PathVariable(value = "nama") String nama) {
        return siswaRepository.findByNama(nama);
    }

    // mencari data berdasarkan alamat
    @GetMapping("/siswa/alamat/{alamat}")
    public List<Siswa> getSiswaByAlamat(@PathVariable(value = "alamat") String alamat) {
        return siswaRepository.findByAlamat(alamat);
    }

    // menambahkan 1 item
    @PostMapping("/siswa")
    public Siswa createSiswa(@RequestBody Siswa siswa) {
        return siswaRepository.save(siswa);
    }

    // menambahkan item lebih dari 1 dengan model dari json berbentuk array [{}]
    @PostMapping("/siswa/all")
    public List<Siswa> createAllSiswa(@RequestBody List<Siswa> siswa) {
        return siswaRepository.saveAll(siswa);
    }

    @PutMapping("/siswa/{nis}")
    public Siswa updateSiswa(@PathVariable(value = "nis") String nis, @RequestBody Siswa siswa) {
        Optional<Siswa> s = siswaRepository.findById(nis);
        Siswa t = s.get();
        t.setNama(siswa.getNama());
        t.setAlamat(siswa.getAlamat());
        return siswaRepository.save(t);
    }

    // menghapus satu item
    @DeleteMapping("/siswa/{nis}")
    public Optional<Siswa> deleteSiswa(@PathVariable(value = "nis") String nis) {
        Optional<Siswa> siswa = siswaRepository.findById(nis);
        siswaRepository.deleteById(nis);
        return siswa;
    }

    // menghapus keseluruhan item
    @DeleteMapping("/siswa/all")
    public void deleteAll() {
        siswaRepository.deleteAll();
    }
}
