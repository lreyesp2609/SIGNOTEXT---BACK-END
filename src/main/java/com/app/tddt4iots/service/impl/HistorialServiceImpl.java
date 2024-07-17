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
public class HistorialServiceImpl implements HistorialService {     
    @Autowired
    HistorialRepository historialRepository;
    
	@Override 
	public void obtenerTraducciones() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	} 
	@Override 
	public void agregarTraduccion() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	} 
	@Override 
	public void eliminarTraduccion() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	} 
	@Override 
	public void mostrarHistorial() { 
	 	// Inside this block you can enter your code implementing the business logic you need. 
	} 
    
}
