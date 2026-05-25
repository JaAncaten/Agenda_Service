package com.vetnova.agendaservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.vetnova.agendaservice.model.Cita;
import com.vetnova.agendaservice.service.CitaService;

@RestController
@RequestMapping("/api/citas")
public class CitaController {

    @Autowired
    private CitaService citaService;

    @GetMapping
    public List<Cita> obtenerCitas() {
        return citaService.obtenerCitas();
    }

    @GetMapping("/{id}")
    public Cita obtenerCitaPorId(@PathVariable Long id) {
        return citaService.obtenerCitaPorId(id);
    }

    @PostMapping
    public Cita guardarCita(@RequestBody Cita cita) {
        return citaService.guardarCita(cita);
    }

    @PutMapping("/{id}")
    public Cita actualizarCita(@PathVariable Long id, @RequestBody Cita cita) {
        return citaService.actualizarCita(id, cita);
    }

    @DeleteMapping("/{id}")
    public String eliminarCita(@PathVariable Long id) {
        boolean eliminado = citaService.eliminarCita(id);

        if (eliminado) {
            return "Cita eliminada correctamente";
        }

        return "Cita no encontrada";
    }
}