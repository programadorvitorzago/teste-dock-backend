package com.example.DockApi.Repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DockApi.Repositorio.Objeto.Terminal;

public interface RepositorioDockApi  extends JpaRepository<Terminal, Integer> {

}
