package ru.mk.yandextaxi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.mk.yandextaxi.model.MomentPrice;

@Repository
public interface PriceRepository extends JpaRepository<MomentPrice, Long> {}
