package com.task.MapStruct.service;


import com.task.MapStruct.Configs;
import com.task.MapStruct.dto.MapSDto;
import com.task.MapStruct.entity.MapS;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ConvertMap {

    private final Configs configs;

    public ConvertMap(
            @Qualifier("MapImp") Configs configs
    ) {
        this.configs = configs;
    }



    public MapSDto val(){
        MapS mapS = new MapS();
        mapS.setId(1L);
        mapS.setName("Osamah");
        return configs.mapToDto(mapS);
    }
}
