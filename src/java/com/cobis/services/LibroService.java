package com.cobis.services;

import com.cobis.negocio.Libro;
import com.cobis.negocio.LibroRepository;
import com.cobis.negocio.Persistencia;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("libros")
public class LibroService {

    LibroRepository libroRepository = new Persistencia();

    @GET
    @Path("listarLibros")
    public Response ObtenerLibros() {
        List<Libro> libros = libroRepository.obtener();
        try {
            String json = new Gson().toJson(libros);
            return Response.ok(json, MediaType.APPLICATION_JSON).build();
        } catch (NullPointerException e) {
            return Response.ok("No hay libros registrados").build();
        }
    }

    @POST
    @Path("registrarLibro")
    public Response guardarLibro(String json) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            Libro libro = gson.fromJson(json, Libro.class);
            String respuesta = libroRepository.crear(libro);
            if (respuesta.equals("Registro del libro exitoso")) {
                return Response.ok(respuesta).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @PUT
    @Path("modificarLibro")
    public Response modificarLibro(String json) {
        try {
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd").create();
            Libro libro = gson.fromJson(json, Libro.class);
            String respuesta = libroRepository.actualizar(libro);
            if (respuesta.equals("Se actualizo la informacion del libro")) {
                return Response.ok(respuesta).build();
            } else {
                return Response.status(Response.Status.BAD_REQUEST).build();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

    @DELETE
    @Path("borrarLibro")
    public Response eliminarLibro(@QueryParam("id") int id) {
        Libro libro = new Libro(id);
        String respuesta = libroRepository.borrar(libro);
        if (respuesta.equals("Se elimino el libro correctamente")) {
            return Response.ok(respuesta).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }

}
