package com.orbis.ventas.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

import com.orbis.ventas.domain.Editorial;


public class EditorialExtractor implements RowMapper<Editorial> {
	 @Override
	    public Editorial mapRow(ResultSet rs, int rowNum) throws SQLException {
	        Editorial editorial = new Editorial();
	        editorial.setIdEditorial(rs.getInt("id_editorial"));
	        editorial.setNombre(rs.getString("nombre"));
	        editorial.setDireccion(rs.getString("direccion"));
	        editorial.setTelefono(rs.getString("telefono"));
	        return editorial;
	    }
    }


