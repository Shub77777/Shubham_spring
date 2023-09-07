package com.example.bat.exception;


import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
	
	String message;
	int statuscode;
	LocalDateTime datetime;

}
