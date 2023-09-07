package com.example.bat.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bookdetails")

public class Books {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		long id;
		@Column(nullable = false,unique=true)
		@NotEmpty(message = "Title Can Not Be Empty")
		@Size(min =3 ,message = "Title Must be more than 3 chars")
		String title;
		String author;
		@Column(name="Publish")
		boolean published;


}
