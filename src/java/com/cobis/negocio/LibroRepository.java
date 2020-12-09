package com.cobis.negocio;

import java.util.List;

public interface LibroRepository {
    
    List<Libro> obtener();
    String crear(Libro libro);
    String actualizar(Libro libro);
    String borrar(Libro libro);

}