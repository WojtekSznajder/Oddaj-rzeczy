package pl.coderslab.charity.dao;

import pl.coderslab.charity.entity.Institution;

public class InstitutionDao extends GenericDao<Institution> {

    public InstitutionDao() {
        super(Institution.class);
    }
}
