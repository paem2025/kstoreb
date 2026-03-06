package com.latiendadekellyb.demo.domain.repository;

import com.latiendadekellyb.demo.domain.model.LandingSettingsEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LandingSettingsRepository extends JpaRepository<LandingSettingsEntity, String> {

    Optional<LandingSettingsEntity> findBySlug(String slug);
}
