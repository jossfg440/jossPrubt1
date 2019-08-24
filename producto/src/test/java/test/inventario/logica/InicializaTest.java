/*
 * Clase InicializaTest.java 21 de ago. de 2019
 * Copyright 2019 jossfg440
 * 
 */
package test.inventario.logica;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Inicializacion test 
 *
 * @author jossfg440
 *
 */
@RunWith(MockitoJUnitRunner.class)
public abstract class InicializaTest {

    protected static EntityManagerFactory entityManagerFactory;
    protected static EntityManager entityManager;

    @BeforeClass
    public static void init() throws FileNotFoundException, SQLException {
        entityManagerFactory = Persistence.createEntityManagerFactory("db-test");
        entityManager = entityManagerFactory.createEntityManager();
    }

    @AfterClass
    public static void tearDown() {
        entityManager.clear();
        entityManager.close();
        entityManagerFactory.close();
    }

    protected Object persistirObjeto(Object objeto) {
        entityManager.getTransaction().begin();
        entityManager.merge(objeto);
        entityManager.getTransaction().commit();
        return objeto;
    }
    
    protected Object persistirObjetoInicial(Object objeto) {
    	entityManager.getTransaction().begin();
    	entityManager.persist(objeto);
    	entityManager.getTransaction().commit();
        return objeto;
    }
    
    
}
