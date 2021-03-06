package com.TpFinal.services;

import com.TpFinal.dto.EstadoRegistro;
import com.TpFinal.dto.notificacion.Notificacion;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class NotificadorConcreto implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
			JobDataMap dataMap = context.getJobDetail().getJobDataMap();
			if(dataMap.size() != 0){
				String mensaje = dataMap.getString("mensaje");
				String titulo = dataMap.getString("titulo");
				String encabezado=dataMap.getString("encabezado");
				
				if(titulo != null) {
					System.out.println("Soy una notificacion");
					System.out.println("--------------------");
					System.out.println(titulo);
				}else if(encabezado!=null) {
					System.out.println("Soy un mail");
					System.out.println("-----------");
					System.out.println(encabezado);
				}
				
				System.out.println("-------");
				System.out.println(mensaje);
				System.out.println(" ");
				

			}else{
				System.out.println("algo salio mal");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
