package com.task.MapStruct;


import com.task.MapStruct.dto.MapSDto;
import com.task.MapStruct.entity.MapS;
import org.springframework.stereotype.Repository;

@Repository("MapImp")
public class MapImp implements Configs{
    @Override
    public MapSDto mapToDto(MapS maps) {
        if (maps == null ){
            return null;
        }


        MapSDto mapSDto = new MapSDto();
        mapSDto.setName(maps.getName());
        mapSDto.setId(maps.getId());
        return mapSDto;
    }
}
