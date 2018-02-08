
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SessionFactoryManager {
	
	//creating factory for getting sessions
	private static SessionFactoryManager instance;
	
	private  Configuration config = new Configuration().configure("hibernate.cfg.xml");
	private  StandardServiceRegistry registry;

	private SessionFactory sessionfactory;

	
	private SessionFactoryManager() {
		createSessionFactory();
	}
		//singleton
 public static SessionFactoryManager getinstance() {
	if(instance==null) instance= new SessionFactoryManager(); 
	 return instance;
 }
 
 //get Session Factory
 public SessionFactory getSessionFactory() {
	 return sessionfactory;
 }
 
 //open session
 public Session getSession() {
	 return sessionfactory.openSession();
 }
 
 //adds the classes to the hibernate configuration
 private void addClasses() {
	 config.addAnnotatedClass(Term.class);
 }
 
 //creates the Session Factory according to configuration
 private void createSessionFactory() {
	 addClasses();
	 registry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
		        .build();
	 sessionfactory= config.buildSessionFactory(registry);
	 
 }
 
 //close the session
 public void closeSession(Session session) {
	 session.close();
 }
}
