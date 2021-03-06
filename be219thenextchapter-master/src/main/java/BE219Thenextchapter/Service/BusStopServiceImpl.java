
package BE219Thenextchapter.Service;

import BE219Thenextchapter.dto.BusStopDTO;
import BE219Thenextchapter.mapper.BusStopMapper;
import BE219Thenextchapter.model.BusStop;
import BE219Thenextchapter.repository.BusStopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusStopServiceImpl implements BusStopService{

    BusStopMapper busStopMapper;
    BusStopRepository busStopRepository;

    public BusStopServiceImpl(BusStopMapper busStopMapper, BusStopRepository busStopRepository){
        this.busStopMapper = busStopMapper;
        this.busStopRepository = busStopRepository;
    }


    //Implementierung der CRUD-Methoden

    //Read all
    @Override
    public List<BusStopDTO> getAll() {
        List<BusStop> busStops = this.busStopRepository.findAll();
        List<BusStopDTO> busStopDTOS = this.busStopMapper.busStopsToBusStopDTOs(busStops); //übergibt die darüber angelegte busStop Liste an die Methode im Mapper
        return busStopDTOS;
    }

    //Read by Id
    @Override
    public BusStopDTO getBusStopById(long id) {
        BusStop busStop = this.busStopRepository.findById(id).get();
        BusStopDTO busStopDTO = this.busStopMapper.busStopToBusStopDTO(busStop);
        return busStopDTO;
    }

    //Create
    @Override
    public BusStopDTO addBusStop(BusStopDTO busStopDTO) {
        BusStop busStop = this.busStopMapper.busStopDTOToBusStop(busStopDTO);
        this.busStopRepository.save(busStop);
        return this.busStopMapper.busStopToBusStopDTO(busStop);

    }

    //Update
    @Override
    public BusStopDTO updateBusStop(BusStopDTO busStopDTO) {
        BusStop busStop = this.busStopMapper.busStopDTOToBusStop(busStopDTO);
        this.busStopRepository.save(busStop);
        return this.busStopMapper.busStopToBusStopDTO(busStop); //Umwandlung und Rückgabe des Objekts in DTO über die Mapper-Methode
        }


    //Delete
    @Override
    public void removeBusStopById(long id) {
        this.busStopRepository.deleteById(id);
    }
}