package com.orbis.ventas.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orbis.ventas.data.EditorialData;
import com.orbis.ventas.domain.Editorial;


@Service
public class EditorialBusiness {
	@Autowired 
	private EditorialData editorialData;
	
	public List<Editorial> findAll(){
		return editorialData.findAll();
		}
	
	public Editorial findById(int idEditorial) {
	        return editorialData.findById(idEditorial);
	   }

}
