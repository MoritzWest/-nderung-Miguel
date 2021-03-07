package BE219Thenextchapter.mapper;

import BE219Thenextchapter.dto.BusDTO;
import BE219Thenextchapter.dto.BusLineDTO;
import BE219Thenextchapter.model.Bus;
import BE219Thenextchapter.model.BusLine;
import BE219Thenextchapter.model.BusPlan;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BusMapper {

    @Mapping(target = "busPlanIds", source = "busPlans")
    BusDTO busToBusDTO(Bus bus);

    List<BusDTO> busToBusDTOs(List<Bus> bus);

    Bus busDTOToBus(BusDTO busDTO);

    List<Bus> busDTOsToBus(List<BusDTO> busDTOS);

    default Long map(BusPlan busPlan) {
        return busPlan.getId();
    }
}


    /*
    @Mapper(componentModel = "spring")
public interface BusMapper {

   //die Ids der BusLinien werden in die Variable BusRouteIds geschrieben -> mapping
    //@Mapping(target = "busIds", source = "busPlans") //Ids aus source werden auf target also DTO gemapped, target kommt aus DTO, source aus model
    BusDTO busToBusDTO(Bus bus);
    List<BusDTO> bussesToBusDTOs(List<Bus> busses);

    Bus busDTOToBus (BusDTO busDTO);
    List<Bus> busDTOsToBusses (List<BusDTO> busDTOs);

    //holt die Ids des Busfahrplans
    default Long map(BusPlan busPlan){
        return busPlan.getId();
     }

}
*/