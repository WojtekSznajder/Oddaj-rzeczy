package pl.coderslab.charity.dao;

import pl.coderslab.charity.entity.Donation;

public class DonationDao extends GenericDao<Donation> {

    public DonationDao() {
        super(Donation.class);
    }
}
