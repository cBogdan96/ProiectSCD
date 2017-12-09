package edu.utcluj.track.position;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
public interface PositionRepository extends JpaRepository<Position, Long> {

//   @Query("select p FROM Position p where p.terminalId = :terminalId" + " AND  p.createTime BETWEEN :startDate AND :endDate")
//   List<Position> findByTerminalId(@Param("terminalId")String terminalId,@Param("startDate") Date startDate, @Param("endDate") Date endDate);

   @Query("SELECT p FROM Position p WHERE p.terminalId = :terminalid" +
           " AND p.createTime BETWEEN :startdate AND :enddate")
   List<Position> findByTerminalIdAndStartDateAndEndDate(@Param("terminalid") String terminalid, @Param("startdate") Date startDate,
                                                         @Param("enddate") Date endDate);

//   @Transactional
//   @Modifying
//   @Query("UPDATE  Position  SET  longitude = :longitude , latitude = :latitude  where terminalId = :terminalId")
//   void updatePosition(@Param("terminalId") String terminalId ,@Param("longitude") String longitude ,@Param("latitude") String latitude);


//   @Transactional
//   @Modifying
//   @Query("DELETE from  Position p where p.terminalId = :terminalId")
//   void delete(@Param("terminalId") String terminalId);


}
