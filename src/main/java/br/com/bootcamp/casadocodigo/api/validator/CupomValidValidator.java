package br.com.bootcamp.casadocodigo.api.validator;

import br.com.bootcamp.casadocodigo.domain.model.Cupom;
import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.util.List;

public class CupomValidValidator implements ConstraintValidator<CupomValid, Object> {

    private String domainAttribute;
    private Class<?> klass;
    @PersistenceContext
    private EntityManager manager;

    @Override
    public void initialize(CupomValid params) {
        domainAttribute = "codigo";
        klass = Cupom.class;
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if(value != null){
            Query query = manager.createQuery("select 1 from "+klass.getName()+" " +
                    "where "+domainAttribute+"=:value and validade >=:data");
            query.setParameter("value", value);
            query.setParameter("data", LocalDate.now());

            List<?> list = query.getResultList();
            Assert.state(!list.isEmpty(),
                    "Não foi encontrado nenhum "+klass.getSimpleName()+" " +
                            "válido com o atributo "+domainAttribute+" = "+value);
        }
        return Boolean.TRUE;
    }
}
