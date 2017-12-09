package edu.utcluj.track.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    public List<Position> readPosition() { return positionRepository.findAll(); }

    public List<Position> readPositionFromTerminal(String terminalId, Date startDate, Date endDate) { return positionRepository.findByTerminalIdAndStartDateAndEndDate(terminalId,startDate,endDate); }

    public Position save(Position p){return positionRepository.save(p);}

    public void deletePositionService(Long id){
        positionRepository.delete(id);}
}
