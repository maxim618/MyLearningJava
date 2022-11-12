package com.dmdev;

import com.dmdev.converter.BirthdayConverter;
import com.dmdev.entity.Birthday;
import com.dmdev.entity.Role;
import com.dmdev.entity.User;
import com.dmdev.type.JsonType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.internal.SessionFactoryServiceRegistryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.sql.SQLException;
import java.time.LocalDate;
@Slf4j
public class HibernateRunner {
//	private static final Logger logger = LoggerFactory.getLogger(HibernateRunner.class);

	public static void main(String[] args) throws SQLException {
//        BlockingDeque<Connection> pool = null;
//        Connection connection = pool.take();
//        SessionFactory

//        Connection connection = DriverManager
//                .getConnection("db.url", "db.username", "db.password");
//        Session
		Configuration configuration = new Configuration();
//		configuration.addAnnotatedClass(User.class);
//		configuration.setPhysicalNamingStrategy(new CamelCaseToUnderscoresNamingStrategy());
		configuration.registerTypeOverride(new JsonBinaryType());
		configuration.addAttributeConverter(new BirthdayConverter());
		configuration.configure();

		User user = User.builder()
				.username("Ivan555@gmail.com")
				.firstname("Ivan")
				.lastname("Ivanov")
				.info("""
                            {
                            "name": "Ivan",
                            "id": 25
                            }
                            """)
				.birthDate(new Birthday(LocalDate.of(2000, 1, 19)))
				.role(Role.ADMIN)
				.build();

		try (SessionFactory sessionFactory = configuration.buildSessionFactory()){
			Session session = sessionFactory.openSession();
			try (session) {
				Transaction transaction = session.beginTransaction();
				log.trace("Transaction is created, {}",transaction);

				log.info("User entity is in transient state, object:{}", user);
				session.saveOrUpdate(user);
				log.trace("User in persistent state: {}, session: {}", user, session);
//			User user = session.get(User.class, "Ivan2@gmail.com");
				session.getTransaction().commit();

			}
			log.warn("User is in detached state: {}, session is close: {}",user, session);
		}catch (Exception exception) {
			log.error("exception occurred", exception);
			throw exception;
		}

	}
}
