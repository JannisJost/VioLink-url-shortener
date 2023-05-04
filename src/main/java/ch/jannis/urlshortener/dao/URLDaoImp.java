package ch.jannis.urlshortener.dao;

import ch.jannis.urlshortener.model.URL;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class URLDaoImp implements URLDao {
    @Autowired
    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public URL generateUrl(URL url) {
        int nextID = getLastID() + 1;
        URL attachedURL = entityManager.merge(url);
        entityManager.persist(attachedURL);
        return url;
    }

    @Transactional
    public int getLastID() {
        String jpql = "SELECT MAX(url.id) FROM URL url";
        TypedQuery<Long> query = entityManager.createQuery(jpql, Long.class);
        Long id = query.getSingleResult();
        return id == null ? 0 : id.intValue();
    }

    @Override
    public URL getURLByID(String id) {
        TypedQuery<URL> query = entityManager.createQuery(
                "SELECT url FROM URL url WHERE url.shortenedID LIKE :attributeValue", URL.class);
        query.setParameter("attributeValue", id);
        List<URL> results = query.getResultList();
        System.err.println(results.size());
        if (!results.isEmpty()) {
            System.out.println("isnt empty");
            for (URL url : results) {
                if (url.getShortenedID().equals(id) ) {
                    System.out.println("MATCH");
                    return url;
                }
            }
        }
        return new URL();
    }

    @Override
    public List<URL> getUrlList() {
        return null;
    }
}
