package com.orbis.ventas.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.ventas.data.LibroData;
import com.orbis.ventas.domain.Libro;

import java.util.List;

@Service
public class LibroBusiness {

    @Autowired
    private LibroData libroData;

    public List<Libro> findByEditorial(int idEditorial) {
        return libroData.findByEditorial(idEditorial);
    }
	
}
