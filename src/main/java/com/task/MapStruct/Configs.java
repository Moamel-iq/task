package com.task.MapStruct;


import com.task.MapStruct.dto.MapSDto;
import com.task.MapStruct.entity.MapS;
import org.mapstruct.Mapper;

@Mapper
public interface Configs {

    MapSDto mapToDto(MapS maps);//(User user)
}
