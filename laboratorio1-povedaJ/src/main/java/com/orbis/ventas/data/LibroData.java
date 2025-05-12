package com.orbis.ventas.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.orbis.ventas.domain.Libro;
import java.util.List;

@Repository
public class LibroData {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings("deprecation")
    public List<Libro> findByEditorial(int idEditorial) {
        String sql = "SELECT l.id_libro, l.titulo, l.ano, l.precio, " +
                     "e.id_editorial, e.nombre AS nombre_editorial, " +
                     "a.id_autor, a.nombre_autor AS nombre_autor, a.apellidos_autor AS apellidos_autor " +
                     "FROM Libro l " +
                     "JOIN Editorial e ON l.id_editorial = e.id_editorial " +
                     "LEFT JOIN Libro_Autor la ON l.id_libro = la.id_libro " +
                     "LEFT JOIN Autor a ON la.id_autor = a.id_autor " +
                     "WHERE l.id_editorial = ?";

        return jdbcTemplate.query(sql, new LibroExtractor(), idEditorial);
    }
}

