package app.filters;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.SessionFactoryUtils;
import org.springframework.orm.hibernate5.SessionHolder;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})
public class HibernateSessionRequestFilter extends OncePerRequestFilter {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    protected void initFilterBean() {
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(
                this,
                getServletContext()
        );
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        Session session = sessionFactory.openSession();
        SessionHolder sessionHolder = new SessionHolder(session);
        TransactionSynchronizationManager
                .bindResource(sessionFactory, sessionHolder);
        try {
            chain.doFilter(request, response);
        } finally {
            sessionHolder = (SessionHolder) TransactionSynchronizationManager
                            .unbindResource(sessionFactory);
            SessionFactoryUtils.closeSession(sessionHolder.getSession());
        }
    }

    @Override
    public void destroy() {
    }
}
