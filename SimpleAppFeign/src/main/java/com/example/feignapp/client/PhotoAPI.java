package com.example.feignapp.client;

import com.example.feignapp.entity.Photo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(value = "photo-consumer",
        url = "https://jsonplaceholder.typicode.com/")
public interface PhotoAPI {

    @GetMapping(value = "/photos")
    List<Photo> getPhotos();

    @GetMapping(value = "/photos/{id}")
    Photo getPhotoID(@PathVariable("id") Long id);

}
