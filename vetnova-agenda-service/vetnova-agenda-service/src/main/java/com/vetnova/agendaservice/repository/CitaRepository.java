package com.vetnova.agendaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vetnova.agendaservice.model.Cita;

public interface CitaRepository extends JpaRepository<Cita, Long> {

}