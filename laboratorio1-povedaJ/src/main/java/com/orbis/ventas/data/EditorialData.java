package com.orbis.ventas.data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.orbis.ventas.domain.Editorial;

@Repository
public class EditorialData {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Transactional
    public void save(Editorial editorial) throws SQLException {
        SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withCatalogName("dbo")
                .withProcedureName("InsertEditorial").withoutProcedureColumnMetaDataAccess()
                .declareParameters(new SqlOutParameter("@id_editorial", Types.INTEGER))
                .declareParameters(new SqlParameter("@nombre", Types.VARCHAR))
                .declareParameters(new SqlParameter("@direccion", Types.VARCHAR))
                .declareParameters(new SqlParameter("@telefono", Types.VARCHAR));
        
        Map<String, Object> outParameters = simpleJdbcCall.execute(
                editorial.getNombre(), editorial.getDireccion(), editorial.getTelefono());
        
        editorial.setIdEditorial(Integer.parseInt(outParameters.get("@id_editorial").toString()));
    }
    
    public List<Editorial> findAll() {
        String sqlSelect = "SELECT id_editorial, nombre, direccion, telefono FROM Editorial";
        return jdbcTemplate.query(sqlSelect, new EditorialExtractor());
    }
    
    public Editorial findById(int id) {
        String sqlSelect = "SELECT id_editorial, nombre, direccion, telefono FROM Editorial WHERE id_editorial = ?";
        List<Editorial> results = jdbcTemplate.query(sqlSelect, new EditorialRowMapper(), id);
        return DataAccessUtils.singleResult(results);
    }

    private static final class EditorialRowMapper implements RowMapper<Editorial> {
        @Override
        public Editorial mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Editorial(
                    rs.getInt("id_editorial"),
                    rs.getString("nombre"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
            );
        }

		
    }
}

 

