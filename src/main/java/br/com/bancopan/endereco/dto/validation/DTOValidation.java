package br.com.bancopan.endereco.dto.validation;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;

import com.google.common.collect.Lists;


public class DTOValidation {

    public void validate(Class<?>... groups) {
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Class<?>[] groupsArray = incluirGrupo(groups, Default.class);
        Set<ConstraintViolation<DTOValidation>> constraintViolations = validator.validate(this, groupsArray);

        if (!constraintViolations.isEmpty()) {
            throw new ConstraintViolationException(constraintViolations);
        }
    }

    private Class<?>[] incluirGrupo(Class<?>[] groups, Class<?>... novosGroups) {
        List<Class<?>> groupsList = Lists.newArrayList(groups);
        groupsList.addAll(Lists.newArrayList(novosGroups));
        return groupsList.toArray(new Class[0]);
    }
    
    
}