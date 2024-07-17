package com.app.tddt4iots.service;

import org.springframework.stereotype.Service;
import com.app.tddt4iots.entities.*;
import java.util.*;
import java.lang.*;
import java.io.*;

@Service
public interface SistemaService {     
	 public Boolean verificarEstado(); 
 
	 public Gestos capturarGestos(); 
 
	 public Traduccion procesarGestos(); 
 
	 public Boolean detectarActualizacion(); 
 
	 public Boolean descargarActualizacion(); 
 
	 public Boolean verificarIntegridad(); 
 
	 public void actualizarDiccionario(); 
 
	 public void notificarActualizacion(); 
 
    
}
