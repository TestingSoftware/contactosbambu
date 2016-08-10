package com.ncubo.contactos.persistencia;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.ncubo.contactos.RegistroPadron;
public class Dao 
{	
	//TODO Una vez insertados los registros verificar si existe antes de insertar de nuevo.
	static Logger log = Logger.getLogger(Dao.class);
	
	public List<String[]> insertar(List <String[]> arrayRegistro) 
	{
		final Configuration configuration = new Configuration().configure();
		
		final StandardServiceRegistryBuilder builder = 
				new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		
		final SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		final Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		
		for(int i = 0; i < arrayRegistro.size(); i += 1)
		{
			RegistroPadron nuevoRegistro = new RegistroPadron();
			nuevoRegistro = llenaRegistro(nuevoRegistro, arrayRegistro.remove(0));
			session.save(nuevoRegistro);
			
			if(i % 20 == 0)
			{
				session.flush();
				session.clear();
			}
		}
		
		transaction.commit();
		session.close();
		sessionFactory.close();
		
		return arrayRegistro;
	}
	
	private RegistroPadron llenaRegistro(RegistroPadron nuevoRegistro, String[] datosPersona)
	{
		nuevoRegistro.setCedula(datosPersona[0]);
		nuevoRegistro.setNombre(datosPersona[5]);
		nuevoRegistro.setApellidos(datosPersona[6] + datosPersona[7]);
		nuevoRegistro.setDireccion_entrega("");
		nuevoRegistro.setCelular("");
		nuevoRegistro.setCreado_por("");
		nuevoRegistro.setEmail("");
		nuevoRegistro.setFecha_borrado(new Date(Calendar.getInstance().getTime().getTime()));
		nuevoRegistro.setFecha_creacion(new Date(Calendar.getInstance().getTime().getTime()));
		nuevoRegistro.setFecha_modificacion(new Date(Calendar.getInstance().getTime().getTime()));
		nuevoRegistro.setId_empresa(0);
		nuevoRegistro.setId_persona(0);
		nuevoRegistro.setLatitud(0.0);
		nuevoRegistro.setLongitud(0.0);
		nuevoRegistro.setTelefono("");
		nuevoRegistro.setUsuario_skype("");
		nuevoRegistro.setModificado_por("");
		nuevoRegistro.setRegistro_borrado(0);
		
		return nuevoRegistro;
	}
}
