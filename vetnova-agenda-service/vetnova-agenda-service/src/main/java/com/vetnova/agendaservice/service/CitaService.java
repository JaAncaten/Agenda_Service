package com.vetnova.agendaservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetnova.agendaservice.model.Cita;
import com.vetnova.agendaservice.repository.CitaRepository;

@Service
public class CitaService {

    @Autowired
    private CitaRepository citaRepository;

    public List<Cita> obtenerCitas() {
        return citaRepository.findAll();
    }

    public Cita obtenerCitaPorId(Long id) {
        return citaRepository.findById(id).orElse(null);
    }

    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }

    public Cita actualizarCita(Long id, Cita citaActualizada) {
        Optional<Cita> citaExistente = citaRepository.findById(id);

        if (citaExistente.isPresent()) {
            Cita cita = citaExistente.get();

            cita.setUsuarioId(citaActualizada.getUsuarioId());
            cita.setMascotaId(citaActualizada.getMascotaId());
            cita.setVeterinarioId(citaActualizada.getVeterinarioId());
            cita.setSucursalId(citaActualizada.getSucursalId());
            cita.setFecha(citaActualizada.getFecha());
            cita.setHora(citaActualizada.getHora());
            cita.setMotivo(citaActualizada.getMotivo());
            cita.setEstado(citaActualizada.getEstado());
            cita.setObservacion(citaActualizada.getObservacion());

            return citaRepository.save(cita);
        }

        return null;
    }

    public boolean eliminarCita(Long id) {
        if (citaRepository.existsById(id)) {
            citaRepository.deleteById(id);
            return true;
        }

        return false;
    }
}