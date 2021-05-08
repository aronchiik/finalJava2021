package kz.iitu.Repository;

import kz.iitu.Model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CientRepository extends JpaRepository<Clients,Long> {
}
