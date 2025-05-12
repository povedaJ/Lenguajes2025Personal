package com.orbis.ventas.data;

import org.springframework.jdbc.core.ResultSetExtractor;
import com.orbis.ventas.domain.Libro;
import com.orbis.ventas.domain.Editorial;
import com.orbis.ventas.domain.Autor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class LibroExtractor implements ResultSetExtractor<List<Libro>> {

    @Override
    public List<Libro> extractData(ResultSet rs) throws SQLException {
        Map<Integer, Libro> libroMap = new HashMap<>();

        while (rs.next()) {
            int idLibro = rs.getInt("id_libro");
            Libro libro = libroMap.get(idLibro);

            if (libro == null) {
                libro = new Libro();
                libro.setIdLibro(idLibro);
                libro.setTitulo(rs.getString("titulo"));
                libro.setAno(rs.getInt("ano"));
                libro.setPrecio(rs.getFloat("precio"));

                Editorial editorial = new Editorial();
                editorial.setIdEditorial(rs.getInt("id_editorial"));
                editorial.setNombre(rs.getString("nombre_editorial"));
                libro.setEditorial(editorial);

                libroMap.put(idLibro, libro);
            }

            int idAutor = rs.getInt("id_autor");
            if (idAutor > 0) {
                Autor autor = new Autor();
                autor.setIdAutor(idAutor);
                autor.setNombreAutor(rs.getString("nombre_autor"));
                autor.setApellidosAutor(rs.getString("apellidos_autor"));

                libro.getAutores().add(autor);
            }
        }

        return new ArrayList<>(libroMap.values());
    }
}
