package util;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class GeneradorReporte {
	
	public static JasperPrint generarReporte(String nombreJasper, 
			JRBeanCollectionDataSource datasource, HashMap<String, Object> parametros) {
		
		JasperPrint jasperPrint = null;
		
		try {
			
			FileInputStream fileInputStream = new FileInputStream(nombreJasper);
			
			BufferedInputStream bufferedInputStream = 
					new BufferedInputStream(fileInputStream);
			
			JasperReport jasperReport = (JasperReport) 
						JRLoader.loadObject(bufferedInputStream);
	
			jasperPrint = JasperFillManager.fillReport(jasperReport, parametros, datasource);
			
			
		} catch (JRException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return jasperPrint;
		
	}

	public static JasperPrint generarReporte(String file, JRBeanCollectionDataSource dataSource, Object parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
