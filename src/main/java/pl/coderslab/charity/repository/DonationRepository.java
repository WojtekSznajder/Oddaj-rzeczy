package pl.coderslab.charity.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.charity.entity.Donation;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {


    @Query("select count (d.institution) from Donation d")
    int quantityOfDonatedInstitutions();

    @Query("select sum(d.quantity) from Donation d")
    int sumOfBags();

    @Query("select (d.institution) from Donation d")
    List<Institution> allInstitutions();
}
