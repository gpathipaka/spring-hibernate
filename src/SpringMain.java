import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.java.core.NonSpringClass;
import com.java.hibernate.dao.Address;
import com.java.hibernate.dao.Course;
import com.java.hibernate.dao.Department;
import com.java.hibernate.dao.Employee;
import com.java.hibernate.dao.Functions;
import com.java.hibernate.dao.FunctionsSubproducts;
import com.java.hibernate.dao.Student;
import com.java.hibernate.dao.Subproducts;
import com.java.hibernate.dao.User;




public class SpringMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		HibernateTemplate template = (HibernateTemplate) context
				.getBean("hibernateTemplate123");

		SpringMain main = new SpringMain();
		main.nonBeanInjection();

		
		
		
		NonSpringClass nonSpring = new NonSpringClass();
		String result = nonSpring.getStringFromSecurityMEthods();
		System.out.println("Message is " + result);
		
		
		
		
		
		System.out.println("Done !!");
	//	UserService service = ServiceLocator.getInstance().getUserService();
	//	service.saveUser();
		
	//	main.doDepartment(template);
		
		//main.deTest(template);
		//main.doJoin(template);
		
		//main.oneToOne(template);
		
		//SessionFactory factory = context.getBean("mySessionFactory");
		
		//main.functions_subproducts(template, context);

	//	List<Functions> functions = main.getFunctions(template);
	//	List<Functions> fList = main.getFunctionsBySubproduct(template, functions);
	
		//List<Functions> fList = main.getFunctions(template);
	
	
	/*
	 * Spring Security
	 * 
	 * 
	 * */
	
	}
	
	private void nonBeanInjection() {
		
	}
	
	
	private void oneToOne(HibernateTemplate template){
		
		template.execute(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
			
				
				Address address = new Address();
				address.setLine1("1701 E 12th Apt 410");
				address.setCity("Cleveland");
				address.setState("OH");
				
				User user = new User();
				user.setFirstName("Samatha");
				user.setLastName("Pathipaka");
				
				user.setAddress(address);
				address.setUser(user);
				
				
				
				Address address1 = new Address();
				address1.setLine1("1701 E 12th");
				address1.setCity("Cleveland");
				address1.setState("OH");
				
				User user1 = new User();
				user1.setFirstName("Gangadhar");
				user1.setLastName("Pathipaka");
				
				user1.setAddress(address1);
				address1.setUser(user1);
				
				session.save(user);
				session.save(user1);
				
				return null;
			}
		});
		
		System.out.println("one to one done.........");
	}
	
	
	private List<Functions> getFunctionsBySubproduct(HibernateTemplate template, List<Functions> functions){
		
		List<Functions> list =	template.executeFind(new HibernateCallback() {
				@Override
				public Object doInHibernate(Session session) throws HibernateException,
						SQLException {
					//Subproducts s = new Subproducts();
					//s.setId(new Long(2));
					//s.setSubProductCode("LB");
					//Query q = session.createQuery("select distinct f from Functions f join f.fs fs where fs.sub_pd_id = 2 ");
					//Query q = session.createQuery("select distinct f from FunctionsSubproducts fs join fs.function f where f.id = fs.id");
					//Query q = session.createQuery("select f from FunctionsSubproducts fs join fs.function f where fs.id.subProductId = 2 and fs.id.code='PRT'");
					
					
					Query q = session.createQuery("select distinct fs from FunctionsSubproducts fs");
					return q.list();
				}
			});
			
		System.out.println("List Size " + list.size());
		
		
		Map map = new HashMap();
		for(Iterator i = list.iterator(); i.hasNext();){
			FunctionsSubproducts fs = (FunctionsSubproducts) i.next();
			String key = fs.getSubProducts().getId()+"|"+fs.getCode();
			List lst = (List) map.get(key);
			if(lst==null){
				lst = new ArrayList();
			}
			lst.add(fs.getFunction().getId());
			map.put(key, lst);
		}
		
		
		return list;
	}
	
	
	private List<Functions> getFunctions(HibernateTemplate template){
		
	List<Functions> list =	template.executeFind(new HibernateCallback() {
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				Subproducts s = new Subproducts();
				s.setId(new Long(2));
				s.setSubProductCode("LB");
				Query q = session.createQuery("select distinct f from Functions f join f.subproducts fs where fs.id = 2 ");
				return q.list();
			}
		});
		
	System.out.println("List Size " + list.size());
	

		return list;
	}
	
	
	private void functions_subproducts(HibernateTemplate template, ApplicationContext context){
		
		
			
				SessionFactory factory = (SessionFactory) context.getBean("mySessionFactory");
				
				Session session = factory.openSession();
				session.beginTransaction();
				
				Functions f = new Functions();
				//f.setId(1001);
				f.setFunctionCode("A");
			

				Functions f2 = new Functions();
				//f2.setId(1111);
				f2.setFunctionCode("B");
				
				
				Subproducts s = new Subproducts();
				//s.setId(1122);
				s.setSubProductCode("MV");
				

				Subproducts s2 = new Subproducts();
				//s2.setId(1129);
				s2.setSubProductCode("VB");
				
				Set<Subproducts> set = new HashSet<Subproducts>();
				set.add(s);
				set.add(s2);
				
				
				f.setSubproducts(set);
				
				
				try{
					
				template.saveOrUpdate(f);
		
				//session.save(f);
				
				System.out.println("done ");
				}catch (Exception e) {
					e.printStackTrace();
				}
	}
	
	private void doJoin(HibernateTemplate template){
		List<Department> deptList = template.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {         
				String qurey1 = "select dept from Department dept join Test t on dept.dept.departmentId=t.dept_id where dept.departmentId=1";
				// join test t where t.dept_id in (1)";
				
				String qurey123 = "select distinct test from Test test";
				String q123="select d.* from department d join test t on d.dept_id=t.dept_id where t.dept_id = :deptId";
				
				Query q = session.createSQLQuery(q123).addEntity(Department.class);
				q.setParameter("deptId", 2);
				
				//Query q = session.createQuery(qurey1);
				List lst = q.list();
				
				
				return lst;
			}
		});
		
		System.out.println(deptList.size());
		
		for(Department d : deptList){
			System.out.println("Department Id " + d.getDepartmentId() + " Department Name " + d.getDepartmentName());
		}
	}
	
	private void deTest(HibernateTemplate template){
		
		/*
		
		List<Test> testList = template.executeFind(new HibernateCallback() {
			
			@Override
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {         
			//	String qurey1 = "select distinct dept from Department dept join test t where t.dept_id in (1)";
				
				String qurey1 = "select distinct test from Test test";
				
				Query q = session.createQuery(qurey1);
				List lst = q.list();
				
				return lst;
			}
		});
		
		*/
	//	System.out.println("List " + testList.size());
	}
	private void doDepartment(HibernateTemplate template) {

		template.execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {

				Department department = new Department();
				department.setDepartmentName("Sales");
				session.save(department);

				Employee emp1 = new Employee("Nina", "Mayers", new Date(), "1212");
				Employee emp2 = new Employee("Tony", "Almeida",new Date(), "4343");

				emp1.setDepartment(department);
				emp2.setDepartment(department);

				session.save(emp1);
				session.save(emp2);

				return null;
			}
		});

	}

	private void saveStudent(HibernateTemplate template) {

		template.execute(new HibernateCallback() {

			@Override
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				Set<Course> courses = new HashSet<Course>();
				courses.add(new Course("Maths"));
				courses.add(new Course("Computer Science"));
				Student student1 = new Student("Samatha", courses);
				Student student2 = new Student("Gangadhar", courses);
				session.save(student2);
				return session.save(student1);
			}
		});
	}

}
