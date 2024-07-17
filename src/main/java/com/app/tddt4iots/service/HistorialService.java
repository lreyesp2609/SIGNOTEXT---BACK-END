package com.app.tddt4iots.service;

import org.springframework.stereotype.Service;
import com.app.tddt4iots.entities.*;
import java.util.*;
import java.lang.*;
import java.io.*;

@Service
public interface HistorialService {     
	 public void obtenerTraducciones(); 
 
	 public void agregarTraduccion(); 
 
	 public void eliminarTraduccion(); 
 
	 public void mostrarHistorial(); 
 
    
}
