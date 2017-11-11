package edu.utcluj.track.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
public interface PositionRepository extends JpaRepository<Position, Long> {





   @Query("SELECT p from Position p where p.terminalId = :terminalId")
   Position findByTerminalId(@Param("terminalId") String terminalId);

   @Transactional
   @Modifying
   @Query("UPDATE  Position  SET  longitude = :longitude , latitude = :latitude  where terminalId = :terminalId")
   void updatePosition(@Param("terminalId") String terminalId ,@Param("longitude") String longitude ,@Param("latitude") String latitude);


   @Transactional
   @Modifying
   @Query("DELETE from  Position p where p.terminalId = :terminalId")
   void delete(@Param("terminalId") String terminalId);


}
