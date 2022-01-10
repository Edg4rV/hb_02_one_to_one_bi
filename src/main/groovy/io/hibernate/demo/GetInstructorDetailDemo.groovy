package io.hibernate.demo

import io.hibernate.config.HibernateConfig
import io.hibernate.entity.Instructor
import io.hibernate.entity.InstructorDetail
import org.hibernate.Session
import org.hibernate.SessionFactory
import org.springframework.context.annotation.AnnotationConfigApplicationContext

class GetInstructorDetailDemo {
    static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);

        SessionFactory sessionFactory = context.getBean("sessionFactory")


        Session session = sessionFactory.getCurrentSession()

        try {

            session.beginTransaction()

            int theId = 2

            InstructorDetail tempInstructorDetail =
                    session.get(InstructorDetail.class, theId)

            println "tempInstructorDetail: ${tempInstructorDetail}"

            println "the associated instructor: ${tempInstructorDetail.getInstructor()}"

            session.getTransaction().commit()

            println "Done"
        } finally {
            sessionFactory.close()
        }
        context.close()
    }
}
