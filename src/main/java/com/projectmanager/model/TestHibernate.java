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
import java.util.*;

public class TestHibernate {

	private static SessionFactory sessionFactory;

	public static void main(String[] args)
	{
		int[] arr = {1,1,2,3,3};

		int n = arr.length;
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < n; i++) {
			int count = 0;
			if (map.get(arr[i]) != null) {
				count = map.get(arr[i]);
			}
			map.put(arr[i], count + 1);
		}

		int sum = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() % 2 == 0) {
				sum += entry.getKey();
			}
		}

		System.out.println(sum);
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
