package com.projectmanager.model;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.projectmanager.entity.Project;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class TestHibernate {

	private static SessionFactory sessionFactory;

	public static void main(String[] args) {

		try
		{
			System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(new Date()));
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
/*		try {
			Configuration configuration = new Configuration();
			configuration.addAnnotatedClass(com.projectmanager.entity.Project.class);
			
			sessionFactory = configuration.configure().buildSessionFactory();
			Project proj = new Project();
			proj.setProjectDesc("first project description..!!");
			proj.setProjectName("Hamsule");

			int projId = new TestHibernate().addProject(proj);
			
			System.out.println("Added a projet with Id : "+projId);*/

			/*String[] description = {"1","2","3","4","5","6","7","8","9","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27"};
			ArrayList<String[]> descriptionList = new ArrayList<>();

			int pages = Math.round(description.length/10)+1;

			try {
				for (int i = 0; i < pages; i++) {

					int end = 10 * i + 9;
					if (description.length < 10 * i + 10) {
						end = description.length - 1;
					}

					//System.arraycopy(description, 10 * i, newArray, 10 * i, newArray.length);

					String[] newArray = Arrays.copyOfRange(description,10 * i, end);

					descriptionList.add(newArray);
				}
			}
			catch(Exception ex)
			{
				System.out.println("Done");
			}

			System.out.println(" descriptionList size is : "+descriptionList.size());
			int index=0;
			for(String[] oldArray : descriptionList)
			{
				System.out.println("Index is : "+index);
				for(int j=0;j<oldArray.length;j++)
				{
					System.out.print(oldArray[j]+"-");
				}
			}

		} catch (Exception ex) {
			ex.printStackTrace();
		}*/
	}

	public int addProject(Project proj) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		int projectId = 99999;
		try {
			tx = session.beginTransaction();
			projectId = (int) session.save(proj);
			tx.commit();
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return projectId;
	}
}
