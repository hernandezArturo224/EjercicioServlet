package daos;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

//import log.logs.UsoLogger;
import modelos.*;

public class DepartamentosDAO {
	
	//public static Logger log = UsoLogger.getLogger(Departamentos.class);
	public static List<Departamentos> getAllDepartments(Session s) {
		String hQuery = "from Departamentos";
		List<Departamentos> dpList = s.createQuery(hQuery, Departamentos.class)
				   	   			           .list();
		return dpList;
	}
	
	public static Departamentos getDepartmentFromId(Session s, int id) {
		String hQuery = "from Departamentos d" + " where d.codigo = :id";
		Departamentos dptm = s.createQuery(hQuery,Departamentos.class)
				.setParameter("id", id)
				.setMaxResults(1)
				.uniqueResult();
		
		return dptm;
	}
	
	public static void insertDepartment(Departamentos dptm,Session s) {
		Transaction tx = s.beginTransaction();
		s.save(dptm);
		tx.commit();
		//log.info("Departamento creado");
	}
	
	public static void deleteDepartment(Departamentos dptm,Session s) {
		Transaction tx = s.beginTransaction();
		s.delete(dptm);
		tx.commit();
		//log.info("Departamento eliminado");
	}
	
	public static void updateNameFromId(int id, String nuevoNombre, Session s) {
		 List<Departamentos> dptmList = getAllDepartments(s);
		Transaction tx = s.beginTransaction();
        Departamentos dptm = dptmList.stream().filter(x -> x.getCodigo() == id).findFirst().orElse(null);
        dptm.setNombre(nuevoNombre);
        tx.commit();
        //log.info("Departamento actualizado");
	}
}
