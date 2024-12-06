package com.msitec.gestao.repositories;

import org.hibernate.query.Page;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PagingAndSortingRepository {

    @Query("FROM ClientModel c " +
            "WHERE LOWER(c.nome) like %:searchTerm% ")

    Page<ClientModel> search(
            @Param("searchTerm") String searchTerm,
            Pageable pageable);

}
