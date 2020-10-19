package br.com.bootcamp.casadocodigo.api.validator;

import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistentFieldValidator implements ConstraintValidator<ExistentField, Object> {
    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(ExistentField params) {
        domainAttribute = params.fieldName();
        klass = params.domainClass();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Query query = manager.createQuery("select 1 from "+klass.getName()+" where "+domainAttribute+"=:value");
        query.setParameter("value", value);
        List<?> list = query.getResultList();
        Assert.state(!list.isEmpty(),
                "Não foi encontrado nenhum "+klass.getSimpleName()+" com o atributo "+domainAttribute+" = "+value);

        return Boolean.TRUE;
    }
}
