package com.example.feignapp;

import com.example.feignapp.client.PhotoAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FeignAppApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FeignAppApplication.class, args);
	}

	@Autowired
	private PhotoAPI photoAdapter;

	@Override
	public void run(String... args) throws Exception {

		//System.out.println(this.photoAdapter.getPhotoID(3L));

		System.out.println(this.photoAdapter.getPhotos().subList(0,10));

	}
}
