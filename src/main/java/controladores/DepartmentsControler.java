package controladores;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;

import daos.DepartamentosDAO;
//import daos.EmpleadoDAO;
//import log.logs.UsoLogger;
import modelos.*;

public class DepartmentsControler {
	
	//public static Logger log = UsoLogger.getLogger(DepartmentsControler.class);

	public static void showAllDepartments(Session s) {
		List<Departamentos> dptm = DepartamentosDAO.getAllDepartments(s);
		Iterator it = dptm.iterator();
		while(it.hasNext()) {
			System.out.println(it.next().toString());
		}
		//log.info("Generados todos los departamentos...");
	}
	
}
