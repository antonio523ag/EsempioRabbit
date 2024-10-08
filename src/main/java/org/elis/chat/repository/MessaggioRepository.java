package org.elis.chat.repository;

import org.elis.chat.model.Messaggio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessaggioRepository extends JpaRepository<Messaggio, Long> {

}
