package com.util;

import com.model.entity.CustomerMaster;
import com.model.entity.CustomerTemp;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AvailableSettings;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                // Hibernate settings equivalent to hibernate.cfg.xml's properties
                Properties settings = new Properties();
                settings.put(AvailableSettings.DRIVER, "oracle.jdbc.driver.OracleDriver");
                settings.put(AvailableSettings.URL, "jdbc:oracle:thin:training@//10.1.50.198:1535/nsbt19c");
                settings.put(AvailableSettings.USER, "training");
                settings.put(AvailableSettings.PASS, "training");
                settings.put(AvailableSettings.DIALECT, "org.hibernate.dialect.Oracle10gDialect");

                settings.put(AvailableSettings.SHOW_SQL, "true");
                settings.put(AvailableSettings.POOL_SIZE, 10);
//                settings.put(AvailableSettings.HBM2DDL_AUTO, "create");

                configuration.setProperties(settings);

                configuration.addAnnotatedClass(CustomerMaster.class);
                configuration.addAnnotatedClass(CustomerTemp.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private HibernateUtil(){}
}
