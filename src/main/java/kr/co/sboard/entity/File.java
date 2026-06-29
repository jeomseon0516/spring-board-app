package kr.co.sboard.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import kr.co.sboard.dto.FileDTO;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fno;
    private int ano;
    private String ofname;
    private String sfname;
    private int download;

    @CreationTimestamp
    private LocalDateTime rdate;

    public FileDTO toDTO(){
        return FileDTO.builder()
            .fno(fno)
            .ano(ano)
            .ofname(ofname)
            .sfname(sfname)
            .download(download)
            .rdate(rdate.toString())
            .build();
    }

}