package com.cobis.negocio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Persistencia implements LibroRepository {

    @Override
    public List<Libro> obtener() {
        List<Libro> libros = null;
        Connection con = Conexion.Conectar();
        try {
            String query = "SELECT * FROM libro";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            libros = new ArrayList<Libro>();
            while (rs.next()) {
                Libro libro = new Libro(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getDate(5), rs.getInt(6), rs.getDouble(7));
                libros.add(libro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error al consultar los libros");
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error al cerrar la conexion");
            }
        }
        return libros;
    }

    @Override
    public String crear(Libro libro) {
        String respuesta = "";
        if (!existe(libro.getNombreLibro())) {
            Connection con = Conexion.Conectar();
            String query = "INSERT INTO libro (nombreLibro, descripcion, autor, fechaPublicacion, numeroEjemplares, costo) VALUES(?,?,?,?,?,?)";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, libro.getNombreLibro());
                ps.setString(2, libro.getDescripcion());
                ps.setString(3, libro.getAutor());
                ps.setDate(4, libro.getFechaPublicacion());
                ps.setInt(5, libro.getNumeroEjemplares());
                ps.setDouble(6, libro.getCosto());
                ps.executeUpdate();
                respuesta = "Registro del libro exitoso";
            } catch (SQLException ex) {
                ex.printStackTrace();
                respuesta = "Error, no se pudo registrar el libro";
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Error al cerrar la conexion");
                }
            }
        } else {
            respuesta = "El libro ya existe";
        }
        return respuesta;
    }

    @Override
    public String actualizar(Libro libro) {
        String respuesta = "";
        Connection con = Conexion.Conectar();
        if (!existe(libro.getNombreLibro())) {
            String query = "UPDATE libro SET nombreLibro=?, descripcion=?, autor=?, fechaPublicacion=?, numeroEjemplares=?, costo=? WHERE idLibro=?";
            try {
                PreparedStatement ps = con.prepareStatement(query);
                ps.setString(1, libro.getNombreLibro());
                ps.setString(2, libro.getDescripcion());
                ps.setString(3, libro.getAutor());
                ps.setDate(4, libro.getFechaPublicacion());
                ps.setInt(5, libro.getNumeroEjemplares());
                ps.setDouble(6, libro.getCosto());
                ps.setInt(7, libro.getId());
                ps.executeUpdate();
                respuesta = "Se actualizo la informacion del libro";
            } catch (SQLException ex) {
                ex.printStackTrace();
                respuesta = "Error, no se pudo actualizar el libro";
            } finally {
                try {
                    con.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    System.out.println("Error al cerrar la conexion");
                }
            }
        } else {
            respuesta = "El libro con titulo " + libro.getNombreLibro() + " ya existe";
        }
        return respuesta;
    }

    @Override
    public String borrar(Libro libro) {
        String respuesta = "";
        String query = "DELETE FROM libro WHERE idLibro=?";
        Connection con = Conexion.Conectar();
        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, libro.getId());
            ps.executeUpdate();
            respuesta = "Se elimino el libro correctamente";
        } catch (SQLException ex) {
            ex.printStackTrace();
            respuesta = "Error, no se pudo eliminar el libro";
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error al cerrar la conexion");
            }
        }
        return respuesta;
    }

    private boolean existe(String nombre) {
        boolean existe = false;
        Connection con = Conexion.Conectar();
        try {
            String query = "SELECT * FROM libro WHERE nombreLibro = ?";
            PreparedStatement ps = con.prepareCall(query);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                existe = true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                System.out.println("Error al cerrar la conexion");
            }
        }
        return existe;
    }

}
