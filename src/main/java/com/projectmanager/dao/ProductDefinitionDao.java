package com.projectmanager.dao;

import com.projectmanager.entity.ProductDefinition;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductDefinitionDao
{
    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public boolean saveProductDefinition(ProductDefinition productDefinition)
    {
        boolean productSaved = true;
        try
        {
            Session session = sessionFactory.getCurrentSession();
            session.saveOrUpdate(productDefinition);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            productSaved = false;
        }
        return productSaved;
    }

    @Transactional
    public ArrayList<ProductDefinition> getAllProductDefinition()
    {
        ArrayList<ProductDefinition> productList = new ArrayList<>();

        try
        {
            Session session = sessionFactory.getCurrentSession();
            productList = (ArrayList<ProductDefinition>) session.createQuery("FROM ProductDefinition").getResultList();
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }

        return productList;
    }

    @Transactional
    public ArrayList<String> getAssociatedOptions(String product, String material, String manufactureMethod, String detailToSelect )
    {
        ArrayList<String> associatedValues = new ArrayList<String>();
        Session session = null;
        String selectHql = "";
        boolean isSingleResult = true;

        System.out.println(" String product, String material, String manufactureMethod, String detailToSelect : " + product +", " + material +", "+ manufactureMethod +", " + detailToSelect );

        if (product == null)
        {
            selectHql = "SELECT distinct PD.productId.product FROM ProductDefinition PD";
            isSingleResult = false;
        }
        else if (material.trim().equals(""))
        {
            selectHql = "SELECT distinct PD.productId.materialOfConstruction FROM ProductDefinition PD where PD.productId.product='" + product + "'";
            isSingleResult = false;
        }
        else if(manufactureMethod.trim().equals(""))
        {
            selectHql = "SELECT distinct PD.productId.manufactureMethod  FROM ProductDefinition PD where PD.productId.product='" + product + "' and PD.productId.materialOfConstruction='"+material+"'";
            isSingleResult = false;
        }
        else
            {
                selectHql = "SELECT distinct PD." + detailToSelect + " FROM ProductDefinition PD where PD.productId.product='" + product + "' and PD.productId.materialOfConstruction='"+material+"' and PD.productId.manufactureMethod='"+manufactureMethod+"'";
            }

        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery(selectHql);

            String result = "";

            if(isSingleResult)
            {
                result = (String)query.getSingleResult();

                if(result.contains(","))
                {
                    associatedValues = new ArrayList<>(Arrays.asList(result.split(",")));
                }
                else
                {
                    associatedValues.add(result);
                }
            }
            else
            {
                associatedValues = (ArrayList<String>)query.getResultList();
            }

        } finally {
            session.close();
        }
        return associatedValues;
    }

    @Transactional
    public ArrayList<ProductDefinition> getProductDetails(String product, String materialOfConstruction, String manufactureMethod) {

        Session session = sessionFactory.getCurrentSession();
        String sql ="from ProductDefinition where product =: product and materialOfConstruction=: materialOfConstruction and manufactureMethod=:manufactureMethod";
        Query query = session.createQuery(sql);
        query.setParameter("product", product);
        query.setParameter("materialOfConstruction",materialOfConstruction);
        query.setParameter("manufactureMethod", manufactureMethod);
        List productList = query.getResultList();
        return (ArrayList<ProductDefinition>) productList;
    }
    @Transactional
    public void updateProductDefination(String product, String materialOfConstruction, String manufactureMethod, String materialSpecs, String classOrSch, String standardType) {
        Session session = sessionFactory.getCurrentSession();
        String sql ="update ProductDefinition set materialSpecs =:materialSpecs , classOrSch =:classOrSch , standardType =:standardType where product =: product and materialOfConstruction=: materialOfConstruction and manufactureMethod=:manufactureMethod";
        Query query = session.createQuery(sql);
        query.setParameter("product", product);
        query.setParameter("materialOfConstruction",materialOfConstruction);
        query.setParameter("manufactureMethod", manufactureMethod);
        query.setParameter("materialSpecs",materialSpecs);
        query.setParameter("classOrSch",classOrSch);
        query.setParameter("standardType",standardType);

        query.executeUpdate();
    }
}
