package com.app.tddt4iots.service.impl;

import com.app.tddt4iots.service.*;
import com.app.tddt4iots.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.tddt4iots.entities.*;
import java.util.*;
import java.lang.*;
import java.io.*;

@Service
public class SistemaServiceImpl implements SistemaService {     
    @Autowired
    SistemaRepository sistemaRepository;
    
	@Override 
	public Boolean verificarEstado() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	 	Boolean response = null; 
	 	return response; 
	 } 
	@Override 
	public Gestos capturarGestos() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	 	Gestos response = null; 
	 	return response; 
	 } 
	@Override 
	public Traduccion procesarGestos() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	 	Traduccion response = null; 
	 	return response; 
	 } 
	@Override 
	public Boolean detectarActualizacion() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	 	Boolean response = null; 
	 	return response; 
	 } 
	@Override 
	public Boolean descargarActualizacion() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	 	Boolean response = null; 
	 	return response; 
	 } 
	@Override 
	public Boolean verificarIntegridad() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	 	Boolean response = null; 
	 	return response; 
	 } 
	@Override 
	public void actualizarDiccionario() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	} 
	@Override 
	public void notificarActualizacion() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	} 
    
}
