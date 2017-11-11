package edu.utcluj.track.position;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author radu.miron
 * @since 18.10.2016
 */
@Service
public class PositionService {
    @Autowired
    private PositionRepository positionRepository;

    //String terminalId
    //, Date startDate, Date endDate
    public List<Position> readPosition() { return positionRepository.findAll(); }

    public Position readPositionFromTerminal(String terminalId) { return positionRepository.findByTerminalId(terminalId); }

    public Position createPositionService(Position p){return positionRepository.save(p);}

    public void updatePositionService(Position p){
        positionRepository.updatePosition(p.getTerminalId(),p.getLongitude(),p.getLatitude());
    }

    public void deletePositionService(String terminalId){
        positionRepository.delete(terminalId);}




    //    public Position readPosition(Position position) {
//        return positionRepository.findOne(position.getId());
//    }
//
//    public Position updatePosition(Position position, long id) {
//
//        Position newPosition = positionRepository.findOne(id);
//        newPosition.setLatitude("12");
//        return positionRepository.save(newPosition);
//    }
//
//    public void deletePosition(Position position) {
//        positionRepository.delete(position.getId());
//    }



}
